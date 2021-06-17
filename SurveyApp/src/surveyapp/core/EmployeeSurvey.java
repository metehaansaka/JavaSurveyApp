/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSurvey implements Questions {

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("How are the staff's ability to communicate with you.");
        questionList.add("Does our staff perform the assigned tasks on time?");
        questionList.add("Do our staff adequately comply with the rules of your business?");
        questionList.add("Can you easily reach our representative in case of a problem?");
        questionList.add("Can our company representative give you enlightening information?");
        questionList.add("Are you satisfied with our services?");
        return questionList;
    }

}
