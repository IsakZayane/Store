package sample.Classes;

import javafx.scene.control.Alert;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    PreparedMethods pm = new PreparedMethods();

    //hej
    private String url = "jdbc:mysql://den1.mysql6.gear.host/TheStoreDB?user=thestoredb&password=kattmat!"; //githost address
    private Statement st;
    private Connection c;

    private ArrayList<Food> foodList = new ArrayList<>();
    private ArrayList<Wine> wineList = new ArrayList<>();
    private ArrayList<KittyLitter> kittylitterList = new ArrayList<>();
    private ArrayList<CatNip> catnipList = new ArrayList<>();
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> memberList2 = new ArrayList<>();


    //TODO planera databasen, hur vill vi ha den (Till en början i alla fall)

    public DataBase() {

        try {
            c = DriverManager.getConnection(url);
            st = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database!");
        }

        createKittylitterObjects();
        createFoodObjects();
        createCatnipObjects();
        createWineObjects();
        createMemberObject();

    }


    public void createUser(String userName, String userEmail, int password) {

        try {
            String query = "SELECT userEmail from user where userEmail = ?";
            PreparedStatement check = c.prepareStatement(query);
            check.setString(1, userEmail);


            ResultSet rs = check.executeQuery();
            String foundtype=null;


            while (rs.next()) {

                foundtype = rs.getString("userEmail");

                check.executeQuery();

            }

            if ( foundtype!= userEmail) {
                int notadmin = 0;


                PreparedStatement addUser = c.prepareStatement("INSERT INTO user (userName, userEmail, password, admin) VALUES ( ?, ?, ?,?)");

                addUser.setString(1, userName);
                addUser.setString(2, userEmail);
                addUser.setInt(3, password);
                addUser.setInt(4, notadmin);

                addUser.execute();

                System.out.println("INSERT INTO user (userName, userEmail, password) VALUES (" + userName + ", " + userEmail + ", " + password + ")");


            }


        } catch (SQLException ex) {

            pm.showAlert("Error", "Email already in use", "Please choose another email");

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

            pm.showAlert("Error", "Member name and/or password does not match", "Re-enter password and/or Member name");


        }


    }


    public void GuestLogIn() {
        try {
            st.execute("INSERT INTO guest (guestName) VALUES ('Guest')");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    public String Email(String name) {
        String email = null;

        try {


            String query = "select userEmail from user where userName = ?";
            PreparedStatement emailsearch = c.prepareStatement(query);
            emailsearch.setString(1, name);
            ResultSet rs = emailsearch.executeQuery();

            while (rs.next()) {
                email = rs.getString("userEmail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;

    }


    public void orderDetails(java.sql.Date date, String name) {
        try {
            String query = "insert into orders (ordersdate,user_iduser,payments_paymentsid) values (?,(select iduser from user where userName = ?),(select max(paymentsid) from payments where user_iduser =(select iduser from user where userName = ?)));";
            PreparedStatement order = c.prepareStatement(query);
            order.setDate(1, date);
            order.setString(2, name);
            order.setString(3,name);
            order.execute();
            System.out.println("order details");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createFoodObjects() {
        int index = 0;
        int one = 1;
        int rows = 0;

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


                    Food food = new Food();
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

    public void createWineObjects() {
        int index = 0;
        int one = 1;
        int rows = 0;

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

                    Wine wine = new Wine();
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

    public void createCatnipObjects() {
        int index = 0;
        int one = 1;
        int rows = 0;

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


                    CatNip catnip = new CatNip();
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

    public void createKittylitterObjects() {
        int index = 0;
        int one = 1;
        int rows = 0;

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM PRODUCTS WHERE PRODUCTTYPE = 'KITTYLITTER'");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM PRODUCTS WHERE PRODUCTTYPE= 'KITTYLITTER' LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("productsName");
                    Double price = rs.getDouble("productsPrice");
                    Double weight = rs.getDouble("productsWeight");
                    String origin = rs.getString("productsOrigin");
                    String detail = rs.getString("productsDetail");
                    String ingredients = rs.getString("productsIngredients");


                    KittyLitter kittyLitter = new KittyLitter();
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

    public ArrayList<Member> getMember() {
        return memberList;
    }

    public ArrayList<Member> getMemberList2() {
        return memberList2;
    }

    public int getOrderId(String name) {
        int orderid = 0;
        try {
            String query = "select ordersid from orders where user_iduser = (select iduser from user where userName=?) order by ordersid desc";
            PreparedStatement idorder = c.prepareStatement(query);
            idorder.setString(1, name);
            ResultSet rs = idorder.executeQuery();
            rs.afterLast();
            while (rs.previous()) {
                orderid = rs.getInt("ordersid");


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderid + 1;


    }

    public boolean adminLogin(String name, int password) {
        boolean adminaccept = false;
        try {

            int admincheck = 0;
            String query = "select admin from user where username = ? and password = ?";
            PreparedStatement adminsearch = c.prepareStatement(query);
            adminsearch.setString(1, name);
            adminsearch.setInt(2, password);
            ResultSet rs = adminsearch.executeQuery();

            while (rs.next()) {
                admincheck = rs.getInt("admin");
            }
            if (admincheck == 1) {
                adminaccept = true;
            }

        } catch (SQLException e) {


        }
        return adminaccept;

    }

    public boolean isAdmin() {
        boolean adminaccept = false;
        try {

            int admincheck = 0;
            String query = "select admin from user where username = ?";
            PreparedStatement adminsearch = c.prepareStatement(query);
            adminsearch.setString(1, NameTransfer.getInstance().getName());

            ResultSet rs = adminsearch.executeQuery();

            while (rs.next()) {
                admincheck = rs.getInt("admin");
            }
            if (admincheck == 1) {
                adminaccept = true;
            }

        } catch (SQLException e) {


        }
        return adminaccept;

    }



    public void addItem(String type, String name, String ingridients, double weight, String origin, String detail, int price) {
        try {
            String query = "INSERT into products (productsprice,productsname,productsingredients,productsweight,productsorigin,productsdetail,producttype) values (?,?,?,?,?,?,?)";
            PreparedStatement addproduct = c.prepareStatement(query);
            addproduct.setInt(1, price);
            addproduct.setString(2, name);
            addproduct.setString(3, ingridients);
            addproduct.setDouble(4, weight);
            addproduct.setString(5, origin);
            addproduct.setString(6, detail);
            addproduct.setString(7, type);
            addproduct.execute();
            System.out.println("all clear in db");


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public void deleteItem(String name) {
        try {


            String query = "DELETE from PRODUCTS where productsname = ?";
            PreparedStatement delete = c.prepareStatement(query);
            delete.setString(1, name);

            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public void removeMember(String email) {
        try {

            String query = "DELETE from USER where userEmail = ?";
            PreparedStatement delete = c.prepareStatement(query);
            delete.setString(1, email);
            delete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setMemberEmails() {
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM user where not admin = 1");
            while (rs.next()) {
                String name = rs.getString("userName");
                String email = rs.getString("userEmail");
                int id = rs.getInt("iduser");

                Member member = new Member();
                member.setName(name);
                member.setEmail(email);
                member.setId(id);

                memberList.add(member);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean blockedUser(String name, int password) {
        boolean isblocked = false;
        try {
            int blockcheck = 0;
            String query = "select admin from user where username = ? and password = ?";
            PreparedStatement block = c.prepareStatement(query);
            block.setString(1, name);
            block.setInt(2, password);
            ResultSet rs = block.executeQuery();
            while (rs.next()) {
                blockcheck = rs.getInt("admin");
            }
            if (blockcheck == 2) {
                isblocked = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return isblocked;
    }

    public void blockMember(String email) {
        try {
            String query = "UPDATE user SET admin = 2 where useremail = ?";
            PreparedStatement block = c.prepareStatement(query);
            block.setString(1, email);
            block.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void unblockMemeber(String email) {
        try {
            String query = "UPDATE user SET admin = 0 where useremail = ?";
            PreparedStatement block = c.prepareStatement(query);
            block.setString(1, email);
            block.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean allreadyBlocked(String email) {
        boolean isblocked = false;
        int blocked = 0;
        try {
            String query = "Select admin from user where userEmail = ?";
            PreparedStatement blockcheck = c.prepareStatement(query);
            blockcheck.setString(1, email);
            ResultSet rs = blockcheck.executeQuery();
            while (rs.next()) {
                blocked = rs.getInt("admin");
            }
            if (blocked == 2) {
                isblocked = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isblocked;


    }
public void paymentsInsert(java.sql.Date date,double pay,String name) {
    try {
        String query = "INSERT into payments (paymentsdate,paymentsamount,user_iduser) values (?,?,(select iduser from user where username = ?));";
        PreparedStatement payment = c.prepareStatement(query);
        payment.setDate(1, date);
        payment.setDouble(2, pay);
        payment.setString(3, name);
        payment.execute();
    } catch (SQLException e) {
        e.printStackTrace();

    }
}

public void orderSpecifics(String username,String productname,int quantity){
        try {
            String query = "insert into orderdetails (orders_ordersid,products_productsid,quantityordered) values ((select max(ordersid) from orders where user_iduser = (select iduser from user where username = ?)),(select productsid from products where productsName = ?),?)";
            PreparedStatement specifics = c.prepareStatement(query);
            specifics.setString(1,username);
            specifics.setString(2,productname);
            specifics.setInt(3,quantity);
            specifics.execute();
        }catch (SQLException e){

        }
}

    public void createMemberObject() {
        int index = 0;
        int one = 1;
        int rows = 0;

        try {
            ResultSet count = this.st.executeQuery("SELECT COUNT(*) AS total FROM USER");
            while (count.next()) {
                rows = count.getInt("total");
            }

            for (int i = 0; i < rows; i++) {
                ResultSet rs = this.st.executeQuery("SELECT * FROM USER LIMIT " + index + "," + one);


                while (rs.next()) {
                    String name = rs.getString("userName");
                    String password = rs.getString("password");
                    String email = rs.getString("userEmail");

                    Member member = new Member();
                    member.setName(name);
                    member.setPassword(password);
                    member.setEmail(email);

                    memberList2.add(member);


                    index++;

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}







