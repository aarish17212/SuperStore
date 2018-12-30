package Store_Login;


import Classes.SuperUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import Classes.Store;
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
    String ID , pass;
    Stage prevStage;
    static Store s;
    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    /**
     * Intializing Controller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

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
//        sample.Controller controller1 = (sample.Controller)loader.getController();
//        controller1.setPrevStage(stage);
//        myPane = (Pane)loader.load();
        Store_view.Controller controller1 = (Store_view.Controller)loader.getController();
//        controller1.setPrevStage(stage);
        controller1.s = this.s;
        controller1.user_type = "store";
        controller1.refresh();
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();
    }

    /**
     * Submit Button Event Handler
     * @param event
     * @throws Exception
     */
    @FXML
    private void Submit(ActionEvent event) throws Exception
    {

        ID = t1.getText();
        pass = password.getText();
        for(Store s: SuperUser.Stores){
            System.out.println(s.getAdmin().getId());
            System.out.println(s.getAdmin().getPassword());
            if(s.getAdmin().getId().equals(ID)){
              this.s = s;
              System.out.println(this.s.getAdmin().getId());
                System.out.println(this.s.getAdmin().getPassword());
              break;
            }
        }

        if(this.s!=null){
        System.out.println(ID + " " + pass);
        linking("Store_view");}
        else{
            t1.clear();
            password.clear();
        }
    }


    /**
     * Back Button event handler
     * @param event
     * @throws Exception
     */
    @FXML
    private void Back(ActionEvent event) throws Exception
    {
        System.out.println("Inside Back");
        linking("sample");
    }


}
