package Category_view;

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
    ComboBox<SubCategory> comboBox;
    public Category c;
    public SubCategory sc;
    public  String user_type;
    @FXML
    public Button ButtonNewSubCategory;
    @FXML
    public AnchorPane AnchorButtonNewSubCategory;
    @FXML
    public AnchorPane AnchorUpdateDelete;
    @FXML
    public Hyperlink UpdateHyperLink;
    @FXML
    public Hyperlink DeleteHyperLink;
    @FXML
    public ListView<Category> ListOfAllCategories;
    @FXML
    public ListView<SubCategory> ListofAllSubCategories;
    @FXML
    public Label LabelNoSubCategories;
    @FXML
    public Label title1;
    @FXML
    public Label title2;

    public void setTitles(){
        title1.setText(c.getName());
        title2.setText("List Of Sub-Categories of " + c.getName() + " are ");
    }

    public void setLabelNoSubCategories(){
        LabelNoSubCategories.setText("Number of Sub Categories are " + c.getList().size());
        return;
    }

    /**
     * Observable List for list view
     * @return
     */
    public ObservableList<Category> getDataListOfAllCategories(){
        ObservableList<Category> Categories = FXCollections.observableArrayList();

        System.out.println("All Categories of this store which are being added to ListView are :- ");
        for(Store s : SuperUser.Stores) {
            for (Category x : s.getList()) {
                System.out.println(x);
                Categories.add(x);
            }
        }
        return Categories;
    }

    /**
     * Generating Observable List for List view
     * @return
     */
    public ObservableList<SubCategory> getDataListOfAllSubCategories(){
        ObservableList<SubCategory> SubCategories = FXCollections.observableArrayList();

        System.out.println("All Categories of this store which are being added to ListView are :- ");
        for(SubCategory x : c.getList()){
            System.out.println(x);
            SubCategories.add(x);
        }

        return SubCategories;
    }

    /**
     * Removing some particular buttons for some particular users
     */
    public void removeButton(){
        AnchorButtonNewSubCategory.getChildren().remove(ButtonNewSubCategory);
        AnchorUpdateDelete.getChildren().remove(UpdateHyperLink);
        AnchorUpdateDelete.getChildren().remove(DeleteHyperLink);
    }

    /**
     * Constructor
     */
    public Controller(){
        comboBox = new ComboBox<>();
    }


    /**
     * Initializing controller Object
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)

    {
        System.out.println(-10);
//        System.out.println(this.s.getList().size())
//        System.out.println(this.c.getList().size());
        if(this.c!=null){
            comboBox.setItems(FXCollections.observableList(this.c.getList()));
            ListofAllSubCategories.setItems(getDataListOfAllSubCategories());}
//        comboBox.getItems().removeAll(comboBox.getItems());
//        comboBox.getItems().addAll("Option A", "Option B", "Option C");
//        comboBox.getSelectionModel().select("Option B");
    }


    /**
     * Refresh button event handler
     */
    public void refresh(){
        if(this.c!=null && this.c.getList()!=null) {

            System.out.println("#" + this.c.getList().size());
            for (SubCategory x : c.getList()) {
                System.out.println(x.getName());
            }


            comboBox.setItems(FXCollections.observableList(this.c.getList()));
            ListofAllSubCategories.setItems(getDataListOfAllSubCategories());
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));}}
        }
    }


    /**
     * Delete button Event handler
     */
    public void Delete() throws Exception{
        if(this.user_type.equals("store")){
        for (Store s: SuperUser.Stores){
            if(s.getName().equals(c.Store_Name)){
                ArrayList<Category> a = s.getList();
                a.remove(c);
                s.setList(a);
                SuperUser.serial();
//                SuperUser.AllCategories.remove(c);
                System.out.println("Done");

                break;
            }
        }
    }

    else{
            for (Warehouse s: SuperUser.Warehouses){
                if(s.getName().equals(c.Store_Name)){
                    ArrayList<Category> a = s.getListOfCategories();
                    a.remove(c);
                    s.setListOfCategories(a);
                    SuperUser.serial();
//                SuperUser.AllCategories.remove(c);
                    System.out.println("Done");

                    break;
                }
            }

    }}

    /**
     * Update Button Event Handler
     */
    public void Update(){

    }

    /**
     * Add new SubCategory button event handler
     * @throws Exception
     */
    public void add_new() throws Exception{
        System.out.println("yes");
        forward("Create_category");

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
            Create_category.Controller controller1 = (Create_category.Controller)loader.getController();
            controller1.setPrevStage(stage);
            controller1.c=this.c;
            controller1.user_type = this.user_type;
            controller1.add_type = "sub-category";
            System.out.println("checkkkk" + controller1.c.getName());
            System.out.println(controller1.user_type);
            Scene scene = new Scene(myPane);
            stage.setScene(scene);

//        prevStage.close();

            stage.show();

        }

            if(check.equals("Sub_Category_View"))
            {
                System.out.println("view subcategory");
                Stage stage = new Stage();
                stage.setTitle("Super Store");
                Pane myPane = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
                myPane = (Pane)loader.load();
                Sub_Category_View.Controller controller1 = (Sub_Category_View.Controller)loader.getController();
                controller1.sc = this.sc;
                controller1.c = this.c;
                controller1.user_type = this.user_type;
                controller1.fillListViews();
                if(user_type!=null)
                if(user_type.equals("end_user") || user_type.equals("super_user")){
                    controller1.removeButton();
                }
                System.out.println(-3);

                Scene scene = new Scene(myPane);
                stage.setScene(scene);

                controller1.refresh();
//        prevStage.close();

                stage.show();
            }
    }

    /**
     * Reading the value of combobox
     * @throws Exception
     */
    public void list_view() throws Exception {
        String s = ((SubCategory) (comboBox.getValue())).getName();
        System.out.println(s);
        for(SubCategory c : this.c.getList()){
            if(c.getName().equals(s)){
                this.sc = c;

            }
        }
        forward("Sub_Category_View");
    }


}


