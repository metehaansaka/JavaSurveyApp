/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class WorkingConditionsSurvey implements Questions{

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("The work I do in the institution allows for personal development.");
        questionList.add("I know what is expected of me in relation to my job at the organization.");
        questionList.add("I am satisfied with my job in the company.");
        questionList.add("I am able to obtain the necessary information for my job in the institution accurately and on time.");
        questionList.add("My opinion is given importance in decisions that will affect my work in the institution.");
        questionList.add("The ability of department employees to work in solidarity, cooperation and team spirit in the institution.");
        return questionList;
    }
    
}
