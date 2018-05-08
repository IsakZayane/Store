package sample;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {


    private String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=kattmat!"; //githost address
    private Statement st;
    private Connection c;

    Main myApp = new Main();

    private ArrayList<Food> foodList = new ArrayList<>();
    private ArrayList<Wine> wineList = new ArrayList<>();
    private ArrayList<KittyLitter> kittylitterList = new ArrayList<>();
    private ArrayList<CatNip> catnipList = new ArrayList<>();



    //TODO planera databasen, hur vill vi ha den (Till en början i alla fall)

    public DataBase() {

        try {
            c = DriverManager.getConnection(url);
            st = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database!");
        }

        createWineObjects();
        createCatnipObjects();
        createFoodObjects();
        createKittylitterObjects();
    }


    public void createUser(String userName, String userEmail, int password) {

        try {
            String query = "SELECT userEmail from user where userEmail = ?";
            PreparedStatement check = c.prepareStatement(query);
            check.setString(1, userEmail);
            String foundType = null;

            ResultSet rs = check.executeQuery();


            while (rs.next()) {

                foundType = rs.getString("userEmail");
            }

            if (foundType != userEmail) {


                PreparedStatement addUser = c.prepareStatement("INSERT INTO user (userName, userEmail, password) VALUES ( ?, ?, ?)");

                addUser.setString(1, userName);
                addUser.setString(2, userEmail);
                addUser.setInt(3, password);
                addUser.execute();

                System.out.println("INSERT INTO user (userName, userEmail, password) VALUES (" + userName + ", " + userEmail + ", " + password + ")");
            } else {
                System.out.println("ALREADY IN USE---");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email already in use");
                alert.setHeaderText("Please use another email");
                alert.setContentText(userEmail + " is already in use");
                alert.showAndWait();

            }


        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println(ex);

        }
    }

    public void memberLogIn(String name, int password) {
        // query stringen är det "prepareda statementtet"
        //login.setsstring sätter man in parametern name och den går in på första frågetecknet i queryn och login.setInt
        // sätter man in  parametern password på andra frågetecknet i queryn.
        //

        try {
            String query = "select username,password from user where username = ? and password = ?";
            PreparedStatement login = c.prepareStatement(query);
            login.setString(1, name);
            login.setInt(2, password);
            // ResultSet rs ser till så att queryn körs i koden (tror jag)
            ResultSet rs = login.executeQuery();
            String username = null;
            int pass = 0;
            while (rs.next()) {
                username = rs.getString("userName");
                pass = rs.getInt("password");


            }
            if (username.equals(name) && pass == password) {
                System.out.println("name found");
            }

        } catch (SQLException e) {
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

    public void showItems() {//SELECT statement. ResultSet används och executeQuery
    }


    //Column index = vilken kolumn i databasen

    public void getProductId() {


        try {

            ResultSet rs = this.st.executeQuery("SELECT gc ");

        } catch (Exception e) {

        }

    }


    public void updateProductName(String tabName, String colName, String valueOne, String newValue) {   //TODO metod för att uppdatera ett pris på en produkt, kommer behövas en metod för att få fram id på en produkt,

        try {
            st.execute("UPDATE " + tabName + "SET " + colName + "='" + valueOne + "'" + " WHERE");


        } catch (Exception e) {

        }
    }


    public ArrayList<String> getCatFood() {
        int index = 0;
        int one = 1;
        int rows = 0;
        ArrayList<String> items = new ArrayList<>();


        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATFOOD'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            //
            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATFOOD' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name=rs.getString("productsName");
                    items.add(name);
                    index++;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public ArrayList<String> getCatNip() {
        int index = 0;
        int one = 1;
        int rows = 0;
        ArrayList<String> items = new ArrayList<>();


        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATNIP'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            //
            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATNIP' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name=rs.getString("productsName");
                    items.add(name);
                    index++;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public ArrayList<String> getCatWine() {
        int index = 0;
        int one = 1;
        int rows = 0;
        ArrayList<String> items = new ArrayList<>();


        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATWINE'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            //
            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATWINE' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name=rs.getString("productsName");
                    items.add(name);
                    index++;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public ArrayList<String> getCatLitter() {
        int index = 0;
        int one = 1;
        int rows = 0;
        ArrayList<String> items = new ArrayList<>();


        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATLITTER'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            //
            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATLITTER' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name=rs.getString("productsName");
                    items.add(name);
                    index++;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void createFoodObjects(){
        int index = 0;
        int one = 1;
        int rows = 0;
        Food food = new Food();

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'FOOD'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'FOOD' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("productsName");
                    Double price = rs.getDouble("productsPrice");
                    Double weight = rs.getDouble("productsWeight");
                    String origin = rs.getString("productsOrigin");
                    String detail = rs.getString("productsDetail");
                    String ingredients = rs.getString("productsIngredients");

                    food.setName(name);
                    food.setPrice(price);
                    food.setWeight(weight);
                    food.setOrigin(origin);
                    food.setDetail(detail);
                    food.setIngredients(ingredients);

                    foodList.add(food);

                    index++;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void createWineObjects(){
        int index = 0;
        int one = 1;
        int rows = 0;
        Wine wine = new Wine();

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATWINE'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATWINE' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("productsName");
                    Double price = rs.getDouble("productsPrice");
                    Double weight = rs.getDouble("productsWeight");
                    String origin = rs.getString("productsOrigin");
                    String detail = rs.getString("productsDetail");
                    String ingredients = rs.getString("productsIngredients");

                    wine.setName(name);
                    wine.setPrice(price);
                    wine.setWeight(weight);
                    wine.setOrigin(origin);
                    wine.setDetail(detail);
                    wine.setIngredients(ingredients);

                    wineList.add(wine);

                    index++;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // slut

    public void createCatnipObjects(){
        int index = 0;
        int one = 1;
        int rows = 0;
        CatNip catnip = new CatNip();

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATNIP'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATNIP' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("productsName");
                    Double price = rs.getDouble("productsPrice");
                    Double weight = rs.getDouble("productsWeight");
                    String origin = rs.getString("productsOrigin");
                    String detail = rs.getString("productsDetail");
                    String ingredients = rs.getString("productsIngredients");

                    catnip.setName(name);
                    catnip.setPrice(price);
                    catnip.setWeight(weight);
                    catnip.setOrigin(origin);
                    catnip.setDetail(detail);
                    catnip.setIngredients(ingredients);

                    catnipList.add(catnip);

                    index++;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // slut

    public void createKittylitterObjects(){
        int index = 0;
        int one = 1;
        int rows = 0;
        KittyLitter kittyLitter = new KittyLitter();

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'CATLITTER'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'CATLITTER' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("productsName");
                    Double price = rs.getDouble("productsPrice");
                    Double weight = rs.getDouble("productsWeight");
                    String origin = rs.getString("productsOrigin");
                    String detail = rs.getString("productsDetail");
                    String ingredients = rs.getString("productsIngredients");

                    kittyLitter.setName(name);
                    kittyLitter.setPrice(price);
                    kittyLitter.setWeight(weight);
                    kittyLitter.setOrigin(origin);
                    kittyLitter.setDetail(detail);
                    kittyLitter.setIngredients(ingredients);

                    kittylitterList.add(kittyLitter);

                    index++;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // slut

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public ArrayList<Wine> getWineList() {
        return wineList;
    }

    public ArrayList<KittyLitter> getKittylitterList() {
        return kittylitterList;
    }

    public ArrayList<CatNip> getCatnipList() {
        return catnipList;
    }
}

