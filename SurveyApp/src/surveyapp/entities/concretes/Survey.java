/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.entities.concretes;

import surveyapp.entities.abstracts.Entity;

public class Survey implements Entity{
    private int surveyId;
    private int userId;
    private String surveyType;
    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int q5;
    private int q6;
    private String thought1;
    private String thought2;
    private String thought3;
    private String thought4;
    private String thought5;
    private String thought6;

    public Survey() {
    }

    public Survey(int userId, String surveyType, int q1, int q2, int q3, int q4, int q5, int q6, String thought1, String thought2, String thought3, String thought4, String thought5, String thought6) {
        this.userId = userId;
        this.surveyType = surveyType;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.thought1 = thought1;
        this.thought2 = thought2;
        this.thought3 = thought3;
        this.thought4 = thought4;
        this.thought5 = thought5;
        this.thought6 = thought6;
    }
    
    

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public String getThought1() {
        return thought1;
    }

    public void setThought1(String thought1) {
        this.thought1 = thought1;
    }

    public String getThought2() {
        return thought2;
    }

    public void setThought2(String thought2) {
        this.thought2 = thought2;
    }

    public String getThought3() {
        return thought3;
    }

    public void setThought3(String thought3) {
        this.thought3 = thought3;
    }

    public String getThought4() {
        return thought4;
    }

    public void setThought4(String thought4) {
        this.thought4 = thought4;
    }

    public String getThought5() {
        return thought5;
    }

    public void setThought5(String thought5) {
        this.thought5 = thought5;
    }

    public String getThought6() {
        return thought6;
    }

    public void setThought6(String thought6) {
        this.thought6 = thought6;
    }
    
}
