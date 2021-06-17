/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.util.ArrayList;
import java.util.List;

public class ProductSurvey implements Questions{

    @Override
    public List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("What is your satisfaction with the delivery and delivery times of your order?");
        questionList.add("Can we offer you quality products?");
        questionList.add("What is our level of resolving your complaints?");
        questionList.add("How do you find the correction time for nonconformities?");
        questionList.add("What is your satisfaction about after-sales technical service?");
        questionList.add("Does the product portfolio we offer you meet your expectations and needs?");
        return questionList;
    }
    
}
