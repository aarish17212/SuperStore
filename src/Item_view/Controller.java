package Item_view;
import Classes.Category;
import Classes.Item;

import Classes.SubCategory;
import Classes.SuperUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane AnchorPaneHyperLink;
    @FXML
    Hyperlink HyperLinkDelete;
    @FXML
    Hyperlink HyperLinkUpdate;
    @FXML
    Hyperlink HyperLinkOrder;
    @FXML
    AnchorPane AnchorPaneOrder;
    @FXML
    Label QuantityRemaining;
    @FXML
    Label HDKValues;
    @FXML
    Label Item_Name1;
    @FXML
    Label Item_Name2;
    @FXML
    Label ItemCode;
    @FXML
    Hyperlink HyperLinkViewCart;

    public  SubCategory sc;
    public  Item it;
    public  String user_type;

    /**
     * Refresh Button event handler
     */
    public void refresh(){
        this.ChangeQuantityRemaining();
        this.ChangeHDKValues();
        this.ChangeItemName();
    }

    /**
     * Updating remaining quantity
     */
    public void ChangeQuantityRemaining(){
        QuantityRemaining.setText(Integer.toString(it.getQuantity()));
        return;
    }

    /**
     * Updating h,d,k values
     */
    public void ChangeHDKValues(){
        HDKValues.setText("("+it.getH() + ","+it.getD()+","+it.getK()+")");
        return;
    }

    /**
     * Updating Item Name
     */
    public void ChangeItemName(){
        Item_Name1.setText(it.getName());
        Item_Name2.setText("Details about " + it.getName() + " are :-");
    }


    /**
     * Initializing Controller Object
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle){
//        QuantityRemaining.setText("HI");
    }

    /**
     * Removing some particular buttons for some particular users
     */
    public void removeButton(){
        AnchorPaneHyperLink.getChildren().remove(HyperLinkDelete);
        AnchorPaneHyperLink.getChildren().remove(HyperLinkUpdate);
        return;
    }


    /**
     * Removing Hyperlink
     */
    public void removeOrderHyperLink(){
        AnchorPaneOrder.getChildren().remove(HyperLinkOrder);
        return;
    }

    public static Category c;

    /**
     * Deleting an Item
     * @throws Exception
     */
    public void Delete() throws Exception{
        System.out.println("entered");
        System.out.println(this.it.getName());
        for(Item i : this.sc.getList()){
            System.out.println("Name" + i.getName());
            if(i.getName().equals(this.it.getName())){
                ArrayList<Item> a = this.sc.getList();
                a.remove(i);
                this.sc.setList(a);
                SuperUser.serial();
                System.out.println("Done");
                break;
            }
        }
    }

    /**
     * Updating item
     */
    public void Update(){

    }

    /**
     * Order button Event handler
     * @throws Exception
     */
    public void Order() throws Exception {
        forward("Order_Item");
    }

    /**
     * View cart event handler
     * @throws Exception
     */
    public void GoToCart() throws Exception{
        forward("Cart");
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

            if(check.equals("Order_Item")){
                Stage stage = new Stage();
                stage.setTitle("Super Store");
                Pane myPane = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
                System.out.println("Trying to redirect to Order Page");
                myPane = (Pane)loader.load();
                Order_Item.Controller controller1 = (Order_Item.Controller)loader.getController();
                controller1.sc = this.sc;
                controller1.it = this.it;

                Scene scene = new Scene(myPane);
                stage.setScene(scene);
//                prevStage.close();
                stage.show();
            }

        if(check.equals("Cart")){
            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
            System.out.println("Trying to redirect to Cart Page");
            myPane = (Pane)loader.load();
            Cart.Controller controller1 = (Cart.Controller)loader.getController();


            Scene scene = new Scene(myPane);
            stage.setScene(scene);
//                prevStage.close();
            stage.show();
        }


//        if(check.equals("Item_view"))
//        {
//            Stage stage = new Stage();
//            stage.setTitle("Super Store");
//            Pane myPane = null;
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
//            System.out.println(-3);
//            myPane = (Pane)loader.load();
//            Item_view.Controller controller1 = (Item_view.Controller)loader.getController();
//            controller1.it = this.it;
//            controller1.sc = this.sc;
//            controller1.user_type = this.user_type;
//            if(user_type.equals("end_user") || user_type.equals("super_user")){
//                System.out.println("Removing Buttons");
//                controller1.removeButton();
//            }else{
//                System.out.println("Removing Order Item HyperLink");
//                controller1.removeOrderHyperLink();
//            }
//            controller1.ChangeQuantityRemaining();
//            controller1.ChangeHDKValues();
//            controller1.ChangeItemName();
//            controller1.ChangeItemCode();
//            Scene scene = new Scene(myPane);
//            stage.setScene(scene);
//
////        prevStage.close();
//
//            stage.show();
//        }
//
//        if(check.equals("Add_item")){
//            Stage stage = new Stage();
//            stage.setTitle("Super Store");
//            Pane myPane = null;
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/"+check+"/"+check+".fxml"));
//            System.out.println(-3);
//            myPane = (Pane)loader.load();
//            Add_item.Controller controller1 = (Add_item.Controller)loader.getController();
//            controller1.it = this.it;
//            controller1.sc = this.sc;
//            controller1.user_type = this.user_type;
//            controller1.c=this.c;
//            controller1.setprev(stage);
//
//            Scene scene = new Scene(myPane);
//            stage.setScene(scene);
//
////        prevStage.close();
//
//            stage.show();
//        }


    }

//    public void list_view() throws Exception {
//        String s = ((SubCategory) (comboBox.getValue())).getName();
//        System.out.println(s);
//        for(SubCategory c : this.c.getList()){
//            if(c.getName().equals(s)){
//                this.sc = c;
//
//            }
//        }
//        forward("Sub_Category_View");
//    }



}


