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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class Cast_vote_screenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Label invalid_nominee_id;
    public TextArea nominees_for_vote;
    public TextField nominee_id_field;
    @FXML
    public void submit_vote_handler(ActionEvent e) throws SQLException, ClassNotFoundException
    {
        Voter dc = new Voter();
         dc.cast_vote(invalid_nominee_id,nominee_id_field.getText());

    }
    
    public void show_nominees_handler(ActionEvent e) throws SQLException, ClassNotFoundException
    {
        Voter dc = new Voter();
        dc.display_all_nominee_id(nominees_for_vote);
       
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
