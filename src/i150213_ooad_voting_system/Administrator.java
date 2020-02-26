/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i150213_ooad_voting_system;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Hamza
 */
public class Administrator extends Voter {

    private Connection conn;
    private PreparedStatement pstmt;
    
    
    private static Administrator instance = null; //singleton  pattern


    
     private Administrator() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///user", "hamza", "iAmrosh2");
        pstmt = null;
    }
     
     
     public static Administrator getInstance() throws SQLException, ClassNotFoundException
     {
         if(instance==null)
         {
             instance=new Administrator();
         }
         return instance;
     }
      
     
      public void getwinner(TextArea winner_area) throws SQLException {

        int max_count = 0;
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details");
        ResultSet rs = pstmt.executeQuery();
        int max_num = 0;
        while (rs.next()) {
            if (rs.getInt("nominee_vote_count") >= max_num && rs.getInt("nominee_vote_count") != 0) {
                max_num = rs.getInt("nominee_vote_count");
                max_count++;
            }
        }
        if (max_count == 0) {
            winner_area.appendText("There IS no Winner!!!!!!!!!\n");
        } else if (max_count > 0) {
            pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("nominee_vote_count") == max_num) {
                    //System.out.println("the winner id is: " + rs.getString("nominee_username"));
                    winner_area.appendText("Winner's name is : "+rs.getString("nominee_name")+" , "+"The winner id is : "+rs.getString("nominee_username")+" , "+"The winner has the vote count of : "+rs.getString("nominee_vote_count")+"\n");

                }
            }
        }

    }
      
       public boolean check_admin_details(String admin_username, String admin_password) throws SQLException {
        boolean found = false;
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from admin_credentials where username=? and password=?");

        pstmt.setString(1, admin_username);
        pstmt.setString(2, admin_password);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            found = true;
        }
        return found;
    }
       
       
     
}
