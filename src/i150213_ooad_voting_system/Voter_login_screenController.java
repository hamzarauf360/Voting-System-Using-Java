/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i150213_ooad_voting_system;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class Voter_login_screenController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    TextField voter_username;
    @FXML

    TextField voter_password;
    @FXML

    Label voter_invalid_credentials;
    @FXML
    public void voter_sign_in_handler(ActionEvent e) throws SQLException, ClassNotFoundException, IOException
    {
         Administrator db = Administrator.getInstance();
        String voter_name = voter_username.getText();
        String voter_pass = voter_password.getText();
       // Voter_login_screenController vls = new Voter_login_screenController();
        boolean result = db.check_voter_details(voter_name, voter_pass);
        if (result) {
            //System.out.println("The vote status of this voter is: "+vote_status);
            Parent voter_use_cases_screen_parent = FXMLLoader.load(getClass().getResource("Voter_options.fxml"));
            Scene voter_use_case_scene = new Scene(voter_use_cases_screen_parent);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            app_stage.hide();

            app_stage.setScene(voter_use_case_scene);

            app_stage.show();
            // System.out.println("Working");
        } else {
            voter_invalid_credentials.setText("Wrong credentials");
        }

    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
