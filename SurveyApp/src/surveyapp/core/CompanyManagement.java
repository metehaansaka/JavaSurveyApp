/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class CompanyManagement implements Questions{

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("Managers in the organization exhibit leadership behaviors.");
        questionList.add("I can communicate well with the managers in the organization.");
        questionList.add("I am generally satisfied with the management of the institution.");
        questionList.add("Working as a team of senior executives.");
        questionList.add("Company management makes effective and quick decisions.");
        questionList.add("Ensuring equal opportunity in services for employees in the institution.");
        return questionList;
    }
    
}
