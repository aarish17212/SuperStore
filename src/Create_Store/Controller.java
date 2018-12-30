package Create_Store;

import Classes.SuperUser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Classes.Store;
import Classes.Store_Admin;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import Classes.Store;

public class Controller implements Initializable {
    @FXML private TextField t1,t2;
    private String Name , Admin_Name;

    /**
     * Intializing controller Object
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
        Admin_Name = t2.getText();
        System.out.println(Name + " " + Admin_Name);
        Store_Admin a = new Store_Admin("name","password");
        boolean found = false;
        for(Store_Admin x : SuperUser.StoreAdmins){
            if(x.getName().equals(Admin_Name)){
                a = x;
                found = true;
                break;
            }
        }
        if(!found){
            t1.clear();
            t2.clear();
        }else{
            Store s = new Store(a,Name);
            System.out.println(s.getName());
            SuperUser.Stores.add(s);
        }
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
