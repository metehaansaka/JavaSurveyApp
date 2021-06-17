/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.dataAccess.concretes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import surveyapp.core.DBConnection;
import surveyapp.entities.concretes.Survey;
import surveyapp.entities.concretes.User;



public class surveyDAO {
    public static boolean submit(Survey survey){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO surveys (user_id, survey_type, q1, q2, q3, q4, q5, q6, thought1, thought2, thought3, thought4, thought5, thought6) VALUES ("+survey.getUserId()+", '"+survey.getSurveyType()+"', "+survey.getQ1()+", "+survey.getQ2()+", "+survey.getQ3()+", "+survey.getQ4()+", "+survey.getQ5()+", "+survey.getQ6()+", '"+survey.getThought1()+"', '"+survey.getThought2()+"', '"+survey.getThought3()+"', '"+survey.getThought4()+"', '"+survey.getThought5()+"', '"+survey.getThought6()+"' )");
            return true;
        } catch (SQLException ex) {
            System.out.println("HATA = " +  ex.getMessage());
            return false;
        }
    }
    
    public static Survey geySurvey(int userId, String surveyType){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Survey survey = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from surveys where user_id = "+userId+" and survey_type = '"+surveyType+"'");
            if(rs.next()){
                survey = new Survey();
                survey.setSurveyId(rs.getInt("survey_id"));
                survey.setUserId(rs.getInt("user_id"));
                survey.setSurveyType(rs.getString("survey_type"));
                survey.setQ1(rs.getInt("q1"));
                survey.setQ2(rs.getInt("q2"));
                survey.setQ3(rs.getInt("q3"));
                survey.setQ4(rs.getInt("q4"));
                survey.setQ5(rs.getInt("q5"));
                survey.setQ6(rs.getInt("q6"));
                survey.setThought1(rs.getString("thought1"));
                survey.setThought2(rs.getString("thought2"));
                survey.setThought3(rs.getString("thought3"));
                survey.setThought4(rs.getString("thought4"));
                survey.setThought5(rs.getString("thought5"));
                survey.setThought6(rs.getString("thought6"));
            }
        } catch (SQLException ex) {
            System.out.println("Hata => " + ex.getMessage());
        }
        return survey;
    }
    
    public static int[] getAverage(String surveyType){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int average[] = new int[6];
        int count = 0;
        int q[] = new int[6];
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(q1) as q1,SUM(q2) as q2,SUM(q3) as q3, SUM(q4) as q4, SUM(q5) as q5, SUM(q6) as q6, COUNT(*) FROM surveys where survey_type = '"+surveyType+"'");
            if(rs.next()){
                q[0] = rs.getInt("q1");
                q[1] = rs.getInt("q2");
                q[2] = rs.getInt("q3");
                q[3] = rs.getInt("q4");
                q[4] = rs.getInt("q5");
                q[5] = rs.getInt("q6");
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            System.out.println("Hata => " + ex.getMessage());
        }
        for (int i = 0; i < 6; i++) {
            average[i] = q[i] / count;
        }
        return average;
    }
    
    
}
