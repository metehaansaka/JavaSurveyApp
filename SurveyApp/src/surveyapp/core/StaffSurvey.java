/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class StaffSurvey implements Questions{

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("Do our customer representatives fully and accurately understand your expectations?");
        questionList.add("Are your requests answered within a reasonable time?");
        questionList.add("Do our customer representatives visit you enough?");
        questionList.add("Is the content of our offers understandable and clear?");
        questionList.add("Even if the feasibility result is negative, can you get a response to your requests?");
        questionList.add("Information about your orders; Do you get it easily, quickly and accurately?");
        return questionList;
    }
    
}
