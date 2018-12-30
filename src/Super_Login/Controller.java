package Super_Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    Stage prevStage;
    @FXML private TextField t1;
    @FXML private PasswordField password;
    String ID , pass;

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
        sample.Controller controller1 = (sample.Controller)loader.getController();
        controller1.setPrevStage(stage);
//        myPane = (Pane)loader.load();

        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();
    }

    /**
     * Redirecting to another page
     * @param check
     * @throws Exception
     */
    public void forward(String check) throws Exception{
        Stage stage = new Stage();
        stage.setTitle("Super Store");
        Pane myPane = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
        System.out.println(-3);
        myPane = (Pane)loader.load();


        System.out.println(-2);
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();
    }

    /**
     * Submit Button
     * @param event
     * @throws Exception
     */
    @FXML
    private void Submit(ActionEvent event) throws Exception
    {
        System.out.println("Pressed Submit Button");
        ID = t1.getText();
        pass = password.getText();
        System.out.println(ID + " " + pass);
        if(ID.equals("unique") && pass.equals("superuser")){
            forward("Super_User_Page");
        }
        else{
            t1.clear();
            password.clear();

        }

    }

//    @FXML
//    private void Back(ActionEvent event) throws Exception
//    {
//        System.out.println("Inside Back");
//        linking("sample");
//    }
}
