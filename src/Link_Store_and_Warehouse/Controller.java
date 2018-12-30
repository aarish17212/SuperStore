package Link_Store_and_Warehouse;


import Classes.Store;
import Classes.SuperUser;
import Classes.Warehouse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private TextField t1,t2;
    private String Store_Name , Warehouse_name;
    private Stage prevStage;

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
     * Submit Button event handler
     * @param event
     */
    @FXML
    private void Submit(ActionEvent event)
    {
        System.out.println("Pressed Submit button");
        Store_Name = t1.getText();
        Warehouse_name = t2.getText();
        System.out.println(Store_Name + " " + Warehouse_name);
        Warehouse parent = null;
        for(Warehouse h: SuperUser.Warehouses){
            if(h.getName().equals(Warehouse_name)){
                parent = h;
                break;
            }
        }
        if(parent==null){
            t2.clear();
        }
        else{
            Store child = null;
        for(Store s : SuperUser.Stores){
            if(Store_Name.equals(s.getName())){
                s.setParent_warehouse(parent);
                child = s;
                this.prevStage.close();


            }
        }
        if(child==null){
            t1.clear();
        }
        }




    }

    /**
     * Setter Function
     */
    public void set_prev(Stage s){
        this.prevStage = s;}

    /**
     * getter Function
     * @return
     */
    public Stage get_prev(){
        return this.prevStage;
        }

    /**
     * Back button event handler
      * @param event
     */
    @FXML
    private void Back(ActionEvent event)
    {
        System.out.println("Inside Back");
    }


}
