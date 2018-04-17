package sample;

import java.sql.*;

public class DataBase {


    String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=kattmat!"; //githost address
    Statement st;

    //TODO planera databasen, hur vill vi ha den (Till en början i alla fall)

    public DataBase() {

        try {
            Connection c = DriverManager.getConnection(url);
            st = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database!");
        }
    }

    public void addItem(String name, String type, Integer price){


        try {
            st.execute("INSERT INTO " + type + "VALUES (" + price + ", " + name +  ")");
        }catch(Exception ex){
            System.out.println("something went wrong ");

        }
    }

    public void showItems() {                                                       //SELECT statement. ResultSet används och executeQuery

        try {

            ResultSet rs = this.st.executeQuery("SELECT * FROM KATTMAT");
            System.out.println();

            while (rs.next()) {
                System.out.println(rs.getString(2));                    //Column index = vilken kolumn i databasen
            }


        } catch (Exception ex) {


        }
    }


    public void getUpdate() {   //test metod

        try {

            st.executeUpdate("UPDATE kattMat SET kattmatvikt='5446' WHERE kattMat_id = '1' ");

        } catch (Exception ex) {

            System.out.println("failed to update");
        }
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
   public void createUser(String uName,String eMail){
        try {
            System.out.println(uName+eMail);
           st.execute("INSERT INTO user "+ "(userName , userEmail)"+"VALUES('"+uName+"','"+eMail+"')");

        } catch (SQLException e) {
            System.out.println("INSERT INTO user"+ "VALUES('"+uName+"','"+eMail+"')");
            e.printStackTrace();
       }
   }

}
