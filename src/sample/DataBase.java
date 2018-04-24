package sample;

import com.mysql.jdbc.StringUtils;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {



    private String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=kattmat!"; //githost address
    private Statement st;
    private Connection c;



    //TODO planera databasen, hur vill vi ha den (Till en början i alla fall)

    public DataBase() {

        try {
            c = DriverManager.getConnection(url);
            st = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database!");
        }
    }


    public void createUser(String userName,String userEmail, int password){

        try {

            ResultSet rs = this.st.executeQuery("SELECT userEmail FROM user");

            if (rs.next()){

                String foundType = rs.getString("userEmail");

                if (foundType.equals(userEmail)) {
                    System.out.println("ALREADY IN USE");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Email already in use");
                    alert.setHeaderText("Please use another email");
                    alert.setContentText(userEmail + " is already in use");
                    alert.showAndWait();

                }
                else {
                PreparedStatement addUser = c.prepareStatement("INSERT INTO user (userName, userEmail, password) VALUES ( ?, ?, ?)");

                addUser.setString(1, userName);
                addUser.setString(2, userEmail);
                addUser.setInt(3, password);
                addUser.execute();

                System.out.println("INSERT INTO user (userName, userEmail, password) VALUES (" + userName + ", " + userEmail + ", " + password + ")");
            }}






        }catch (SQLException ex){

            ex.printStackTrace();
            System.out.println(ex);

        }
    }
/*    public void createUser(String uName,String eMail){
        try {
            System.out.println(uName+eMail);
            st.execute("INSERT INTO user "+ "(userName , userEmail)"+"VALUES('"+uName+"','"+eMail+"')");

        } catch (SQLException e) {
            System.out.println("INSERT INTO user"+ "VALUES('"+uName+"','"+eMail+"')");
            e.printStackTrace();
        }
    }*/

    public void GuestLogIn(){
        try {
            st.execute("INSERT INTO guest (guestName) VALUES ('Guest')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void addItem(String name, String type, Integer price){


        try {
            st.execute("INSERT INTO " + type + "VALUES (" + price + ", " + name +  ")");
        }catch(Exception ex){
            System.out.println("something went wrong ");

        }
    }

    public ArrayList<String> showItems() {                                                       //SELECT statement. ResultSet används och executeQuery
        int index = 0;
        int one = 1;
        ArrayList<String> items= new ArrayList<>();


        try {

            boolean test=false;
            //while (rs.getString("namn").equals(null)) {
            //ResultSet rs2 = this.st.executeQuery("SELECT * FROM KATTMAT LIMIT "+index+","+one);


            //while(test==false) {
            for(int i=0;i<5;i++){
                ResultSet rs = this.st.executeQuery("SELECT * FROM KATTMAT LIMIT " + index + "," + one);


                while (rs.next()) {
                    // System.out.println(rs.getString(3));                    //Column index = vilken kolumn i databasen
                    int pris = rs.getInt("pris");
                    String namn = rs.getString("namn");
                    System.out.printf(namn + " " + pris);

                    items.add(namn+" "+pris);

                    index++;
                    test=rs.getString("namn").equals("");


                    System.out.println();



                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }







    public void getProductId(){


        try {

            ResultSet rs = this.st.executeQuery("SELECT gc ");

        }catch (Exception e){

        }

    }

    public void updateProductName(String tabName, String colName, String valueOne, String newValue) {   //TODO metod för att uppdatera ett pris på en produkt, kommer behövas en metod för att få fram id på en produkt,

        try {
            st.execute("UPDATE " + tabName + "SET " + colName  + "='" + valueOne + "'" + " WHERE"   );


        } catch (Exception e) {

        }
    }

}
