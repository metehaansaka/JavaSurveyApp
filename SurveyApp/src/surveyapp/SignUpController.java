package surveyapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import surveyapp.dataAccess.concretes.userDAO;
import surveyapp.entities.concretes.User;

public class SignUpController implements Initializable {

    @FXML
    private Button signUp;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField userName;

    @FXML
    private TextField phone;

    @FXML
    private RadioButton customer;

    @FXML
    private ToggleGroup userType;

    @FXML
    private RadioButton manager;

    @FXML
    private RadioButton employe;

    @FXML
    private ImageView backButton;
    
    @FXML
    private Label errorLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backButton.setOnMouseClicked((event) -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        });
    }

    @FXML
    public void signUp(ActionEvent event) throws IOException{
        userDAO uDAO = new userDAO();
        int type;
        String resource;
        if(employe.isSelected()){
            resource = "SurveyMainEmployee.fxml";
            type = 2;
        }else if(manager.isSelected()){
            resource = "SurveyMainManagerHR.fxml";
            type = 1;
        }else {
            resource = "SurveyMainCustomer.fxml";
            type = 3;
        }
        LoginController.user = new User(userName.getText(), password.getText(), email.getText(), phone.getText(), type);
        if(uDAO.insert(LoginController.user)){
            errorLabel.setVisible(false);
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        }else{
            errorLabel.setVisible(true);
        }
        
    }
}
