package Store_view;

import Classes.Category;
import Classes.SubCategory;
import Classes.SuperUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Classes.Store;

import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public  Store s;
    public  Category c;
    public  String user_type;

    @FXML
    ComboBox<Category> comboBox;
    @FXML
    AnchorPane AnchorNewCategory;
    @FXML
    Button AddNewCategory;
    @FXML
    Label LabelStoreName;
    @FXML
    Label LabelAdminName;
    @FXML
    public ListView<Category> ListOfCategories;

    /**
     * Making Observable List for List view
     * @return
     */
    public ObservableList<Category> getData(){
        ObservableList<Category> Categories = FXCollections.observableArrayList();

        System.out.println("All Categories of this store which are being added to ListView are :- ");
        for(Category x : s.getList()){
            System.out.println(x);
            Categories.add(x);
        }

        return Categories;
    }

    /**
     * Setter Function
     */
    public void setStoreName(){
//        LabelStoreName = new Label();
        LabelStoreName.setText(s.getName());
    }

    /**
     * Setter Function
     */
    public void setAdminName(){
//        LabelAdminName = new Label();
        LabelAdminName.setText("Admin Name :- " + s.getAdmin().getName());
    }

    /**
     * Removing buttons for some particular users
     */
    public void removeButton(){
        AnchorNewCategory.getChildren().remove(AddNewCategory);
    }

    /**
     * Constructor
     */
    public Controller(){
        comboBox = new ComboBox<>();
    }

    /**
     * Initializing Controller  Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)

    {

        System.out.println("I am sitting a intializable");
        System.out.println(-10);
//        System.out.println(this.s.getList().size())
//        System.out.println(this.c.getList().size());
        if(this.s!=null){
            setStoreName();
            setAdminName();
            comboBox.setItems(FXCollections.observableList(this.s.getList()));
            ListOfCategories.setItems(getData());
        }
//        comboBox.getItems().removeAll(comboBox.getItems());
//        comboBox.getItems().addAll("Option A", "Option B", "Option C");
//        comboBox.getSelectionModel().select("Option B");
    }


    /**
     * Refresh button event handler
     */
    public void refresh(){
        if(this.s!=null && this.s.getList()!=null) {

            System.out.println("#" + this.s.getList().size());
            for (Category x : s.getList()) {
                System.out.println(x.getName());
            }


            comboBox.setItems(FXCollections.observableList(this.s.getList()));
            ListOfCategories.setItems(getData());
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));}}
        }
    }

    /**
     * Redirecting to another page
     * @param check
     * @throws Exception
     */
    public void forward(String check) throws Exception{

        if(check.equals("Create_category")){
            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            System.out.println(-3);
            myPane = (Pane)loader.load();
            Scene scene = new Scene(myPane);
            stage.setScene(scene);

//        prevStage.close();

            stage.show();
            Create_category.Controller controller1 = (Create_category.Controller)loader.getController();
            controller1.setPrevStage(stage);
            controller1.s=this.s;
            controller1.set_user("store");}

        else{

            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            myPane = (Pane)loader.load();
            Category_view.Controller controller1 = (Category_view.Controller)loader.getController();

            controller1.c = this.c;
            controller1.user_type = this.user_type;
            controller1.refresh();
            if(user_type!=null){
            if(user_type.equals("end_user") || user_type.equals("super_user")){
                controller1.removeButton();
            }}
            controller1.ListOfAllCategories.setItems(controller1.getDataListOfAllCategories());
            controller1.ListofAllSubCategories.setItems(controller1.getDataListOfAllSubCategories());
            controller1.setLabelNoSubCategories();
            controller1.setTitles();
            System.out.println(-3);

            Scene scene = new Scene(myPane);
            stage.setScene(scene);

//        prevStage.close();

            stage.show();

        }


        System.out.println(-2);
    }

    /**
     * Add category event handler
     * @throws Exception
     */
    public void add_category() throws Exception{
        forward("Create_category");
    }

    /**
     * Retrieving Value from combobox
     * @throws Exception
     */
    public void list_view() throws Exception {
        String s = ((Category) (comboBox.getValue())).getName();
        System.out.println(s);
        for(Category c : this.s.getList()){
            if(c.getName().equals(s)){
                this.c = c;

            }
        }
        forward("Category_view");
    }
}
