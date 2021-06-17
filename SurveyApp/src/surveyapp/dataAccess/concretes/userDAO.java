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
import java.util.ArrayList;
import java.util.List;
import surveyapp.core.DBConnection;
import surveyapp.entities.concretes.User;

/**
 *
 * @author ACER
 */
public class userDAO {

    public boolean insert(User user) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO users (username, password, email, phone, user_type) VALUES ('"+user.getUserName()+"', '"+user.getPassword()+"', '"+user.getEmail()+"', '"+user.getPhone()+"', "+user.getUserType()+" )");
            return true;
        } catch (SQLException ex) {
            System.out.println("HATA = " +  ex.getMessage());
            return false;
        }
    }
    
    public User getUser(String userName, String password){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        User user = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from users where username = '"+userName+"' and password = '"+password+"'");
            if(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserType(rs.getInt("user_type"));
            }
        } catch (SQLException ex) {
            System.out.println("Hata => " + ex.getMessage());
        }
        return user;
    }
    
    public List<User> getUserList(int id){
        List<User> userList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        User user = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from users where user_type="+id);
            while(rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserType(rs.getInt("user_type"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Hata => " + ex.getMessage());
        }
        return userList;
    }
    
    public int insertAnon(User user) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int id = 0;
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO users (username, password, email, phone, user_type) VALUES ('"+user.getUserName()+"', '"+user.getPassword()+"', '"+user.getEmail()+"', '"+user.getPhone()+"', "+user.getUserType()+" )");
            ResultSet rs = st.executeQuery("Select * from users order by user_id DESC");
            if (rs.next()) {
                id = rs.getInt("user_id");
            }
        } catch (SQLException ex) {
            System.out.println("HATA = " +  ex.getMessage());
        }
        return id;
    }
    
}
