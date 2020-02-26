/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i150213_ooad_voting_system;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class Add_voterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField voter_name;
    @FXML
    TextField voter_age;
    @FXML
    public TextField voter_username;
    @FXML
    TextField voter_password;
    @FXML
    public Label invalid_detail;
    public Button submit_details;
    @FXML
    public void voter_details_handler(ActionEvent e) throws SQLException, ClassNotFoundException {
        Administrator db = Administrator.getInstance();
        db.add_voter(voter_name.getText(), voter_username.getText(), Integer.parseInt(voter_age.getText()), voter_password.getText(),voter_username,invalid_detail,submit_details);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
