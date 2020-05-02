/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fest2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fest3.FXMLDocument2Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import message.Fest4Controller;

/**
 *
 * @author shourya
 */
public class FXMLDocument1Controller implements Initializable {
    private static  int USER_LEVEL;
    private static String USER_NAME;
    private static String SELECTED_TABLE;
    public Button meetingbutton;
    private MenuItem menuitem1=new MenuItem("Expenditures");
    private MenuItem menuitem2=new MenuItem("Organizing Committe");
    private MenuItem menuitem3=new MenuItem("Associates");
    private MenuItem menuitem4=new MenuItem("Volunteers");
    private MenuItem menuitem5=new MenuItem("Organizing Team");
    private MenuItem menuitem6=new MenuItem("Contacts");
    private MenuItem menuitem7=new MenuItem("Sponsors");
    private MenuItem menuitem8=new MenuItem("Events");
    private MenuItem menuitem9=new MenuItem("Judges");
    private MenuItem menuitem10=new MenuItem("Management");
    private MenuItem menuitem11=new MenuItem("Participants");
    private MenuItem menuitem12=new MenuItem("Requirements");
    private MenuItem menuitem13=new MenuItem("Student Council");
    private MenuItem menuitem14=new MenuItem("Faculty");

    @FXML
    private Label label;
    @FXML private AnchorPane mainpane;
    @FXML private AnchorPane selectlabel;
    @FXML private MenuButton menubutton;
    @FXML private Button nextbutton;
    @FXML private Button backButton;
    @FXML private TextField warning_text;

    public void loginscreenopen()
    {
        Stage myStage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest/FXMLDOCUMENT.fxml"));
        AnchorPane mainpane = null;
        try {
            mainpane = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Button Pressed      " + mainpane);
        myStage.setScene(new Scene(mainpane, 1040, 730));
        myStage.setWidth(1047);



    }

    public void nextscreenopen()
    {   //System.out.println("This is menu: "+menubutton);
        if(menubutton.getText().compareTo("Select Table")==0){
            warning_text.setOpacity(1);
            warning_text.setText("NOTHING SELECTED");
        }
        else{
        Stage myStage = (Stage) mainpane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest3/FXMLDocument2.fxml"));
            FXMLDocument2Controller Scene3Controller=loader.getController();
            Scene3Controller.setCurrentTable(menubutton.getText());
        AnchorPane mainpane = null;
        try {
            mainpane = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Button Pressed  in Doc1    " + mainpane);
        myStage.setScene(new Scene(mainpane, 1040, 730));}
    }


    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    public static void setUserLevel(int level,String Name){
        USER_LEVEL=level;USER_NAME=Name;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("IN the Initilization with user: "+USER_LEVEL);
        menubutton.getItems().add(menuitem11);
        menubutton.getItems().add(menuitem4);
        menubutton.getItems().add(menuitem6);
        menubutton.getItems().add(menuitem7);
        menubutton.getItems().add(menuitem8);
        menubutton.getItems().add(menuitem9);

        if(USER_LEVEL==1){
            menubutton.getItems().add(menuitem1);
            menubutton.getItems().add(menuitem2);
            menubutton.getItems().add(menuitem3);
            menubutton.getItems().add(menuitem5);
            menubutton.getItems().add(menuitem10);
            menubutton.getItems().add(menuitem12);
            menubutton.getItems().add(menuitem13);
            menubutton.getItems().add(menuitem14);
        }
        menubutton.getItems().stream().forEach((MenuItem menitem)->menitem.setOnAction(ev->{
            menubutton.setText(menitem.getText());
        }));
    }

    public void messagesOpen(MouseEvent mouseEvent) {
        Stage myStage = (Stage) mainpane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/message/fest4.fxml"));
        Fest4Controller scene4controller=loader.getController();
        scene4controller.setusername(USER_NAME);
        AnchorPane mainpane = null;
        try {
            mainpane = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Button Pressed  in Doc1    " + mainpane);
        myStage.setScene(new Scene(mainpane, 1040, 730));

    }

    public void meetingscreenopen(){
        Stage myStage = (Stage) meetingbutton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest4/FXMLDocument3.fxml"));
        AnchorPane mainpane = null;
        try {
            mainpane = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Button Pressed      " + mainpane);
        myStage.setScene(new Scene(mainpane, 1040, 730));
    }

}
