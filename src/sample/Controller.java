package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import Super_Login.*;

public class Controller implements Initializable {
    @FXML private RadioButton f1;
    @FXML private RadioButton f2;


    /**
     * Initializing Controleller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    Stage prevStage;

    /**
     * Setter Function
     * @param stage
     */
    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    /**
     * Redirecting to another page
     * @param check
     * @throws Exception
     */
    public void linking(String check) throws Exception{
        Stage stage = new Stage();
        stage.setTitle("Super Store");
        Pane myPane = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
        myPane = (Pane)loader.load();
        if(check.equals("Super_Login")){
            System.out.println(-1);
        Super_Login.Controller controller1 = (Super_Login.Controller)loader.getController();
        controller1.setPrevStage(stage);}
        if(check.equals("Warehouse_Login")){
            Warehouse_Login.Controller controller1 = (Warehouse_Login.Controller)loader.getController();
            controller1.setPrevStage(stage);
        }
        if(check.equals("Store_Login")){
            Store_Login.Controller controller1 = (Store_Login.Controller)loader.getController();
            controller1.setPrevStage(stage);
        }
        if(check.equals("End_User")){
           End_User.Controller controller1 = (End_User.Controller)loader.getController();
           controller1.AddToComboBox();
           controller1.ChangeStoreCount();
//           controller1.refresh();
//            controller1.setPrevStage(stage);
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();
    }
    @FXML
    private void test(ActionEvent event)
    {
        System.out.println("lollolol");
    }

    /**
     * Event handler for Login as Guest user
     * @param event
     * @throws Exception
     */
    @FXML
    private void Login_Guest(ActionEvent event) throws Exception {System.out.println("Guest");
        linking("End_User");}

    /**
     * Event handler for warehouse login
      * @param event
     * @throws Exception
     */
    @FXML
    private void WarehouseLogin(ActionEvent event) throws Exception {System.out.println("WA");
        linking("Warehouse_Login");}

    /**
     * Event handler for store login
      * @param event
     * @throws Exception
     */
    @FXML
    private void StoreLogin(ActionEvent event) throws Exception {System.out.println("SL");linking("Store_Login");}
//       linking("Store_Login");}

    /**
     * Event Handler for Super User Login
     * @param event
     * @throws Exception
     */
    @FXML
    private void SuperUserLogin(ActionEvent event) throws Exception{System.out.println("SUL");linking("Super_Login");}



}
