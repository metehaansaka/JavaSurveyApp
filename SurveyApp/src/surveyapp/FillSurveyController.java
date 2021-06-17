package surveyapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import surveyapp.core.CompanyManagement;
import surveyapp.core.EmployeeSurvey;
import surveyapp.core.ManagerSurvey;
import surveyapp.core.ProductSurvey;
import surveyapp.core.Questions;
import surveyapp.core.StaffSurvey;
import surveyapp.core.WorkingConditionsSurvey;
import surveyapp.dataAccess.concretes.surveyDAO;
import surveyapp.entities.concretes.Survey;

public class FillSurveyController implements Initializable {

    public static String surveyType;
    public static Questions questions;
    public static List<String> questionList = new ArrayList<>();

    @FXML
    private ImageView backButton;

    @FXML
    private ToggleGroup question1;

    @FXML
    private ToggleGroup question2;

    @FXML
    private ToggleGroup question3;

    @FXML
    private ToggleGroup question4;

    @FXML
    private ToggleGroup question5;

    @FXML
    private ToggleGroup question6;

    @FXML
    private Button submitButton;

    @FXML
    private TextField thoughts1;

    @FXML
    private TextField thoughts2;

    @FXML
    private TextField thoughts3;

    @FXML
    private TextField thoughts4;

    @FXML
    private TextField thoughts5;

    @FXML
    private TextField thoughts6;

    @FXML
    private Text q1Label;

    @FXML
    private Text q2Label;

    @FXML
    private Text q3Label;

    @FXML
    private Text q4Label;

    @FXML
    private Text q5Label;

    @FXML
    private Text q6Label;

    @FXML
    void submit(ActionEvent event) {
        int[] questions = new int[6];
        RadioButton selected = (RadioButton) question1.getSelectedToggle();
        questions[0] = Integer.parseInt(selected.getText());
        selected = (RadioButton) question2.getSelectedToggle();
        questions[1] = Integer.parseInt(selected.getText());
        selected = (RadioButton) question3.getSelectedToggle();
        questions[2] = Integer.parseInt(selected.getText());
        selected = (RadioButton) question4.getSelectedToggle();
        questions[3] = Integer.parseInt(selected.getText());
        selected = (RadioButton) question5.getSelectedToggle();
        questions[4] = Integer.parseInt(selected.getText());
        selected = (RadioButton) question6.getSelectedToggle();
        questions[5] = Integer.parseInt(selected.getText());
        String[] thoughts = {thoughts1.getText(), thoughts2.getText(), thoughts3.getText(), thoughts4.getText(), thoughts5.getText(), thoughts6.getText()};
        Survey survey = new Survey(LoginController.user.getUserId(), surveyType, questions[0], questions[1], questions[2], questions[3], questions[4], questions[5], thoughts[0], thoughts[1], thoughts[2], thoughts[3], thoughts[4], thoughts[5]);
        boolean status = surveyDAO.submit(survey);
        if (status) {
            SurveyMainCustomerController.status = 1;
        } else {
            SurveyMainCustomerController.status = 2;
        }
        Parent root = null;
        System.out.println(LoginController.user.getUserType());
        if (LoginController.user.getUserType() == 3) {
            try {
                root = FXMLLoader.load(getClass().getResource("SurveyMainCustomer.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (LoginController.user.getUserType() == 2) {
            try {
                root = FXMLLoader.load(getClass().getResource("SurveyMainEmployee.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                root = FXMLLoader.load(getClass().getResource("SurveyMainManagerHR.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (root != null) {

            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getSurveyType();
        backButton.setOnMouseClicked((event) -> {
            Parent root = null;
            if (LoginController.user.getUserType() == 3) {
                try {
                    root = FXMLLoader.load(getClass().getResource("SurveyMainCustomer.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (LoginController.user.getUserType() == 2) {
                try {
                    root = FXMLLoader.load(getClass().getResource("SurveyMainEmployee.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    root = FXMLLoader.load(getClass().getResource("SurveyMainManagerHR.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        });

    }

    public void getSurveyType() {
        switch (surveyType) {
            case "ProductSurvey":
                questions = new ProductSurvey();
                break;
            case "StaffSurvey":
                questions = new StaffSurvey();
                break;
            case "WorkingConditionsSurvey":
                questions = new WorkingConditionsSurvey();
                break;
            case "ManagerSurvey":
                questions = new ManagerSurvey();
                break;
            case "CompanyManagementSurvey":
                questions = new CompanyManagement();
                break;
            case "EmployeeSurvey":
                questions = new EmployeeSurvey();
                break;
            default:
                questions = new ProductSurvey();
                break;
        }
        questionList = questions.getQuestionList();
        q1Label.setText(questionList.get(0));
        q2Label.setText(questionList.get(1));
        q3Label.setText(questionList.get(2));
        q4Label.setText(questionList.get(3));
        q5Label.setText(questionList.get(4));
        q6Label.setText(questionList.get(5));
    }

}
