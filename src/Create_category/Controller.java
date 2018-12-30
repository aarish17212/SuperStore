package Create_category;

import Classes.*;

import java.util.*;

import Store_view.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
   public Warehouse w;
    public Store s;
    public Category c;

    public String user_type;
    public String add_type;
    @FXML


    private TextField t1;

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
//        sample.Controller controller1 = (sample.Controller)loader.getController();
//        controller1.setPrevStage(stage);
//        myPane = (Pane)loader.load();
//        Super_Login.Controller controller1 = new Super_Login.Controller();
//        controller1.setPrevStage(stage);
        if(check.equals("Store_view")){
        Store_view.Controller controller1 = (Store_view.Controller)loader.getController();
//        controller1.setPrevStage(stage);
        controller1.s = this.s;
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        controller1.refresh();
        }

        if(check.equals("Category_view")){
            Category_view.Controller controller1 = (Category_view.Controller)loader.getController();
            controller1.c = this.c;
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            controller1.refresh();

        }

        if(check.equals("Warehouse_view")){
            Warehouse_view.Controller controller1 = (Warehouse_view.Controller)loader.getController();
//        controller1.setPrevStage(stage);
            controller1.w = this.w;
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            controller1.refresh();
        }

//        prevStage.close();

        stage.show();
    }

    /**
     * Setter Function
     * @param type
     */
    public void set_user(String type){
        this.user_type=type;
    }

    /**
     * Setter Function
     * @param type
     */
    public void set_add_type(String type){
        this.add_type=type;
    }

    Stage prevStage;

    /**
     * Setter Function
     * @param stage
     */
    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }


    /**
     * Submit Button Event Handler
     * @throws Exception
     */
    public void close() throws Exception{
        System.out.println("create");
        System.out.println(this.user_type);
        System.out.println(this.add_type);
        if(this.user_type!=null && this.add_type==null){
        if(this.user_type.equals("warehouse") && this.add_type==null){
            System.out.println("correct1");
            if(w==null){
                System.out.println("yes");
            }
                   ArrayList<Category> a = this.w.getListOfCategories();
                   Category c = new Category(t1.getText(),this.w.getName());
                   if(a==null){

                       System.out.println("I am null");
                   }
                   a.add(c);

                   this.w.setListOfCategories(a);
                   SuperUser.serial();

            }

            if(this.user_type.equals("store") && this.add_type==null){
                System.out.println("created");
//                for(Store s : SuperUser.Stores){
//                    if(s.getAdmin().getId().equals(this.s.getAdmin().getId())){
                        ArrayList<Category> a = this.s.getList();
                        Category c =new Category(t1.getText(),this.s.getName());
                        System.out.println(c.getName()) ;
                    a.add(c);

//                    SuperUser.AllCategories.add(c);
//                    System.out.println(c.getName()+ " " + c.Store_Name);
                    this.s.setList(a);
                SuperUser.serial();
//                    }
//                }
            }}
            if(this.add_type!=null) {
                if (this.add_type.equals("sub-category")) {
                    ArrayList<SubCategory> a = this.c.getList();
                    SubCategory c = new SubCategory(t1.getText());
                    a.add(c);
                    System.out.println("wrong1");
                    this.c.setList(a);
                    SuperUser.serial();
                    System.out.println("Added a subcategory");

                }


            }

//            if(this.add_type.equals("sub-category")){
//                ArrayList<SubCategory> a = this.c.getList();
//                SubCategory c = new SubCategory(t1.getText());
//                a.add(c);
//                System.out.println("wrong");
//                this.c.setList(a);
//                SuperUser.serial();
//                System.out.println("Added a subcategory");
//
//            }
            System.out.println("ware");

            SuperUser.serial();
            prevStage.close();
            if(this.user_type!=null && this.add_type==null){
            if(this.user_type.equals("store")){
            linking("Store_view");}

            if(this.user_type.equals("warehouse")){
                System.out.println("correct");
                linking("Warehouse_view");
            }
            }
            if(this.add_type!=null) {
                if (this.add_type.equals("sub-category")){
                    linking("Category_view");
                    System.out.println(-20);}

            }
            SuperUser.serial();
    }


    /**
     * Close Button Event Handler
     */
    public void close2(){
        prevStage.close();
    }




}
