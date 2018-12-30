package Warehouse_view;
import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
     public Warehouse w;
    public Category c;
     public String user_type;

    @FXML
    ComboBox<Category> comboBox;

    @FXML
    AnchorPane AnchorNewCategory;
    @FXML
    Button AddNewCategory;

    public Controller(){
        comboBox = new ComboBox<>();
    }
    public ListView<Category> ListOfCategories;
    public void initialize(URL url, ResourceBundle resourceBundle)

    {
        System.out.println(-10);
//        System.out.println(this.s.getList().size())
//        System.out.println(this.c.getList().size());
        if(this.w!=null){
            comboBox.setItems(FXCollections.observableList(this.w.getListOfCategories()));
            ListOfCategories.setItems(getData());
        }
//        comboBox.getItems().removeAll(comboBox.getItems());
//        comboBox.getItems().addAll("Option A", "Option B", "Option C");
//        comboBox.getSelectionModel().select("Option B");
    }



    public ObservableList<Category> getData(){
        ObservableList<Category> Categories = FXCollections.observableArrayList();

        System.out.println("All Categories of this store which are being added to ListView are :- ");
        for(Category x : w.getListOfCategories()){
            System.out.println(x);
            Categories.add(x);
        }

        return Categories;
    }

    /**
     * Removing button for some particular user
     */
    public void removeButton(){
        AnchorNewCategory.getChildren().remove(AddNewCategory);
    }

    /**
     * Refresh button event handler
     */
    public void refresh(){
        if(this.w!=null && this.w.getListOfCategories()!=null) {

            System.out.println("#" + this.w.getListOfCategories().size());
            for (Category x : w.getListOfCategories()) {
                System.out.println(x.getName());
            }


            comboBox.setItems(FXCollections.observableList(this.w.getListOfCategories()));
            ListOfCategories.setItems(getData());
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));}}
        }
    }

    /**
     * Retrieving value from combobox
     * @throws Exception
     */
    public void list_view() throws Exception {
        String s = ((Category) (comboBox.getValue())).getName();
        System.out.println(s);
        for(Category c : this.w.getListOfCategories()){
            if(c.getName().equals(s)){
                this.c = c;
            }
        }
        forward("Category_view");
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
        if(check.equals("Create_Category")){
            Create_category.Controller controller1 = (Create_category.Controller)loader.getController();
            controller1.setPrevStage(stage);
            controller1.set_user("warehouse");
            controller1.w=this.w;

            controller1.user_type = "warehouse";
            System.out.println(controller1.w.getName());
            System.out.println(controller1.user_type);

        }

//        if(check.equals("order_from_warehouse")){
//            Order_from_warehouse.Controller controller1 = (Order_from_warehouse.Controller)loader.getController();
//            controller1.setPrevStage(stage);
////            controller1.set_user("warehouse");
//        }

        if(check.equals("Category_view")){
            Stage stage1 = new Stage();
            stage.setTitle("Super Store");
            Pane myPane1 = null;
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            myPane1 = (Pane)loader1.load();
            Category_view.Controller controller1 = (Category_view.Controller)loader.getController();
            controller1.c = this.c;
            controller1.user_type = this.user_type;
            controller1.refresh();

            if(user_type!=null)
            if(user_type.equals("end_user") || user_type.equals("super_user")){
                controller1.removeButton();
            }
            System.out.println(-3);

            Scene scene = new Scene(myPane1);
            stage1.setScene(scene);

//        prevStage.close();

            stage1.show();
        }

//            controller1.set_u


        System.out.println(-2);
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();}
//    public void order() throws Exception {
//        forward("order_from_warehouse");
//    }
    /**
    Add category button event handler
     */
    public void add() throws Exception{
        forward("Create_Category");
    }


}
