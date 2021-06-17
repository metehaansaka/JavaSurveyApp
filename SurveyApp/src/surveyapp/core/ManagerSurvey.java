/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class ManagerSurvey implements Questions{

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("My manager motivates me.");
        questionList.add("My manager is open and willing to communicate.");
        questionList.add("My manager encourages personal development.");
        questionList.add("My manager treats mistakes made constructively.");
        questionList.add("My manager gives authority and responsibilities related to my job.");
        questionList.add("Overall, I am satisfied with my supervisor.");
        return questionList;
    }
    
}
