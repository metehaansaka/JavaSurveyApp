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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import surveyapp.dataAccess.concretes.userDAO;
import surveyapp.entities.concretes.User;

public class LoginController implements Initializable {

    public static User user;

    @FXML
    private Label signUp;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorLabel;

    public void login(ActionEvent event) throws IOException {

        userDAO uDAO = new userDAO();
        user = uDAO.getUser(username.getText(), password.getText());
        Parent root;
        if (user != null) {
            if (user.getUserType() == 1) {
                root = FXMLLoader.load(getClass().getResource("SurveyMainManagerHR.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
            } else if (user.getUserType() == 2) {
                root = FXMLLoader.load(getClass().getResource("SurveyMainEmployee.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
            } else if (user.getUserType() == 3) {
                root = FXMLLoader.load(getClass().getResource("SurveyMainCustomer.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
            }
        } else {
            errorLabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signUp.setOnMouseClicked(click -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = (Stage) signUp.getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.getRoot());
                stage.setScene(scene);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
