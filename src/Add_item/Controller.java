
package Add_item;
import Classes.Category;
import Classes.Item;
import Classes.SubCategory;
import Classes.SuperUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
    @FXML private TextField t1;
    @FXML private TextField t2;
    @FXML private TextField t3;
    @FXML private TextField t4;
    @FXML private TextField t5;
    @FXML private TextField t6;




    @FXML
    ComboBox<Item> comboBox;

    @FXML
    AnchorPane AnchorPaneHyperLink;
    @FXML
    AnchorPane AnchorButtonAddItem;
    @FXML
    Hyperlink HyperLinkUpdate , HyperLinkDelete;
    @FXML
    Button ButtonAddItem;





    public static SubCategory sc;
    public static Item it;
    public static Category c;
    public static String user_type;
    private Stage prevStage;

    public void setprev(Stage stage){
        this.prevStage=stage;
    }

//    public void initialize(URL url, ResourceBundle resourceBundle)
//
//    {
//        System.out.println(-10);
////        System.out.println(this.s.getList().size())
////        System.out.println(this.c.getList().size());
//        if(this.c!=null){
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));}
////        comboBox.getItems().removeAll(comboBox.getItems());
////        comboBox.getItems().addAll("Option A", "Option B", "Option C");
////        comboBox.getSelectionModel().select("Option B");
//    }
//
//
//
//    public void refresh(){
//        if(this.c!=null && this.c.getList()!=null) {
//
//            System.out.println("#" + this.c.getList().size());
//            for (SubCategory x : c.getList()) {
//                System.out.println(x.getName());
//            }
//
//
//            comboBox.setItems(FXCollections.observableList(this.c.getList()));
////            comboBox.setItems(FXCollections.observableList(this.c.getList()));}}
//        }
//    }

    /**
     * Submit Button Event Handler
     * @throws Exception
     */
    public void close() throws Exception{
        System.out.println(t1.getText());
        System.out.println(t2.getText());
        System.out.println(t3.getText());
        System.out.println(t4.getText());
        System.out.println(t5.getText());
        System.out.println(t6.getText());
        boolean already_present = false;


        Item i = new Item(t6.getText(),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()),Integer.parseInt(t4.getText()),Integer.parseInt(t1.getText()));
        for(Item it : this.sc.getList()){
            if(it.getName().equals(i.getName())){
                System.out.println("Item already present");
                already_present=true;
                it.setQuantity(it.getQuantity()+i.getQuantity());
            }

        }
        if(already_present==false){
        ArrayList<Item> a = sc.getList();
        a.add(i);
        sc.setList(a);
        SuperUser.serial();
        prevStage.close();
        forward("Sub_Category_View");}

    }

    /**
     * Cancel Button Event Handler
     * @throws Exception
     */
    public void close2() throws Exception{
        prevStage.close();
        forward("Sub_Category_View");
    }

    /**
     * Function for removing some particular buttons for some particular users
     */
    public void removeButton(){
        AnchorButtonAddItem.getChildren().remove(ButtonAddItem);
        AnchorPaneHyperLink.getChildren().remove(HyperLinkDelete);
        AnchorPaneHyperLink.getChildren().remove(HyperLinkUpdate);
    }

    /**
     * Delete HyperLink Event Handler
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

        }}


    public void Update(){

    }

    /**
     * Redirectiong to another page on clicking a button
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

        if(check.equals("Sub_Category_View"))
        {

            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            System.out.println(-3);
            myPane = (Pane)loader.load();
            Sub_Category_View.Controller controller1 = (Sub_Category_View.Controller)loader.getController();
            controller1.it = this.it;
            controller1.sc = this.sc;
            controller1.user_type = this.user_type;
            controller1.c = this.c;
            Scene scene = new Scene(myPane);
            stage.setScene(scene);

            controller1.refresh();
//        prevStage.close();

            stage.show();

        }


    }




}

