package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

        String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=Pq1a7cE9R7!_"; //From world to classicmodels
Statement st;






    public DataBase() {
        try {
            Connection c =  DriverManager.getConnection(url);
            st = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database!");
        }
    }


    public void getUpdate(){

        try {

            st.executeUpdate("UPDATE kattMat SET kattmatvikt='1337' WHERE kattMat_id = '1' ");

        }catch (Exception ex){

            System.out.println("failed to update");
        }
    }



}
