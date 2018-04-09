package sample;

import java.sql.*;

public class DataBase {

    String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=Pq1a7cE9R7!_"; //githost address
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


    public void showItems() {   //SELECT statement. ResultSet används och executeQuery

        try {

            ResultSet rs = this.st.executeQuery("SELECT * FROM KATTMAT");
            System.out.println();

            while (rs.next()) {
                System.out.println(rs.getString(2));   //Column index = vilken kolumn i databasen
            }


        } catch (Exception ex) {


        }
    }


    public void getUpdate() {   //test metod

        try {

            st.executeUpdate("UPDATE kattMat SET kattmatvikt='1234' WHERE kattMat_id = '1' ");

        } catch (Exception ex) {

            System.out.println("failed to update");
        }
    }


}
