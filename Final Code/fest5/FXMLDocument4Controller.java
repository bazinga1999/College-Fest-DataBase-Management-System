package fest5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static fest.Fest.dates;
import static fest.Fest.meetings;

public class FXMLDocument4Controller {
    public Button add;
    public Button Back;
    public TextField meeting;
    public TextField date;
    public Label prompt;

    public void add(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d=LocalDate.parse(date.getText(), formatter);
        if(d.compareTo(LocalDate.now())>0){
            dates.add(d);
            meetings.add(meeting.getText());
            prompt.setText("Meeting noted successfully.");
        }
        else{
            prompt.setText("Invalid details");
        }
    }

    public void selecttypescreenopen(){
        Stage myStage = (Stage) Back.getScene().getWindow();
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

