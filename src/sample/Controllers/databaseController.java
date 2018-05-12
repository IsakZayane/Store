package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Classes.DataBase;
import sample.Classes.Member;
import sample.Classes.PreparedMethods;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class databaseController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

    @FXML
    private TextField namefield, ingridientfield, weightfield, originfield, detailfield, pricefield;
    @FXML
    private ChoiceBox<String> productype = new ChoiceBox<>();
    @FXML
    private ListView <String> memberlist;
    private ArrayList<Member> member = new ArrayList<>();
    ObservableList<String> list = FXCollections.observableArrayList();


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



    }

    @FXML
    public void addNewProduct() {
        try {


            DataBase mydb = new DataBase();
            mydb.addItem(productype.getSelectionModel().getSelectedItem(), namefield.getText(), ingridientfield.getText(),
                    Double.parseDouble(weightfield.getText()), originfield.getText(), detailfield.getText(),
                    Integer.parseInt(pricefield.getText()));
            System.out.println("added in dbcontroller");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeAction(){
        DataBase mydb= new DataBase();
        mydb.deleteItem(productype.getSelectionModel().getSelectedItem(),namefield.getText());

    }

    public void goBackAction(ActionEvent event){
        pm.changeScene(event,"/sample/fxml/productssampleadmin.fxml","");

    }
public void goBackToLoginAction(ActionEvent event){
        pm.changeScene(event,"/sample/fxml/sample.fxml","");

    }
public void exitAction(){
    System.exit(0);
}
public void removeMemberAction(){
    DataBase db = new DataBase();
    db.removeMember(memberlist.getSelectionModel().getSelectedItem());
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