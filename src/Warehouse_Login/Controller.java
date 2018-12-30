package Warehouse_Login;
import Classes.Warehouse;

import Classes.SuperUser;
import Classes.Warehouse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private TextField t1;
    @FXML private PasswordField password;
    private String ID ;
    String pass;
    static public Warehouse w;

    /**
     * Initializing Controller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
//        form_help = new Form_Helper();
    }

    /**
     * Submit button event handler
     * @param event
     * @throws Exception
     */
    @FXML
    private void Submit(ActionEvent event) throws Exception
    {
        System.out.println("Pressed Submit button");
        ID = t1.getText();
        pass = password.getText();
        System.out.println(ID + " " + pass);

        for (Warehouse w : SuperUser.Warehouses){
            System.out.println(w.get_Admin().getPassword());
            System.out.println(w.get_Admin().getId());

            if(w.get_Admin().getPassword().equals(pass)&& w.get_Admin().getId().equals(ID)){
                this.w = w;
                break;
            }
        }
        System.out.println(this.w);
        if(this.w!=null){
        linking("Warehouse_view");}
        else{
            t1.clear();
            password.clear();}


        }


    @FXML
    private void Back(ActionEvent event) throws Exception
    {
        System.out.println("Inside Back");
        linking("sample");
    }

    Stage prevStage;
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

//        myPane = (Pane)loader.load();
        Warehouse_view.Controller controller1 = (Warehouse_view.Controller)loader.getController();
        controller1.w=this.w;
        controller1.user_type="warehouse";
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();


    }



}
