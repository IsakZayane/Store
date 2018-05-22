package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.DataBase;
import sample.Classes.Item;
import sample.Classes.Member;
import sample.Classes.PreparedMethods;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

    @FXML private TextField namefield, ingridientfield, weightfield, originfield, detailfield, pricefield;
    @FXML private ChoiceBox<String> productype = new ChoiceBox<>();
    @FXML private ListView <String> memberlist;
    private ArrayList<Member> member = new ArrayList<>();
    ObservableList<String> list = FXCollections.observableArrayList();
    @FXML private TableColumn namecol,pricecol;
    @FXML private TableView <Item> producttable;
    private ObservableList <Item> productList = FXCollections.observableArrayList();
     ArrayList<Item> everyitem =new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("adminmodify");
        productype.getItems().add("KittyLitter");
        productype.getItems().add("food");
        productype.getItems().add("CatWine");
        productype.getItems().add("CatNip");

       DataBase db = new DataBase();
        db.setMemberEmails();
        member = db.getMember();

        memberlist.setItems(list);
        memberlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (int i = 0; i<member.size();i++) {
           if (db.allreadyBlocked(member.get(i).getEmail()))
            list.add(member.get(i).getEmail() + ":    Blocked");
           else list.add(member.get(i).getEmail());
        }
        everyitem.addAll(db.getCatnipList());
        everyitem.addAll(db.getFoodList());
        everyitem.addAll(db.getKittylitterList());
        everyitem.addAll(db.getWineList());

        productList.addAll(everyitem);

        namecol.setCellValueFactory(new PropertyValueFactory<Item,String>("Name"));
        pricecol.setCellValueFactory(new PropertyValueFactory<Item,Double>("Price"));

        for (int i =0;i<everyitem.size();i++){
            producttable.setItems(productList);
        }




    }









    @FXML
    public void addNewProduct() {
        try {
            String type =productype.getSelectionModel().getSelectedItem();
            String name = namefield.getText();
            String ingredients = ingridientfield.getText();
            Double weight = Double.parseDouble(weightfield.getText());
            String origin = originfield.getText();
            String details = detailfield.getText();
            int price = Integer.parseInt(pricefield.getText());

            if ( price < 0 ) {
                pm.showAlert("Wrong price format", "You need to have a positive number as a price", "Please try again");
                throw new IllegalArgumentException();
            }
            else if (weight < 0 ){
                pm.showAlert("Wrong weight format", "Weight cannot be negative", "Please try again");
                throw new IllegalArgumentException();

            } else if (namefield.getText().isEmpty()){
                pm.showAlert("Name entry got wrong","Please enter the name of your product","Please try again " );
                throw new IllegalArgumentException();
            }else if (productype.getValue().isEmpty()){
                pm.showAlert("Please chose a product type", "Chose a product type to proceed", "Please try again");
                throw new IllegalArgumentException();

            }



            DataBase mydb = new DataBase();
            mydb.addItem(type,name,ingredients, weight, origin,details, price);


            System.out.println("added in dbcontroller");



        }catch (NumberFormatException e){
            pm.showAlert("Must use correct values","Sup duderino","xD");

            e.printStackTrace();

        }
    }
    public void removeAction(){
        DataBase db= new DataBase();
       
        db.deleteItem(producttable.getSelectionModel().getSelectedItem().getName());
        producttable.getItems().clear();
        productList.removeAll();
        for (int i =0;i<everyitem.size();i++){
            everyitem.remove(i);
        }

        everyitem.addAll(db.getCatnipList());
        everyitem.addAll(db.getFoodList());
        everyitem.addAll(db.getKittylitterList());
        everyitem.addAll(db.getWineList());

        productList.addAll(everyitem);

        for (int i =0;i<everyitem.size();i++) {
            producttable.setItems(productList);
        }
        producttable.refresh();
    }


    public void goBackAction(ActionEvent event){
        pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml","");

    }
public void goBackToLoginAction(ActionEvent event){
        pm.changeScene(event, "/sample/fxml/Sample.fxml","");

    }
public void exitAction(){
    System.exit(0);
}
public void removeMemberAction(){
    DataBase db = new DataBase();
    String remove = memberlist.getSelectionModel().getSelectedItem();
    String removereplace=remove.replace(":    Blocked","");

    db.removeMember(removereplace);
    db.setMemberEmails();
    member = db.getMember();
    list.clear();
    memberlist.refresh();
    for (int i = 0; i<member.size();i++){
        if(db.allreadyBlocked(member.get(i).getEmail()))
            list.add(member.get(i).getEmail() + ":    Blocked");
        else list.add(member.get(i).getEmail());
    }

}
public void blockAction() {
    DataBase db = new DataBase();
    db.blockMember(memberlist.getSelectionModel().getSelectedItem());

    list.clear();
    memberlist.refresh();
    for (int i = 0; i < member.size(); i++) {
        if (db.allreadyBlocked(member.get(i).getEmail()))
            list.add(member.get(i).getEmail() + ":    Blocked");
        else list.add(member.get(i).getEmail());


    }
}

    public void unblockAction() {
        DataBase db = new DataBase();
        String memberunblock = memberlist.getSelectionModel().getSelectedItem();
        String memeberunblock2=memberunblock.replace( ":    Blocked","");
        db.unblockMemeber(memeberunblock2);
        System.out.println(memeberunblock2);
        list.clear();
        memberlist.refresh();

        for (int i = 0; i < member.size(); i++) {
            if (db.allreadyBlocked(member.get(i).getEmail()))
                list.add(member.get(i).getEmail() + ":    Blocked");
            else list.add(member.get(i).getEmail());
        }
    }
}