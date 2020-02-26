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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class All_vote_countsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextArea vote_area;
    public void show_count_handler(ActionEvent e) throws SQLException, ClassNotFoundException
    {
        Administrator db = Administrator.getInstance();
        db.show_all_vote_counts(vote_area);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
