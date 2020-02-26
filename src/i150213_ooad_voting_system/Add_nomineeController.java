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
public class Add_nomineeController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    TextField nominee_name;
     @FXML
    TextField nominee_party;

    @FXML
    TextField nominee_age;
    @FXML
    public TextField nominee_username;
    @FXML
    TextField nominee_password;
    @FXML
    public Label nominee_invalid_details;
    @FXML
    public Button nominee_submit_details;
    @FXML
    public void nominee_details_handler(ActionEvent e) throws SQLException, ClassNotFoundException {
        Administrator db =Administrator.getInstance();
        db.add_nominee(nominee_name.getText(), nominee_username.getText(), nominee_age.getText(), nominee_password.getText(),nominee_party.getText(),nominee_username,nominee_invalid_details,nominee_submit_details);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
