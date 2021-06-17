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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static surveyapp.FillSurveyController.questionList;
import surveyapp.core.CompanyManagement;
import surveyapp.core.ManagerSurvey;
import surveyapp.core.ProductSurvey;
import surveyapp.core.Questions;
import surveyapp.core.StaffSurvey;
import surveyapp.core.WorkingConditionsSurvey;
import surveyapp.dataAccess.concretes.surveyDAO;
import surveyapp.dataAccess.concretes.userDAO;
import surveyapp.entities.concretes.Survey;
import surveyapp.entities.concretes.User;

public class ViewSurveyController implements Initializable {

    @FXML
    private SplitMenuButton splitMenuButton;

    @FXML
    private ImageView backButton;

    @FXML
    private Text q1txt;

    @FXML
    private Text q2txt;

    @FXML
    private Text q3txt;

    @FXML
    private Text q4txt;

    @FXML
    private Text q5txt;

    @FXML
    private Text q6txt;

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
    private ToggleGroup question1;

    @FXML
    private RadioButton q2;

    @FXML
    private RadioButton q5;

    @FXML
    private RadioButton q3;

    @FXML
    private RadioButton q4;

    @FXML
    private RadioButton q1;

    @FXML
    private RadioButton q6;

    @FXML
    private TextField th1;

    @FXML
    private TextField th2;

    @FXML
    private TextField th3;

    @FXML
    private TextField th4;

    @FXML
    private TextField th5;

    @FXML
    private TextField th6;

    Menu menu;
    Questions questions;
    List<String> questionList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (SurveyMainManagerHRController.viewType.equals("customer")) {
            splitMenuButton.setText("Customers");
            userDAO uDAO = new userDAO();
            List<User> users = uDAO.getUserList(3);
            int[] average = surveyDAO.getAverage("ProductSurvey");
            ToggleGroup[] arrayT = {question1, question2, question3, question4, question5, question6};
            for (int i = 0; i < 6; i++) {
                arrayT[i].selectToggle(arrayT[i].getToggles().get(average[i]));
            }
            menu = new Menu("Average Customers");
            menu.getItems().addAll(new MenuItem("Survey on Products Average"), new MenuItem("Survey on Staff Average"));
            splitMenuButton.getItems().addAll(menu);
            menu.getItems().get(0).setOnAction(e -> {
                splitMenuButton.setText("Survey on Products Average");
                questions = new ProductSurvey();
                questionList = questions.getQuestionList();
                q1txt.setText(questionList.get(0));
                q2txt.setText(questionList.get(1));
                q3txt.setText(questionList.get(2));
                q4txt.setText(questionList.get(3));
                q5txt.setText(questionList.get(4));
                q6txt.setText(questionList.get(5));
                int[] average2 = surveyDAO.getAverage("ProductSurvey");
                ToggleGroup[] arrayT2 = {question1, question2, question3, question4, question5, question6};
                for (int i = 0; i < 6; i++) {
                    arrayT2[i].selectToggle(arrayT2[i].getToggles().get(average2[i]));
                }
            });
            menu.getItems().get(1).setOnAction(e -> {
                splitMenuButton.setText("Survey on Staff Average");
                questions = new StaffSurvey();
                questionList = questions.getQuestionList();
                q1txt.setText(questionList.get(0));
                q2txt.setText(questionList.get(1));
                q3txt.setText(questionList.get(2));
                q4txt.setText(questionList.get(3));
                q5txt.setText(questionList.get(4));
                q6txt.setText(questionList.get(5));
                int[] average2 = surveyDAO.getAverage("StaffSurvey");
                ToggleGroup[] arrayT2 = {question1, question2, question3, question4, question5, question6};
                for (int i = 0; i < 6; i++) {
                    arrayT2[i].selectToggle(arrayT2[i].getToggles().get(average2[i]));
                }
            });
            for (User u : users) {
                menu = new Menu(u.getUserName());
                menu.getItems().addAll(new MenuItem("Survey on Products"), new MenuItem("Survey on Staff"));
                splitMenuButton.getItems().addAll(menu);
                menu.getItems().get(0).setOnAction(e -> {
                    splitMenuButton.setText(u.getUserName());
                    questions = new ProductSurvey();
                    questionList = questions.getQuestionList();
                    q1txt.setText(questionList.get(0));
                    q2txt.setText(questionList.get(1));
                    q3txt.setText(questionList.get(2));
                    q4txt.setText(questionList.get(3));
                    q5txt.setText(questionList.get(4));
                    q6txt.setText(questionList.get(5));
                    Survey survey = surveyDAO.geySurvey(u.getUserId(), "ProductSurvey");
                    int[] array = {survey.getQ1(), survey.getQ2(), survey.getQ3(), survey.getQ4(), survey.getQ5(), survey.getQ6()};
                    ToggleGroup[] toggleArray = {question1, question2, question3, question4, question5, question6};
                    TextField[] textArray = {th1, th2, th3, th4, th5, th6};
                    String[] sArray = {survey.getThought1(), survey.getThought2(), survey.getThought3(), survey.getThought4(), survey.getThought5(), survey.getThought6()};
                    for (int i = 0; i < 6; i++) {
                        toggleArray[i].selectToggle(toggleArray[i].getToggles().get(array[i] - 1));
                        textArray[i].setText(sArray[i]);
                    }
                });

                menu.getItems().get(1).setOnAction(e -> {
                    splitMenuButton.setText(u.getUserName());
                    questions = new StaffSurvey();
                    questionList = questions.getQuestionList();
                    q1txt.setText(questionList.get(0));
                    q2txt.setText(questionList.get(1));
                    q3txt.setText(questionList.get(2));
                    q4txt.setText(questionList.get(3));
                    q5txt.setText(questionList.get(4));
                    q6txt.setText(questionList.get(5));
                    Survey survey = surveyDAO.geySurvey(u.getUserId(), "StaffSurvey");
                    int[] array = {survey.getQ1(), survey.getQ2(), survey.getQ3(), survey.getQ4(), survey.getQ5(), survey.getQ6()};
                    ToggleGroup[] toggleArray = {question1, question2, question3, question4, question5, question6};
                    TextField[] textArray = {th1, th2, th3, th4, th5, th6};
                    String[] sArray = {survey.getThought1(), survey.getThought2(), survey.getThought3(), survey.getThought4(), survey.getThought5(), survey.getThought6()};
                    for (int i = 0; i < 6; i++) {
                        toggleArray[i].selectToggle(toggleArray[i].getToggles().get(array[i] - 1));
                        textArray[i].setText(sArray[i]);
                    }
                });
            }
        } else {
            splitMenuButton.setText("Employees");
            userDAO uDAO = new userDAO();
            List<User> users = uDAO.getUserList(2);
            int[] average = surveyDAO.getAverage("WorkingConditionsSurvey");
            ToggleGroup[] arrayT = {question1, question2, question3, question4, question5, question6};
            for (int i = 0; i < 6; i++) {
                arrayT[i].selectToggle(arrayT[i].getToggles().get(average[i]));
            }
            menu = new Menu("Average Employees");
            menu.getItems().addAll(new MenuItem("Survey on Working Conditions Average"), new MenuItem("Survey on Managers Average"), new MenuItem("Survey on Company Management Average"));
            splitMenuButton.getItems().addAll(menu);
            menu.getItems().get(0).setOnAction(e -> {
                splitMenuButton.setText("Survey on Working Conditions Average");
                questions = new WorkingConditionsSurvey();
                questionList = questions.getQuestionList();
                q1txt.setText(questionList.get(0));
                q2txt.setText(questionList.get(1));
                q3txt.setText(questionList.get(2));
                q4txt.setText(questionList.get(3));
                q5txt.setText(questionList.get(4));
                q6txt.setText(questionList.get(5));
                int[] average2 = surveyDAO.getAverage("WorkingConditionsSurvey");
                ToggleGroup[] arrayT2 = {question1, question2, question3, question4, question5, question6};
                for (int i = 0; i < 6; i++) {
                    arrayT2[i].selectToggle(arrayT2[i].getToggles().get(average2[i]));
                }
            });
            menu.getItems().get(1).setOnAction(e -> {
                splitMenuButton.setText("Survey on Managers Average");
                questions = new ManagerSurvey();
                questionList = questions.getQuestionList();
                q1txt.setText(questionList.get(0));
                q2txt.setText(questionList.get(1));
                q3txt.setText(questionList.get(2));
                q4txt.setText(questionList.get(3));
                q5txt.setText(questionList.get(4));
                q6txt.setText(questionList.get(5));
                int[] average2 = surveyDAO.getAverage("ManagerSurvey");
                ToggleGroup[] arrayT2 = {question1, question2, question3, question4, question5, question6};
                for (int i = 0; i < 6; i++) {
                    arrayT2[i].selectToggle(arrayT2[i].getToggles().get(average2[i]));
                }
            });
            
            menu.getItems().get(2).setOnAction(e -> {
                splitMenuButton.setText("Survey on Company Management Average");
                questions = new CompanyManagement();
                questionList = questions.getQuestionList();
                q1txt.setText(questionList.get(0));
                q2txt.setText(questionList.get(1));
                q3txt.setText(questionList.get(2));
                q4txt.setText(questionList.get(3));
                q5txt.setText(questionList.get(4));
                q6txt.setText(questionList.get(5));
                int[] average2 = surveyDAO.getAverage("CompanyManagementSurvey");
                ToggleGroup[] arrayT2 = {question1, question2, question3, question4, question5, question6};
                for (int i = 0; i < 6; i++) {
                    arrayT2[i].selectToggle(arrayT2[i].getToggles().get(average2[i]));
                }
            });

            for (User u : users) {
                menu = new Menu(u.getUserName());
                menu.setId(String.valueOf(u.getUserId()));
                menu.getItems().addAll(new MenuItem("Survey on Working Conditions"), new MenuItem("Survey on Managers"), new MenuItem("Survey on Company Management"));
                splitMenuButton.getItems().addAll(menu);
                menu.getItems().get(0).setOnAction(e -> {
                    splitMenuButton.setText(u.getUserName());
                    questions = new WorkingConditionsSurvey();
                    questionList = questions.getQuestionList();
                    q1txt.setText(questionList.get(0));
                    q2txt.setText(questionList.get(1));
                    q3txt.setText(questionList.get(2));
                    q4txt.setText(questionList.get(3));
                    q5txt.setText(questionList.get(4));
                    q6txt.setText(questionList.get(5));
                    Survey survey = surveyDAO.geySurvey(u.getUserId(), "WorkingConditionsSurvey");
                    int[] array = {survey.getQ1(), survey.getQ2(), survey.getQ3(), survey.getQ4(), survey.getQ5(), survey.getQ6()};
                    ToggleGroup[] toggleArray = {question1, question2, question3, question4, question5, question6};
                    TextField[] textArray = {th1, th2, th3, th4, th5, th6};
                    String[] sArray = {survey.getThought1(), survey.getThought2(), survey.getThought3(), survey.getThought4(), survey.getThought5(), survey.getThought6()};
                    for (int i = 0; i < 6; i++) {
                        toggleArray[i].selectToggle(toggleArray[i].getToggles().get(array[i] - 1));
                        textArray[i].setText(sArray[i]);
                    }
                });

                menu.getItems().get(1).setOnAction(e -> {
                    splitMenuButton.setText(u.getUserName());
                    questions = new ManagerSurvey();
                    questionList = questions.getQuestionList();
                    q1txt.setText(questionList.get(0));
                    q2txt.setText(questionList.get(1));
                    q3txt.setText(questionList.get(2));
                    q4txt.setText(questionList.get(3));
                    q5txt.setText(questionList.get(4));
                    q6txt.setText(questionList.get(5));
                    Survey survey = surveyDAO.geySurvey(u.getUserId(), "ManagerSurvey");
                    int[] array = {survey.getQ1(), survey.getQ2(), survey.getQ3(), survey.getQ4(), survey.getQ5(), survey.getQ6()};
                    ToggleGroup[] toggleArray = {question1, question2, question3, question4, question5, question6};
                    TextField[] textArray = {th1, th2, th3, th4, th5, th6};
                    String[] sArray = {survey.getThought1(), survey.getThought2(), survey.getThought3(), survey.getThought4(), survey.getThought5(), survey.getThought6()};
                    for (int i = 0; i < 6; i++) {
                        toggleArray[i].selectToggle(toggleArray[i].getToggles().get(array[i] - 1));
                        textArray[i].setText(sArray[i]);
                    }
                });
                menu.getItems().get(2).setOnAction(e -> {
                    splitMenuButton.setText(u.getUserName());
                    questions = new CompanyManagement();
                    questionList = questions.getQuestionList();
                    q1txt.setText(questionList.get(0));
                    q2txt.setText(questionList.get(1));
                    q3txt.setText(questionList.get(2));
                    q4txt.setText(questionList.get(3));
                    q5txt.setText(questionList.get(4));
                    q6txt.setText(questionList.get(5));
                    Survey survey = surveyDAO.geySurvey(u.getUserId(), "CompanyManagementSurvey");
                    int[] array = {survey.getQ1(), survey.getQ2(), survey.getQ3(), survey.getQ4(), survey.getQ5(), survey.getQ6()};
                    ToggleGroup[] toggleArray = {question1, question2, question3, question4, question5, question6};
                    TextField[] textArray = {th1, th2, th3, th4, th5, th6};
                    String[] sArray = {survey.getThought1(), survey.getThought2(), survey.getThought3(), survey.getThought4(), survey.getThought5(), survey.getThought6()};
                    for (int i = 0; i < 6; i++) {
                        toggleArray[i].selectToggle(toggleArray[i].getToggles().get(array[i] - 1));
                        textArray[i].setText(sArray[i]);
                    }
                });
            }

        }
        backButton.setOnMouseClicked((event) -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("SurveyMainManagerHR.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ViewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        });
    }

}
