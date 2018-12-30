package End_User;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ComboBox<Category> ComboBoxCategory;
    @FXML
    public ComboBox<SubCategory> ComboBoxSubCategory;
    @FXML
    public ComboBox<Store>  ComboBoxStore;
    @FXML
    public Label StoreCount;
    private Store selected;

    @FXML
    public ListView ListOfAllStores;

    /**
     * Observable List for Viewing Stores
     * @return
     */
    private ObservableList<Store> getData(){
        ObservableList<Store> Stores = FXCollections.observableArrayList();

        System.out.println("All Stores which are being added to ListView are :- ");
        for(Store x : SuperUser.Stores){
            System.out.println(x);
            Stores.add(x);
        }

        return Stores;
    }

//    public

    /**
     * Setter Function
     * @param s
     */
    public void set_selected(Store s){
        this.selected = s;
    }

    /**
     * Getter Function
     * @return
     */
    public Store get_selected(){
        return this.selected;
    }

    /**
     * Retrieivng Name of category
     */
    public void Category(){
        Category c = ComboBoxCategory.getValue();
        String s = c.getName();

    }


    /**
     * Retrieivng Name of subcategory
     */
    public void SubCategory(){
        SubCategory c = ComboBoxSubCategory.getValue();
        String s = c.getName();
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
        Store_view.Controller controller1 = (Store_view.Controller)loader.getController();
        System.out.println(this.get_selected()+"\n\n\n\n\n");
        controller1.s  = this.get_selected();
        controller1.user_type = "end_user";
        controller1.setAdminName();
        controller1.setStoreName();
        controller1.ListOfCategories.setItems(controller1.getData());
        controller1.removeButton();
        controller1.refresh();
        Scene scene = new Scene(myPane);
        stage.setScene(scene);

//        prevStage.close();

        stage.show();

    }

    /**
     * Retreiving combobox value to check selected store
     * @throws Exception
     */
    public void Store() throws Exception{
        Store c = ComboBoxStore.getValue();
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
            linking("Store_view");
        }

    }

    /**
     * Updating the store count label
     */
    public void ChangeStoreCount(){

//        StoreCount.text
        StoreCount.setText("Number of Stores are " + SuperUser.Stores.size());
    }

    /**
     * Adding items to combobox
     */
    public void AddToComboBox(){
        System.out.println("Inside End User Initialize Controller");
        ArrayList<Category> AllCategories = new ArrayList<>();
        ArrayList<SubCategory> AllSubCategories = new ArrayList<>();
        for(Store x:SuperUser.Stores){
            for(Category y : x.getList()){
                AllCategories.add(y);
                for(SubCategory z : y.getList()){
                    AllSubCategories.add(z);
                }
            }
        }

        ComboBoxCategory.setItems(FXCollections.observableList(AllCategories));
        ComboBoxSubCategory.setItems(FXCollections.observableList(AllSubCategories));
        ComboBoxStore.setItems(FXCollections.observableList(SuperUser.Stores));

        System.out.println("All Stores to be put in combo box are");
        for(Store x : SuperUser.Stores){
            System.out.println(x);
        }

        System.out.println("All Categories to be put in combo box are");
        for(Category x : AllCategories){
            System.out.println(x);
        }

    }

    /**
     * Constructor
     */
    public Controller(){
        ComboBoxCategory = new ComboBox<>();
        ComboBoxSubCategory = new ComboBox<>();
        ComboBoxStore = new ComboBox<>();
//        initialize();



    }

    /**
     * Intializing Controller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ListOfAllStores.setItems(getData());
        AddToComboBox();
        ChangeStoreCount();
    }
}
