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
public class Admin_optionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField admin_username;
    @FXML

    TextField admin_password;
    @FXML

    Label admin_invalid_credentials;

    @FXML
    public void admin_signin_handler(ActionEvent e) throws SQLException, ClassNotFoundException, IOException {
       Administrator db = Administrator.getInstance();
        String admin_name = admin_username.getText();
        String admin_pass = admin_password.getText();

        boolean result = db.check_admin_details(admin_name, admin_pass);
        if (result) {
            Parent admin_use_cases_screen_parent = FXMLLoader.load(getClass().getResource("admin_use_cases.fxml"));
            Scene admin_use_case_scene = new Scene(admin_use_cases_screen_parent);
            Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            app_stage.hide();

            app_stage.setScene(admin_use_case_scene);

            app_stage.show();
            // System.out.println("Working");
        } else {
            admin_invalid_credentials.setText("Wrong credentials");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
