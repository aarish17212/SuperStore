package Sub_Category_View;
import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    ComboBox<Item> comboBox;
    @FXML
    ComboBox<String> combo;

    @FXML
    AnchorPane AnchorPaneHyperLink;
    @FXML
    AnchorPane AnchorButtonAddItem;
    @FXML
    Hyperlink HyperLinkUpdate , HyperLinkDelete;
    @FXML
    Button ButtonAddItem;
    @FXML
    ListView<SubCategory> ListOfAllSubCategories;
    @FXML
    ListView<Item> ListOfAllItems;
    @FXML
    Label title1;
    @FXML
    Label title2;
    @FXML
    Label NumberOfItems;
    @FXML
    private TextField Search;
    /**
     * Updating labels
     */
    void setLabels(){
        title1.setText(sc.getName());
        title2.setText("List of Items in " + sc.getName());
        NumberOfItems.setText("Number of Items are " + sc.getList().size());
    }

    /**
     * Making observable list for list view
     * @return
     */
    public ObservableList<SubCategory> getDataListOfAllSubCategories(){
        ObservableList<SubCategory> SubCategories = FXCollections.observableArrayList();

        System.out.println("All SubCategories are being added to ListView are :- ");
        for(Store s: SuperUser.Stores) {
            for(Category c: s.getList()) {
                for (SubCategory x : c.getList()) {
                    System.out.println(x);
                    SubCategories.add(x);
                }
            }
        }
        return SubCategories;
    }

    /**
     * Making observable list for list view
     * @return
     */
    public ObservableList<Item> getDataListOfAllItems(){
        ObservableList<Item> Items = FXCollections.observableArrayList();

        System.out.println("All Items of this category are being added to the list view :- ");
        for(Item x : sc.getList()){
            System.out.println(x);
            Items.add(x);
        }

        return Items;
    }

    public void fillListViews(){
        ListOfAllItems.setItems(getDataListOfAllItems());
        ListOfAllSubCategories.setItems(getDataListOfAllSubCategories());
    }

    public  SubCategory sc;
    public Item it;
    public Category c;
    public  String user_type;

    /**
     * Contstructor
     */
    public Controller(){
        comboBox = new ComboBox<>();
    }

    /**
     * Initializing Controller Object
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle)

    {
        System.out.println(-10);
//        System.out.println(this.s.getList().size())
//        System.out.println(this.c.getList().size());
        if(this.sc!=null){
            comboBox.setItems(FXCollections.observableList(this.sc.getList()));
            ListOfAllItems.setItems(getDataListOfAllItems());}
//        comboBox.getItems().removeAll(comboBox.getItems());
//        comboBox.getItems().addAll("Option A", "Option B", "Option C");
//        comboBox.getSelectionModel().select("Option B");
    }


    /**
     * Refresh button Event handler
     */
    public void refresh(){
        if(this.sc!=null && this.sc.getList()!=null) {

            System.out.println("#" + this.sc.getList().size());
            for (Item x : sc.getList()) {
                System.out.println("name" + x.getName());
            }


            comboBox.setItems(FXCollections.observableList(this.sc.getList()));
            ListOfAllItems.setItems(getDataListOfAllItems());
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));}}
        }
    }

    /**
     * Removing buttons for some particular users
     */
    public void removeButton(){
        AnchorButtonAddItem.getChildren().remove(ButtonAddItem);
        AnchorPaneHyperLink.getChildren().remove(HyperLinkDelete);
        AnchorPaneHyperLink.getChildren().remove(HyperLinkUpdate);
    }

    /**
     * Delete button event handler
     */
    public void Delete(){
            if(this.user_type.equals("store")){
                for (SubCategory s: c.getList()){
                    if(s.getName().equals(sc)){

                        ArrayList<SubCategory> a = c.getList();
                        a.remove(sc);
                        c.setList(a);
                        SuperUser.serial();
//                SuperUser.AllCategories.remove(c);
                        System.out.println("Done");

                        break;
                    }
                }
            }

            else{
                for (SubCategory s: c.getList()){
                    if(s.getName().equals(sc)){

                        ArrayList<SubCategory> a = c.getList();
                        a.remove(sc);
                        c.setList(a);
                        SuperUser.serial();
//                SuperUser.AllCategories.remove(c);
                        System.out.println("Done");

                        break;
                    }
                }

            }
    }


        public void Update(){

    }

    /**
     * Add subcategory button event handler
     * @throws Exception
     */
    public void add_item() throws Exception{
        forward("Add_item");
    }

    /**
     * Redirecting to another page
     * @param check
     * @throws Exception
     */
    public void forward(String check) throws Exception{

//        if(check.equals("Create_category")){
//            Stage stage = new Stage();
//            stage.setTitle("Super Store");
//            Pane myPane = null;
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
//            System.out.println(-3);
//            myPane = (Pane)loader.load();
//            Scene scene = new Scene(myPane);
//            stage.setScene(scene);
//
////        prevStage.close();
//
//            stage.show();
//            Create_category.Controller controller1 = (Create_category.Controller)loader.getController();
//            controller1.setPrevStage(stage);
//            controller1.c=this.c;
//            controller1.set_add_type("sub_category");}

        if(check.equals("Item_view"))
        {
            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            System.out.println(-3);
            myPane = (Pane)loader.load();
            Item_view.Controller controller1 = (Item_view.Controller)loader.getController();
            controller1.it = this.it;
            controller1.sc = this.sc;
            controller1.user_type = this.user_type;
            if(user_type!=null)
            if(user_type.equals("end_user") || user_type.equals("super_user")){
                System.out.println("Removing Buttons");
                controller1.removeButton();
            }if(user_type!=null && user_type.equals("end_user")==false){
                System.out.println("Removing Order Item HyperLink");
                controller1.removeOrderHyperLink();
            }
            controller1.ChangeQuantityRemaining();
            controller1.ChangeHDKValues();
            controller1.ChangeItemName();

            Scene scene = new Scene(myPane);
            stage.setScene(scene);

//        prevStage.close();

            stage.show();
        }

        if(check.equals("Add_item")){
            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            System.out.println(-3);
            myPane = (Pane)loader.load();
            Add_item.Controller controller1 = (Add_item.Controller)loader.getController();
            controller1.it = this.it;
            controller1.sc = this.sc;
            controller1.user_type = this.user_type;
            controller1.c=this.c;
            controller1.setprev(stage);

            Scene scene = new Scene(myPane);
            stage.setScene(scene);

//        prevStage.close();

            stage.show();
        }




    }

    /**
     * Retrieving value from combobox
     * @throws Exception
     */
    public void list_view() throws Exception{
        String s = ((Item) (comboBox.getValue())).getName();
        System.out.println(s);
        for(Item c : this.sc.getList()){
            if(c.getName().equals(s)){
                this.it = c;

            }
        }
        forward("Item_view");
    }

    /**
     * Sort button event handler
     */
    public void sort(){

        ListOfAllItems.setItems(getDataListOfAllItems().sorted());
        comboBox.setItems(FXCollections.observableList(this.sc.getList()).sorted());

    }

//    public void search(){
//
//
//            String value = this.combo.getEditor().getText();
//            System.out.println(value);
//
//            if (value!=null) {
//
//                System.out.println("check");
//
//                List<String> list = new ArrayList();
//
//                for (int i=0; i<this.sc.getList().size();i++) {
//
//                    list.add(this.sc.getList().get(i).getName());
//
//                    List <String> listClone = new ArrayList<String>();
//
//                    for (String string : list) {
//
//                        if(string.matches("(?i)(" + value + ").*")){
//
//                            listClone.add(string);
//
//                        }
//
//                        combo.setItems(FXCollections.observableList(listClone));
//
//                    }
//
//                }
//
//
//    }}
}


