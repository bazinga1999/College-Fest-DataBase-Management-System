package message;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Fest4Controller implements Initializable {
    private static String username;
    public Button sendbutton;
    public Button newbutton;
    public AnchorPane recievedpane;
    @FXML
    private AnchorPane recievepane;
    @FXML
    private AnchorPane sendpane;
    @FXML
    private Label recievetextarea;
    @FXML
    private TextArea sendmessagearea;
    @FXML
    private TextField recievernamearea;

    public static void setusername(String s){
        username=s;
    }

    public  void deserialize() {
       BufferedReader reader;
       String fin="";
       try{
           reader=new BufferedReader(new FileReader("messages.txt"));
           String line =reader.readLine();
           int i=0;
           while(line!=null){
               System.out.println("this is :"+i+" line: "+line);
               i++;
               int temp=line.indexOf("To:"+username);
               System.out.println("Found or not: "+temp);
               int temp2=line.indexOf("\n");
               if(temp!=-1){
                   String mess=line.substring(temp+username.length()+3);
                   int first=mess.indexOf("message");
                   String another_mess=mess.substring(0,first);
                   String another_another_mess=mess.substring(first);
                   System.out.println("Extracted message: "+mess);
                   fin+=another_mess+"\n"+another_another_mess+"\n";
               }
               line=reader.readLine();
           }
           System.out.println("Here outside loop");
           recievetextarea.setText(fin);
       }catch (IOException e){
           recievetextarea.setText("No messages");
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       deserialize();
    }

    public void opensendpane(MouseEvent mouseEvent) {
        sendpane.setOpacity(1);
        sendpane.setDisable(false);
    }

    public void sendmessage(MouseEvent mouseEvent) throws IOException {
        if(recievernamearea.getText().compareTo("")!=0&& sendmessagearea.getText().compareTo("")!=0){
            String temp="To:"+recievernamearea.getText()+"from : "+username+" message : "+sendmessagearea.getText();
            BufferedWriter writer =new BufferedWriter(new FileWriter("messages.txt",true));
            writer.newLine();
            writer.write(temp);
            writer.close();

        }
    }

    public void goback(MouseEvent mouseEvent) {
        Stage myStage = (Stage) recievetextarea.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest2/FXMLDOCUMENT1.fxml"));
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
