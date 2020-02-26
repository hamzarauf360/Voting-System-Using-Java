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
public class Nominee {

    private Connection conn;
    private PreparedStatement pstmt;
    private static String nominee_logged_in_name;

    public Nominee() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///user", "hamza", "iAmrosh2");
        pstmt = null;
    }

    public void show_all_vote_counts(TextArea vote_area) throws SQLException {
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details");
        String vote_count = null;
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            vote_count = Integer.toString(rs.getInt("nominee_vote_count"));
            vote_area.appendText("Nominee ID : " + rs.getString("nominee_username") + " , Nominee Name : " + rs.getString("nominee_name") + " , party name : " + rs.getString("nominee_party_name") + " , Nominee vote count : " + vote_count + "\n");

        }
    }

    public void add_nominee(String name, String username, String age, String password, String party_name, TextField nominee_username, Label nominee_invalid_details, Button nominee_submit_details) throws SQLException {//called by admin via voter
        boolean duplicate = false;
        pstmt = (PreparedStatement) conn.prepareStatement("insert into nominee_details (nominee_username,nominee_password,nominee_vote_count,nominee_name,nominee_age,nominee_party_name) values(?,?,?,?,?,?)");
        PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement("Select * from nominee_details where nominee_username=?");
        pstmt2.setString(1, username);
        ResultSet rss = pstmt2.executeQuery();
        while (rss.next()) {
            duplicate = true;

        }
        if (duplicate) // if username already exixts in database
        {
            nominee_username.clear();
            nominee_invalid_details.setText("Enter different username again please");

        }
        if (duplicate == false) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, 0);
            pstmt.setString(4, name);
            pstmt.setString(5, age);
            pstmt.setString(6, party_name);

            int j = pstmt.executeUpdate();
            if (j > 0) {

                Stage stage = (Stage) nominee_submit_details.getScene().getWindow();
                stage.close();
            } else {
                nominee_invalid_details.setText("Info not saved");

            }
        }

    }

    public void display_all_nominee_id(TextArea nominee_id_area_box) throws SQLException { //called by voter
        int count = 1;
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details");

        ResultSet rs = pstmt.executeQuery();
        String str_i, str_n, str_p;
        while (rs.next()) {
            str_i = rs.getString("nominee_username");
            str_n = rs.getString("nominee_name");
            str_p = rs.getString("nominee_party_name");
            nominee_id_area_box.appendText((Integer.toString(count)) + "." + " " + "Nominee id: " + str_i + "," + " " + "Nominee name: " + str_n + "," + " " + "Nominee Party: " + str_p + "\n");

            count++;

        }
    }

    public boolean check_nominee_details(String n_id, String n_pas) throws SQLException {  //called by admin via voter
        boolean found = false;
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details where nominee_username=? and nominee_password=?");

        pstmt.setString(1, n_id);
        pstmt.setString(2, n_pas);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            found = true;
        }
        if (found) {
            nominee_logged_in_name = n_id;
        }

        return found;
    }

    public void view_vote_count(TextArea nominee_vote_count) throws SQLException {  //called by nominee
        pstmt = (PreparedStatement) conn.prepareStatement("Select * from nominee_details where nominee_username=?");
        pstmt.setString(1, nominee_logged_in_name);
        String vote_count = null;
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            vote_count = Integer.toString(rs.getInt("nominee_vote_count"));
        }
        nominee_vote_count.clear();
        nominee_vote_count.appendText("Your vote count is : " + vote_count);
    }
}
