package surveyapp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import surveyapp.dataAccess.concretes.userDAO;
import surveyapp.entities.concretes.User;

public class SurveyMainEmployeeController implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView buttonImage;

    @FXML
    private Label buttonText;

    public String generateString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    private int currentId;
    private int anonId;
    private boolean modeAnonymous = false;
    User user = new User("anonymous-" + generateString(),"anonymous-" + generateString(),  "anonymous-" + generateString(), "anonymous-" + generateString(), 2);
    boolean status = false;

    public void continueAnonymously(ActionEvent event) {
        if (modeAnonymous == false) {
            if (!status) {
                userDAO uDao = new userDAO();
                anonId = uDao.insertAnon(user);
                status = true;
            }
            currentId = LoginController.user.getUserId();
            LoginController.user.setUserId(anonId);
            welcomeText.setText("Welcome Anonymous!");
            buttonText.setText("Continue as Employee");
            File file = new File("src\\surveyapp\\assets\\staff.png");
            Image image = new Image(file.toURI().toString());
            buttonImage.setImage(image);
            modeAnonymous = true;
        } else {
            LoginController.user.setUserId(currentId);
            welcomeText.setText("Welcome Employee!");
            buttonText.setText("Continue as Anonymous");
            File file = new File("src\\surveyapp\\assets\\anonymous.png");
            Image image = new Image(file.toURI().toString());
            buttonImage.setImage(image);
            modeAnonymous = false;
        }
    }

    public void surveyOnWorkingConditions(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "WorkingConditionsSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void surveyOnManagers(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "ManagerSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void surveyOnCompanyManagement(ActionEvent event) throws IOException {
        FillSurveyController.surveyType = "CompanyManagementSurvey";
        Parent root = FXMLLoader.load(getClass().getResource("FillSurvey.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void logOut(ActionEvent event) throws IOException {
        status = false;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
