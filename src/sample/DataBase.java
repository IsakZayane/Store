package sample;

import javafx.scene.control.Alert;

import java.sql.*;

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


    public void createUser(String userName, String userEmail, int password) {

        try {

            ResultSet rs = this.st.executeQuery("SELECT userEmail FROM user");

            if (rs.next()) {

                String foundType = rs.getString("userEmail");

                if (foundType.equals(userEmail)) {
                    System.out.println("ALREADY IN USE");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Email already in use");
                    alert.setHeaderText("Please use another email");
                    alert.setContentText(userEmail + " is already in use");
                    alert.showAndWait();

                } else {
                    PreparedStatement addUser = c.prepareStatement("INSERT INTO user (userName, userEmail, password) VALUES ( ?, ?, ?)");

                    addUser.setString(1, userName);
                    addUser.setString(2, userEmail);
                    addUser.setInt(3, password);
                    addUser.execute();

                    System.out.println("INSERT INTO user (userName, userEmail, password) VALUES (" + userName + ", " + userEmail + ", " + password + ")");
                }
            }


        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println(ex);

        }
    }

    public void memberLogIn(String name,int password) {
        try {
            String query = "select username,password from user where username = ? and password = ?";
            PreparedStatement login =c.prepareStatement(query);
            login.setString(1,name);
            login.setInt(2,password);
           ResultSet rs = login.executeQuery();
            String username = null;
            int pass = 0;
            while (rs.next()){
                username = rs.getString("userName");
                pass = rs.getInt("password");



            }
            if (username.equals(name) && pass==password){
                System.out.println("name found");
            }

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Memeber name and/or password");
            alert.setHeaderText("Re-enter password and/or Member name");
            alert.showAndWait();

        }




    }


















    public void GuestLogIn() {
        try {
            st.execute("INSERT INTO guest (guestName) VALUES ('Guest')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addItem(String name, String type, Integer price) {


        try {
            st.execute("INSERT INTO " + type + "VALUES (" + price + ", " + name + ")");
        } catch (Exception ex) {
            System.out.println("something went wrong ");

        }
    }

    public String showItems()  {//SELECT statement. ResultSet används och executeQuery
            try {
            ResultSet rs= this.st.executeQuery("SELECT * FROM KATTMAT");

            //ResultSet rs = this.st.executeQuery("SELECT * FROM KATTMAT");
                while (rs.next()) {
                int pris = rs.getInt("pris");
                String namn = rs.getString("namn");
                System.out.printf("%s,%s\n", pris, namn);

               //tring s = rs.getString("pris") + rs.getString("namn");

          return pris+namn;

         }

    }catch (SQLException e){
                e.printStackTrace();
            }
            finally {
        return showItems();

                }
            }


            //Column index = vilken kolumn i databasen

            public void getProductId () {


                try {

                    ResultSet rs = this.st.executeQuery("SELECT gc ");

                } catch (Exception e) {

                }

            }



    public void updateProductName(String tabName, String colName, String valueOne, String newValue) {   //TODO metod för att uppdatera ett pris på en produkt, kommer behövas en metod för att få fram id på en produkt,

        try {
            st.execute("UPDATE " + tabName + "SET " + colName  + "='" + valueOne + "'" + " WHERE"   );


        } catch (Exception e) {

        }
    }

}
