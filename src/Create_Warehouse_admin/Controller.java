package Create_Warehouse_admin;




import Classes.SuperUser;
import Classes.Warehouse_Admin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private TextField t1;
    @FXML private PasswordField password;
    private String Name , pass;

    /**
     * Initializing Controller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    /**
     * Submit Button Event Handler
     * @param event
     */
    @FXML
    private void Submit(ActionEvent event)
    {
        System.out.println("Pressed Submit button");
        Name = t1.getText();
        pass = password.getText();
        System.out.println(Name + " " + pass);
        Warehouse_Admin admin = new Warehouse_Admin(Name,pass);
        SuperUser.WarehouseAdmins.add(admin);
        SuperUser.DebugData();
        SuperUser.serial();
    }

    /**
     * Back Button Event Handler
     * @param event
     */
    @FXML
    private void Back(ActionEvent event)
    {
        System.out.println("Inside Back");
    }


}
