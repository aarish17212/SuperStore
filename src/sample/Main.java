package sample;

import Classes.SuperUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {

    /**
     * Setting initial stage
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Pane myPane = (Pane)loader.load();

        Controller controller = (Controller) loader.getController();
//        Controller controller = new Controller();
        controller.setPrevStage(primaryStage);

        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();

        SuperUser.deserial();

    }


    /**
     * Main method of the project
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
