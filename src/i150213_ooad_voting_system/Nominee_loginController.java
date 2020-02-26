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
public class Nominee_loginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public TextField nominee_signin_id;
    public TextField nominee_signin_pas;
    @FXML
    private Label invalid_nominee_credentials;
    public void nominee_login_handler(ActionEvent e) throws SQLException, ClassNotFoundException, IOException {
        Administrator db = Administrator.getInstance();
        String nominee_id = nominee_signin_id.getText();
        String nominee_pass = nominee_signin_pas.getText();
        // Voter_login_screenController vls = new Voter_login_screenController();
        boolean result = db.check_nominee_details(nominee_id, nominee_pass);
        if (result) {
            //System.out.println("The vote status of this voter is: "+vote_status);
            Parent voter_use_cases_screen_parent = FXMLLoader.load(getClass().getResource("nominee_options.fxml"));
            Scene voter_use_case_scene = new Scene(voter_use_cases_screen_parent);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            app_stage.hide();

            app_stage.setScene(voter_use_case_scene);

            app_stage.show();
            // System.out.println("Working");
        } else {
            invalid_nominee_credentials.setText("Wrong credentials");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
