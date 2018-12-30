package Super_User_Page;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ComboBox<Warehouse> ComboBoxwarehouse;
    @FXML
    public ComboBox<Store> ComboBoxstore;
    @FXML
    public ComboBox<User>  ComboBoxadmins;
    private Store selected;

    /**
     * getter function
     * @return
     */
    public Warehouse getSelect() {
        return select;
    }

    /**
     * setter fucntion
     * @param select
     */
    public void setSelect(Warehouse select) {
        this.select = select;
    }

    private Warehouse select;
    public ListView ListOfAlladmins;
    public void AddToComboBox(){
        System.out.println("Inside End User Initialize Controller");
        ArrayList<Store> AllCategories = new ArrayList<>();
        ArrayList<Warehouse> AllSubCategories = new ArrayList<>();
        ArrayList<User> admins = new ArrayList<>();
        for(Store x:SuperUser.Stores){
            AllCategories.add(x);
            admins.add(x.getAdmin());
        }

        for(Warehouse x: SuperUser.Warehouses){
            AllSubCategories.add(x);
            admins.add(x.get_Admin());
        }


        ComboBoxwarehouse.setItems(FXCollections.observableList(SuperUser.Warehouses));
        ComboBoxstore.setItems(FXCollections.observableList(SuperUser.Stores));
        ComboBoxadmins.setItems(FXCollections.observableList(admins));}
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
//        form_help = new Form_Helper();

        ListOfAlladmins.setItems(getData());
        AddToComboBox();
    }

    private ObservableList<User> getData(){
        ObservableList<User> Admins = FXCollections.observableArrayList();

        System.out.println("All Stores which are being added to ListView are :- ");
        for(Store x : SuperUser.Stores){
            System.out.println(x);
            Admins.add(x.getAdmin());
        }
        for(Warehouse x : SuperUser.Warehouses){
            System.out.println(x);
            Admins.add(x.getAdmin());
        }

        return Admins;
    }

    public void set_selected(Store s){
        this.selected = s;
    }
    public Store get_selected(){
        return this.selected;
    }

    /**
     * Viewing a store
     * @throws Exception
     */
    public void store_viewing() throws Exception{
        Store c = ComboBoxstore.getValue();
        String s = c.getName();
        System.out.println(s);
        for(Store s1 : SuperUser.Stores){
            System.out.println("name" + s1.getName());
            if(s1.getName().equals(s)){

                this.set_selected(s1);
                System.out.println("match");
                break;
            }
        }
        if(this.get_selected()!=null){
            forward("Store_view");
        }
    }

    /**
     * Viewing a warehouse
     * @throws Exception
     */
    public void warehouse_viewing() throws Exception{
        Warehouse c = ComboBoxwarehouse.getValue();
        String s = c.getName();
        System.out.println(s);
        for(Warehouse s1 : SuperUser.Warehouses){
            System.out.println("name" + s1.getName());
            if(s1.getName().equals(s)){

                this.setSelect(s1);
                System.out.println("match");
                break;
            }
        }
        if(this.getSelect()!=null){
            forward("Warehouse_view");
        }
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
    public void forward(String check) throws Exception{
        Stage stage = new Stage();
        stage.setTitle("Super Store");
        Pane myPane = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
        myPane = (Pane)loader.load();
        if(check.equals("Store_view")){
            Store_view.Controller controller1 = (Store_view.Controller)loader.getController();
            controller1.s  = this.get_selected();
            controller1.user_type = "super_user";
            controller1.setAdminName();
            controller1.setStoreName();
            controller1.ListOfCategories.setItems(controller1.getData());
            controller1.removeButton();
            controller1.refresh();
        }

        if(check.equals("Warehouse_view")){
            Warehouse_view.Controller controller1 = (Warehouse_view.Controller)loader.getController();
            controller1.w  = this.getSelect();
            controller1.user_type = "super_user";
            controller1.ListOfCategories.setItems(controller1.getData());
            controller1.removeButton();
            controller1.refresh();
        }

        if(check.equals("Link_Store_and_Warehouse")){
            Link_Store_and_Warehouse.Controller controller1 = (Link_Store_and_Warehouse.Controller)loader.getController();
            controller1.set_prev(stage);
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();
    }

    /**
     * Event handler
     * @throws Exception
     */
    public  void create_wa() throws Exception{
        forward("Create_Warehouse_Admin");
    }

    /**
     * Event handler
     * @throws Exception
     */
    public  void create_sa() throws Exception{
        forward("Create_Store_Admin");
    }

    /**
     * Event handler
     * @throws Exception
     */
    public  void create_s() throws Exception{
        forward("Create_Store");
    }

    /**
     * Event handler
     * @throws Exception
     */
    public  void create_w() throws Exception{
        forward("Create_Warehouse");
    }

    /**
     * Event handler
     * @throws Exception
     */
    public  void link() throws Exception{
        forward("Link_Store_and_Warehouse");
    }
}
