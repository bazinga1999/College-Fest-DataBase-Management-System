/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fest;

import java.net.URL;
import java.util.ResourceBundle;

import fest2.FXMLDocument1Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.fxml.*;
import java.io.IOException;

/**
 *
 * @author shourya
 */
public class FXMLDocumentController implements Initializable {
    private static final String[] usernames={"muskan","peeyush","prutyay","ritvik","shorya"};//List of all users who can access the DB
    private static final String[] passwd={"2018297","2018402","2018403","2018085","2018311"};//Corresponding passwords
   private static final int[] user_levels={0,1,1,1,1};
    @FXML
    private Label label;

    @FXML
    private TextArea login_promt;//A text Area which displays message corresponding to empty fields or wrong usernams & password.

    @FXML
    private AnchorPane mainpane;
    @FXML
    private TextField usernamelabel;
    @FXML
    private PasswordField passwordlabel;
    @FXML
    private Button loginbutton;
    
    public void nextscreenopen()  {
        //System.out.println("There"+" "+usernamelabel+" "+passwordlabel);
        //System.out.println("There"+usernamelabel.getText()+"pass"+passwordlabel.getText()+"word");
        if(usernamelabel.getText().trim().equals("")|| passwordlabel.getText().trim().equals("")){
            login_promt.setOpacity(1);
            login_promt.setText("WARNING:Please Enter all fields");
        }
        else{
            boolean login_successfull=false;
            String current_user=usernamelabel.getText();
            String current_user_password=passwordlabel.getText();
            //System.out.println("Username:"+current_user+",Password:"+current_user_password);
            int i=0;
            for(i=0;i<5;i++){           //check for username and password

                if(current_user.equalsIgnoreCase(usernames[i]) && current_user_password.equals(passwd[i])){
                    //System.out.println("in here");
                    login_successfull=true;

                    break;
                }
            }
            System.out.println("Login Succesful:"+login_successfull);
            if(login_successfull){
                Stage myStage = (Stage) loginbutton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fest2/FXMLDocument1.fxml"));
                FXMLDocument1Controller Scene2controller=loader.getController();
                FXMLDocument1Controller.setUserLevel(user_levels[i],current_user);

                AnchorPane mainpane = null;
                try {
                    mainpane =  loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Button Pressed in Doc0      " + mainpane);

                myStage.setScene(new Scene(mainpane, 1040, 730));
            }
            else
            {
                login_promt.setOpacity(1);
                login_promt.setText("WRONG Username or Password");
            }

        }
    }
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
