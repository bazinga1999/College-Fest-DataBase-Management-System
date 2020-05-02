package fest4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.mail.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static fest.Fest.dates;
import static fest.Fest.meetings;

public class FXMLDocument3Controller {
    public Label head;
    public Label first;
    public Label second;
    public Label third;
    public Label fourth;
    public Label fifth;


    public Label firstdate;
    public Label seconddate;
    public Label thirddate;
    public Label fourthdate;
    public Label fifthdate;
    public Button back;
    public Button update;
    public Button notifier;

    public void initialize(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        dates.add(LocalDate.parse("2019-05-29", formatter));
//        dates.add(LocalDate.parse("2020-05-29", formatter));
//        meetings.add("abcfd");
//        meetings.add("ajnlmd");
        System.out.println(meetings);
        try{
            if (dates.get(0).compareTo(LocalDate.now())>0 && dates.get(0)!=null){
                first.setText(meetings.get(0));
                firstdate.setText(dates.get(0).toString());
            }
            else{
                meetings.remove(0);
                dates.remove(0);
                first.setText("Meeting 1");
                firstdate.setText("Date 1");
                System.out.println(meetings);
            }
        }
        catch (IndexOutOfBoundsException e){
        }
        finally {
            System.out.println(1);
            try {
                if (dates.get(1).compareTo(LocalDate.now())>0 && dates.get(1)!=null){
                    second.setText(meetings.get(1));
                    seconddate.setText(dates.get(1).toString());
                }
                else{
                    meetings.remove(1);
                    dates.remove(1);
                    second.setText("Meeting 2");
                    seconddate.setText("Date 2");
                }
            }
            catch (IndexOutOfBoundsException e){
            }
            finally {
                System.out.println(2);
                try {
                    if (dates.get(2).compareTo(LocalDate.now())>0 && dates.get(2)!=null){
                        third.setText(meetings.get(2));
                        thirddate.setText(dates.get(2).toString());
                    }
                    else{
                        meetings.remove(2);
                        dates.remove(2);
                        third.setText("Meeting 3");
                        thirddate.setText("Date 3");
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                finally {
                    System.out.println(3);
                    try {
                        if (dates.get(3).compareTo(LocalDate.now())>0 && dates.get(3)!=null){
                            fourth.setText(meetings.get(3));
                            fourthdate.setText(dates.get(3).toString());
                        }
                        else{
                            meetings.remove(3);
                            dates.remove(3);
                            fourth.setText("Meeting 4");
                            fourthdate.setText("Date 4");
                        }
                    }
                    catch (IndexOutOfBoundsException e){
                    }
                    finally {
                        System.out.println(4);
                        try {
                            if (dates.get(4).compareTo(LocalDate.now()) > 0 && dates.get(4) != null) {
                                fifth.setText(meetings.get(4));
                                fifthdate.setText(dates.get(4).toString());
                            } else {
                                meetings.remove(4);
                                dates.remove(4);
                                fifth.setText("Meeting 5");
                                fifthdate.setText("Date 5");
                            }
                        }
                        catch (IndexOutOfBoundsException e){
                        }
                    }
                }
            }
        }


    }

    public void selecttypescreenopen() {
        Stage myStage = (Stage) back.getScene().getWindow();
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

    public void updatescreenopen(){
        Stage myStage = (Stage) update.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fest5/FXMLDocument4.fxml"));
        AnchorPane mainpane = null;
        try {
            mainpane = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Button Pressed      " + mainpane);
        myStage.setScene(new Scene(mainpane, 1040, 730));
    }

    public void notifierr() throws Exception{

        JavaMailUtil.sendMail("shourya18311@iiitd.ac.in");
        JavaMailUtil.sendMail("ritvik18085@iiitd.ac.in");
        JavaMailUtil.sendMail("prutyay18403@iiitd.ac.in");
        JavaMailUtil.sendMail("peeyush18402@iiitd.ac.in");
        JavaMailUtil.sendMail("muskan18297@iiitd.ac.in");
    }
}
