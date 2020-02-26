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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Hamza
 */
public class Voter extends Nominee{
     private Connection conn;
    private PreparedStatement pstmt;
    private static String status_str;
    private static String voter_logged_in_name;
    
     public Voter() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///user", "hamza", "iAmrosh2");
        pstmt = null;
    }
     
     public boolean check_voter_details(String voter_usernam, String voter_passwor) throws SQLException { //called by admin
        boolean found = false;
        String u_l_n = "";
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from voter_details where voter_username=? and voter_password=?");

        pstmt.setString(1, voter_usernam);
        pstmt.setString(2, voter_passwor);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            //status = rs.getString("voter_vote_status");
            u_l_n = rs.getString("voter_username");
            //System.out.println("voter found is : "+u_l_n);
            // System.out.println("The vote status of this voter in db class is: "+status);

            found = true;
        }
        voter_logged_in_name = u_l_n;
        //status_str = status;
        return found;
    }
     
      public void cast_vote(Label invalid_text_label, String nominee_id) throws SQLException { //called by voter
        boolean nominee_found = false;
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details where nominee_username=?");
        String query = null;
        pstmt.setString(1, nominee_id);
        int vote_count = 0;
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            vote_count = rs.getInt("nominee_vote_count");
            nominee_found = true;
        }
        query = "Select * from voter_details where voter_username=?";

        pstmt = (PreparedStatement) conn.prepareStatement(query);
        pstmt.setString(1, voter_logged_in_name);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            status_str = rs.getString("voter_vote_status");
        }

        if (nominee_found) //if the id is correct then move to next step
        {
            /*System.out.println("The voter who is going to cast vote is : "+voter_logged_in_name);
            System.out.println("This voter has voter status : "+status_str);*/

            if (status_str.equals("no")) //if vote is not casted then
            {
                //System.out.println("vote count to be incremented for " +nominee_id+" is : "+vote_count);
                vote_count++;
                query = "update nominee_details set nominee_vote_count=? where nominee_username =?";  // for updating vote count of nominee 
                pstmt = (PreparedStatement) conn.prepareStatement(query);
                pstmt.setInt(1, vote_count);
                pstmt.setString(2, nominee_id);
                pstmt.executeUpdate();

                query = "update voter_details set voter_vote_status='casted' where voter_username =?";  // for updating status of vote cast of voter
                pstmt = (PreparedStatement) conn.prepareStatement(query);
                pstmt.setString(1, voter_logged_in_name);
                pstmt.executeUpdate();
                invalid_text_label.setText("Vote casted Successfully!");

            } else //if already casted vote then cant cast again
            {
                invalid_text_label.setText("You have already casted vote!");
            }

        } else //if nominee not found then display error
        {
            invalid_text_label.setText("No such nominee found.Try Again!");
        }
    }

    
     
public void add_voter(String name, String username, int age, String password, TextField voter_username, Label invalid_detail, Button submit_details) throws SQLException { //calld by admin
        boolean duplicate = false;
        pstmt = (PreparedStatement) conn.prepareStatement("insert into voter_details (voter_username,voter_password,voter_vote_status,voter_name,voter_age) values(?,?,?,?,?)");
        PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement("Select * from voter_details where voter_username=?");
        pstmt2.setString(1, username);
        ResultSet rss = pstmt2.executeQuery();
        while (rss.next()) {
            duplicate = true;

        }
        if (duplicate) // if username already exixts in database
        {
            voter_username.clear();
            invalid_detail.setText("Enter different username again please");

        }
        if (duplicate == false) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, "no");
            pstmt.setString(4, name);
            pstmt.setInt(5, age);
            int j = pstmt.executeUpdate();
            if (j > 0) {

                Stage stage = (Stage) submit_details.getScene().getWindow();
                stage.close();
            } else {
                invalid_detail.setText("Info not saved");

            }
        }

    }
    
    
}
