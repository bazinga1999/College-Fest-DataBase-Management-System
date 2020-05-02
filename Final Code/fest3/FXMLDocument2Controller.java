/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fest3;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author shourya
 */
public class FXMLDocument2Controller implements Initializable {
    private static String CURRENT_TABLE="Expenditures";
    private static final String[][] All_Tables= {
            {"Expenditures", "id", "Money Spent", "Incharge", "Balance", "Purpose","NULL","NULL","NULL"},
            {"Organizing Committe", "Roll No", "Name", "Department", "Email", "Contact", "Experience", "CGPA"},
            {"Associates", "id", "Name", "Institute", "Incharge OC", "timings", "fee","NULL"},
            {"Volunteers", "Roll no", "Name", "Email", "Contact", "Respective OC", "Respective OT","NULL"},
            {"Organizing Team", "Roll no", "Name", "Department", "Event", "Email", "Contact", "Respective OC"},
            {"Contacts", "Id", "Name", "Department", "Status", "College", "Contacted By","NULL"},
            {"Sponsors", "Id", "Name", "Address", "Status", "Contact", "Mode of Spons", "Point of Contact"},
            {"Events", "Name", "Department", "Prizes", "Status", "Location","NULL","NULL"},
            {"Judges","Name","Point of Contact","Event","Fee","NULL","NULL","NULL"},
            {"Management","Id","Name","Type","Contact 1","Contact 2","NULL","NULL"},
            {"Participants","Id","Name","Event","Status","College","Contact","NULL"},
            {"Requirements","Id","Name","Total Requirements","Availables","Events","Purpose","Vendor"},
            {"Student Council","Roll no","Name","Position","Email","Contact","CGPA","NULL"}

    };
    HashMap<String,String[]> mapping=new HashMap<>();
    private static final String[][] SQL_Tables={
            {"expenditures", "id", "money_spent", "incharge", "balance", "purpose","NULL","NULL","NULL"},
            {"organizing_committee", "roll_no", "name", "dept", "email", "contact", "experience", "cgpa"},
            {"associates", "id", "name", "institute", "incharge_OC", "timings", "fee","NULL"},
            {"volunteers", "roll_no", "name", "email", "contact", "respective_OC", "respective_OT","NULL"},
            {"organizing_team", "roll_no", "name", "dept", "event", "email", "contact", "respective_OC"},
            {"contacts", "id", "name", "dept", "status", "college", "contacted_by","NULL"},
            {"Sponsors", "id", "name", "address", "status", "contact", "mode_of_spons", "point_of_contact"},
            {"events", "name", "dept", "prizes", "status", "location","NULL","NULL"},
            {"judges","name","point_of_contact","event","fee","NULL","NULL","NULL"},
            {"management","id","name","type","contact_1","contact_2","NULL","NULL"},
            {"participants","id","name","event","status","college","contact","NULL"},
            {"requirements","id","name","total_Reqd","available","events","purpose","vendor"},
            {"student_council","roll_no","name","position","email","contact","CGPA","NULL"}

    };

    @FXML
    private TextArea infobox;


    @FXML
    private TextArea outputTextbox;

    @FXML
    private Label label;
    @FXML private AnchorPane mainpane;

    @FXML private AnchorPane updatepane; //this pane has opacity 0 as of now, it has the update table button too

    @FXML private AnchorPane outputpane; // this pane is visible right now, it has data of updated tables, has opacity 0 right now

    @FXML private Text rightsideA1; // all the text fields on right which appear when upadte is clicked
    @FXML private Text rightsideA2;
    @FXML private Text rightsideA3;
    @FXML private Text rightsideA4;
    @FXML private Text rightsideA5;
    @FXML private Text rightsideA6;
    @FXML private Text rightsideA7;

    @FXML private Text leftsideA1; // all text attributes which appear on left always.
    @FXML private Text leftsideA2;
    @FXML private Text leftsideA3;
    @FXML private Text leftsideA4;
    @FXML private Text leftsideA5;
    @FXML private Text leftsideA6;
    @FXML private Text leftsideA7;

    @FXML
    private Text MainHeadingText;

    @FXML private TextField a1text; //these are the ones on the left side
    @FXML private TextField a2text;
    @FXML private TextField a3text;
    @FXML private TextField a4text;
    @FXML private TextField a5text;
    @FXML private TextField a6text;
    @FXML private TextField a7text;

    @FXML private Button selectbutton;
    @FXML private Button updatebutton;
    @FXML private Button deletebutton;
    @FXML private Button addbutton;

    @FXML private Button backbutton;
    @FXML private Button logoutbutton;

    @FXML private TextField outputa1; //these are children of update pane which are on the right side
    @FXML private TextField outputa2;
    @FXML private TextField outputa3;
    @FXML private TextField outputa4;
    @FXML private TextField outputa5;
    @FXML private TextField outputa6;
    @FXML private TextField outputa7;

    @FXML private Button updatedetailsbutton; //update tables button, child of update pane


    @FXML private TableView outputtable; //child of outputpane, has columns which will have updated data

    @FXML private TableColumn column1; //children of outputpane, columns for updated data
    @FXML private TableColumn column2;
    @FXML private TableColumn column3;
    @FXML private TableColumn column4;
    @FXML private TableColumn column5;
    @FXML private TableColumn column6;
    @FXML private TableColumn column7;
    static String[] update1;
    static String[] update2;

    public static void setCurrentTable(String n){
        CURRENT_TABLE=n;
    }


    public void loginscreenopen()
    {
        Stage myStage = (Stage) deletebutton.getScene().getWindow();
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
    
    public void selecttypescreenopen()
    {

        Stage myStage = (Stage) deletebutton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest2/FXMLDOCUMENT1.fxml"));
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

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i=0;i<13;i++){
            mapping.put(All_Tables[i][0],SQL_Tables[i]);
        }
        MainHeadingText.setText(CURRENT_TABLE);
        LinkedList<Pair<Text,TextField>> leftlist=new LinkedList<>();
        LinkedList<Pair<Text,TextField>> rightlist=new LinkedList<>();
        leftlist.add(new Pair<>(leftsideA1,a1text));rightlist.add(new Pair<>(rightsideA1,outputa1));
        leftlist.add(new Pair<>(leftsideA2,a2text));rightlist.add(new Pair<>(rightsideA2,outputa2));
        leftlist.add(new Pair<>(leftsideA3,a3text));rightlist.add(new Pair<>(rightsideA3,outputa3));
        leftlist.add(new Pair<>(leftsideA4,a4text));rightlist.add(new Pair<>(rightsideA4,outputa4));
        leftlist.add(new Pair<>(leftsideA5,a5text));rightlist.add(new Pair<>(rightsideA5,outputa5));
        leftlist.add(new Pair<>(leftsideA6,a6text));rightlist.add(new Pair<>(rightsideA6,outputa6));
        leftlist.add(new Pair<>(leftsideA7,a7text));rightlist.add(new Pair<>(rightsideA7,outputa7));

        for(int i=0;i<13;i++){
            if(All_Tables[i][0].compareToIgnoreCase(CURRENT_TABLE)==0){
                for(int j=0;j<7;j++){
                    Pair<Text,TextField> temp=leftlist.get(j);
                    Pair<Text,TextField> temp2=rightlist.get(j);
                    if(All_Tables[i][j+1].compareToIgnoreCase("NULL")!=0) {
                        temp.getKey().setText(All_Tables[i][j+1]);
                        temp2.getKey().setText(All_Tables[i][j+1]);
                        //listlefttext.get(j).setText(All_Tables[i][j + 1]);
                    }
                    else{
                        temp.getKey().setDisable(true);
                        temp.getKey().setOpacity(0);
                        temp.getValue().setDisable(true);
                        temp.getValue().setOpacity(0);
                        temp2.getKey().setDisable(true);
                        temp2.getKey().setOpacity(0);
                        temp2.getValue().setDisable(true);
                        temp2.getValue().setOpacity(0);
                        //listlefttext.get(j).setDisable(true);
                        //listlefttext.get(j).setOpacity(0);
                    }
                }
                break;
            }
        }


        updatepane.setDisable(true);
        outputpane.setDisable(true);
        updatepane.setOpacity(0);
        outputpane.setOpacity(0);




    }
    public void BackQueryClickAction(MouseEvent mouseEvent) {
        Stage main = (Stage) MainHeadingText.getScene().getWindow();
        main.setWidth(1700);
        mainpane.prefWidth(1047);
    }

    public void SelectQueryClickAction(MouseEvent mouseEvent) {


            updatepane.setDisable(true);
            updatepane.setOpacity(0);
            outputpane.setDisable(false);
            outputpane.setOpacity(1);

            String[] input = new String[]{a1text.getText(),a2text.getText(),a3text.getText(),a4text.getText(),a5text.getText(),a6text.getText(),a7text.getText()};

           System.out.println(a1text.getText()+","+a2text.getText()+","+a3text.getText()
           +","+a4text.getText()+","+a5text.getText()+","+a6text.getText()+","+a7text.getText());
            String[] temp=mapping.get(CURRENT_TABLE);
            for (int i=1;i<8;i++)
                System.out.print(temp[i]+",");

            String output = DBconnection.SelectData(input,temp,temp[0]);

            outputTextbox.setText(output);
            outputTextbox.setFont(Font.font("Consolas", 15));
            System.out.println(output);
            infobox.setText("Result Found");

            Stage main = (Stage) MainHeadingText.getScene().getWindow();
            main.setWidth(1700);
            mainpane.prefWidth(1700);
            outputTextbox.setEditable(false);

            outputTextbox.prefWidth(2200);
            outputpane.prefWidth(2200);
            updatepane.prefWidth(2200);
            mainpane.prefWidth(2200);

            a1text.setText("");
            a2text.setText("");
            a3text.setText("");
            a4text.setText("");
            a5text.setText("");
            a6text.setText("");
            a7text.setText("");


    }

    public void UpdateQueryClickAction(MouseEvent mouseEvent) {
        update1 = new String[]{a1text.getText(),a2text.getText(),a3text.getText(),a4text.getText(),a5text.getText(),a6text.getText(),a7text.getText()};

        if(a1text.getText().compareTo("")!=0||a2text.getText().compareTo("")!=0
                ||a3text.getText().compareTo("")!=0||a4text.getText().compareTo("")!=0||
                a5text.getText().compareTo("")!=0||a6text.getText().compareTo("")!=0||a7text.getText().compareTo("")!=0)
        {
            updatepane.setDisable(false);
            updatepane.setOpacity(1);
            outputpane.setDisable(true);
            outputpane.setOpacity(0);
            System.out.println(a1text.getText()+","+a2text.getText()+","+a3text.getText()
                    +","+a4text.getText()+","+a5text.getText()+","+a6text.getText()+","+a7text.getText());
            String[] temp=mapping.get(CURRENT_TABLE);
            for (int i=1;i<8;i++)
                System.out.print(temp[i]+",");
            System.out.println(temp[0]);


        }
        else{
            outputpane.setDisable(true);
            outputpane.setOpacity(0);
            updatepane.setDisable(true);
            updatepane.setOpacity(0);
            infobox.setText("No such Update query possible");
        }

    }

    public void DeleteQueryClickAction(MouseEvent mouseEvent) {

        if(a1text.getText().compareTo("")!=0||a2text.getText().compareTo("")!=0
                ||a3text.getText().compareTo("")!=0||a4text.getText().compareTo("")!=0||
                a5text.getText().compareTo("")!=0||a6text.getText().compareTo("")!=0||a7text.getText().compareTo("")!=0)
        {
            String[] input = new String[]{a1text.getText(),a2text.getText(),a3text.getText(),a4text.getText(),a5text.getText(),a6text.getText(),a7text.getText()};
            updatepane.setDisable(true);
            updatepane.setOpacity(0);
            outputpane.setDisable(false);
            outputpane.setOpacity(1);
            System.out.println(a1text.getText()+","+a2text.getText()+","+a3text.getText()
                    +","+a4text.getText()+","+a5text.getText()+","+a6text.getText()+","+a7text.getText());
            String[] temp=mapping.get(CURRENT_TABLE);


            for (int i=1;i<8;i++)
                System.out.print(temp[i]+",");
            System.out.println(temp[0]);
            //System.out.println(mapping.get(CURRENT_TABLE));


            String output = DBconnection.DeleteData(input,temp,temp[0]);

            if(output.equals("successfully deleted")){
                infobox.setText(output);
                String[] input2 = new String[]{"","","","","","",""};
                outputTextbox.setText( DBconnection.SelectData(input2,temp,temp[0]));
                outputTextbox.setFont(Font.font("Consolas", 15));
                System.out.println(output);

                Stage main = (Stage) MainHeadingText.getScene().getWindow();
                main.setWidth(1700);
                mainpane.prefWidth(1700);
                outputTextbox.setEditable(false);

                outputTextbox.prefWidth(2200);
                outputpane.prefWidth(2200);
                updatepane.prefWidth(2200);
                mainpane.prefWidth(2200);

            }else{
                infobox.setText(output);

            }
            a1text.setText("");
            a2text.setText("");
            a3text.setText("");
            a4text.setText("");
            a5text.setText("");
            a6text.setText("");
            a7text.setText("");
        }
        else{
            outputpane.setDisable(true);
            outputpane.setOpacity(0);
            updatepane.setDisable(true);
            updatepane.setOpacity(0);
            infobox.setText("No such Delete query possible");
        }

    }

    public void updatedetailsscreenopen(MouseEvent mouseEvent) {
        if(outputa1.getText().compareTo("")!=0||outputa2.getText().compareTo("")!=0||outputa3.getText().compareTo("")!=0||
        outputa4.getText().compareTo("")!=0||outputa5.getText().compareTo("")!=0||outputa6.getText().compareTo("")!=0
                ||outputa7.getText().compareTo("")!=0)
        {
            update2 = new String[]{outputa1.getText(),outputa2.getText(),outputa3.getText(),outputa4.getText(),outputa5.getText(),outputa6.getText(),outputa7.getText()};

            System.out.println(outputa1.getText()+","+outputa2.getText()+","+outputa3.getText()+","+outputa4.getText()+","
                    +outputa5.getText()+","+outputa6.getText()+","+outputa7.getText());
            String[] attributes=mapping.get(CURRENT_TABLE);
            for (int i=1;i<8;i++)
                System.out.print(attributes[i]+",");
            System.out.println(attributes[0]);

            String output = DBconnection.UpdateData(update1,update2,attributes,attributes[0]);

            String[] temp = new String[]{"","","","","","",""};
            infobox.setText(output);
            if(output.equals("successfully updated")){
                outputTextbox.setText(DBconnection.SelectData(temp,attributes,attributes[0]));
                outputTextbox.setFont(Font.font("Consolas", 15));
                System.out.println(output);

                Stage main = (Stage) MainHeadingText.getScene().getWindow();
                main.setWidth(1700);
                mainpane.prefWidth(1700);
                outputTextbox.setEditable(false);

                outputTextbox.prefWidth(2200);
                outputpane.prefWidth(2200);
                updatepane.prefWidth(2200);
                mainpane.prefWidth(2200);

            }else{

            }


            updatepane.setOpacity(0);
            updatepane.setDisable(true);
            outputpane.setDisable(false);
            outputpane.setOpacity(1);
            a1text.setText("");
            a2text.setText("");
            a3text.setText("");
            a4text.setText("");
            a5text.setText("");
            a6text.setText("");
            a7text.setText("");

        }
        else{
            infobox.setText("No such Update Values query possible");
        }
    }


    public void AddQueryClickAction(MouseEvent mouseEvent) {
        String[] input = new String[]{a1text.getText(),a2text.getText(),a3text.getText(),a4text.getText(),a5text.getText(),a6text.getText(),a7text.getText()};

        System.out.println(a1text.getText()+","+a2text.getText()+","+a3text.getText()
                +","+a4text.getText()+","+a5text.getText()+","+a6text.getText()+","+a7text.getText());
        String[] temp=mapping.get(CURRENT_TABLE);


        for (int i=1;i<8;i++)
            System.out.print(temp[i]+",");
        System.out.println(temp[0]);
        //System.out.println(mapping.get(CURRENT_TABLE));


        String output = DBconnection.AddData(input,temp,temp[0]);

        if(output.equals("successfully inserted")){
            updatepane.setDisable(true);
            updatepane.setOpacity(0);
            outputpane.setDisable(false);
            outputpane.setOpacity(1);

            infobox.setText(output);
            String[] input2 = new String[]{"","","","","","",""};
            outputTextbox.setText( DBconnection.SelectData(input2,temp,temp[0]));
            outputTextbox.setFont(Font.font("Consolas", 15));
            System.out.println(output);

            Stage main = (Stage) MainHeadingText.getScene().getWindow();
            main.setWidth(1700);
            mainpane.prefWidth(1700);
            outputTextbox.setEditable(false);

            outputTextbox.prefWidth(2200);
            outputpane.prefWidth(2200);
            updatepane.prefWidth(2200);
            mainpane.prefWidth(2200);

        }else{
            infobox.setText(output);

        }
        a1text.setText("");
        a2text.setText("");
        a3text.setText("");
        a4text.setText("");
        a5text.setText("");
        a6text.setText("");
        a7text.setText("");

    }

}
