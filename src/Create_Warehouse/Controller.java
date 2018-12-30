package Create_Warehouse;

import java.util.Random;
import Classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private TextField t1,t2;
    private String Name , Admin_Name;
    Random r = new Random();

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
        Admin_Name = t2.getText();
        System.out.println(Name + " " + Admin_Name);
        Warehouse_Admin a = new Warehouse_Admin("name","password");
        boolean found = false;
        for(Warehouse_Admin x : SuperUser.WarehouseAdmins){
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
            Warehouse s = new Warehouse(a,Name);
            SuperUser.Warehouses.add(s);
            int index = r.nextInt(3);
            s.setCity(SuperUser.cities.get(index));
            if(s.getCity().equals("Delhi")){
                SuperUser.Delhi.add(s);
            }
            if(s.getCity().equals("Mumbai")){
                SuperUser.Mumbai.add(s);
            }
            if(s.getCity().equals("Kolkata")){
                SuperUser.Kolkata.add(s);
            }



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
