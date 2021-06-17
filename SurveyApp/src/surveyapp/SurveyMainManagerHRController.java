
package surveyapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SurveyMainManagerHRController implements Initializable {

    
    public static String viewType;

    public void fillSurveyOnEmployee(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "EmployeeSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }

    public void viewEmployeeSurvey(ActionEvent event) throws IOException {
        viewType = "employee";
        Parent root = FXMLLoader.load(getClass().getResource("ViewSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void viewCustomerSurvey(ActionEvent event) throws IOException {
        viewType = "customer";
        Parent root = FXMLLoader.load(getClass().getResource("ViewSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }
    
    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ( (Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
