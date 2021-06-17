package surveyapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SurveyMainCustomerController implements Initializable {

    @FXML
    private Label successLabel;

    @FXML
    private Label errorLabel;

    public static int status = 0;

    public void surveyOnProducts(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "ProductSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void surveyOnStaff(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "StaffSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (status == 1) {
            successLabel.setVisible(true);
            errorLabel.setVisible(false);
        } else if (status == 2) {
            successLabel.setVisible(false);
            errorLabel.setVisible(true);
        }
    }
    

}
