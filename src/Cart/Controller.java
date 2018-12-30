package Cart;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ComboBox<Store> ViewAllStoresComboBox;
    @FXML
    ComboBox<OrderedItem> OrdersComboBox;
    @FXML
    Label LabelNoOrderedItems;

    @FXML
    ListView<OrderedItem> ListViewOrderedItems;

    /**
     * Observable List for displaying items in cart
     * @return
     */
    private ObservableList<OrderedItem> getData(){
        ObservableList<OrderedItem> Items = FXCollections.observableArrayList();

        System.out.println("All Ordered Items are :- ");
        for(OrderedItem x : SuperUser.OrderedItems){
            System.out.println(x.getItemName() + " $  " + x.getQuantityOrdered());
            Items.add(x);
        }

        return Items;
    }

    /**
     * Number of Ordered Items
     * @return
     */
    private int SizeOfOrderedItems(){
        return SuperUser.OrderedItems.size();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<OrderedItem> o = getData();
        LabelNoOrderedItems.setText("Number of Ordered Items :- " + Integer.toString(SizeOfOrderedItems()));
        for(OrderedItem x : o){
            System.out.println(x);
        }
        ListViewOrderedItems.setItems(o);
//        table.getColumns().addAll(name,quantity);

        if (SuperUser.OrderedItems.size() != 0) {
            OrdersComboBox.setItems(FXCollections.observableList(SuperUser.OrderedItems));
        }
        if(SuperUser.Stores.size()!=0){
            ViewAllStoresComboBox.setItems(FXCollections.observableList(SuperUser.Stores));
        }
//        Cart.DebugCart();
    }

    @FXML
    public void BrowseAllStores() throws Exception{
        forward("End_User");
    }

    /**
     * Remove Button Event Handler
     */
    public void remove(){
        this.call_remove();
    }

    /**
     * Check-Out Button Event Handler
     */
    public void checkout(){
        ArrayList<Item>  zero = new ArrayList<>();
        ArrayList<Store> p_stores = new ArrayList<>();
        for(Store s:SuperUser.Stores){
            for(Category c:s.getList()){
                for(SubCategory sc:c.getList()){
                    for(Item i:sc.getList()){
                        for(OrderedItem o : SuperUser.OrderedItems){
                            if(i.getName().equals(o.getItemName())){
                                i.setQuantity(i.getQuantity()-o.getQuantityOrdered());
                                if(i.getQuantity()<=0){
                                    zero.add(i);
                                    p_stores.add(s);
                                }
                            }
                        }
                    }
                }
            }
        }
        SuperUser.serial();

        SuperUser.OrderedItems = new ArrayList<>();
        ObservableList<OrderedItem> o = getData();
        LabelNoOrderedItems.setText("Number of Ordered Items :- " + Integer.toString(SizeOfOrderedItems()));
        for(OrderedItem x : o){
            System.out.println(x);
        }
        ListViewOrderedItems.setItems(o);
//        table.getColumns().addAll(name,quantity);

        if (SuperUser.OrderedItems.size() != 0) {
            OrdersComboBox.setItems(FXCollections.observableList(SuperUser.OrderedItems));
        }
        if(SuperUser.Stores.size()!=0){
            ViewAllStoresComboBox.setItems(FXCollections.observableList(SuperUser.Stores));
        }

        for(int j=0;j<zero.size();j++){
            p_stores.get(j).handle_orders(zero.get(j));
        }

    }

    /**
     * Remove Button Helper Function to read the current value of comboBox
     */
    public void call_remove(){
        OrderedItem s = OrdersComboBox.getValue();
//        String s1 = s.toString();
        SuperUser.OrderedItems.remove(s);
        ObservableList<OrderedItem> o = getData();
        LabelNoOrderedItems.setText("Number of Ordered Items :- " + Integer.toString(SizeOfOrderedItems()));
        for(OrderedItem x : o){
            System.out.println(x);
        }
        ListViewOrderedItems.setItems(o);
//        table.getColumns().addAll(name,quantity);

        if (SuperUser.OrderedItems.size() != 0) {
            OrdersComboBox.setItems(FXCollections.observableList(SuperUser.OrderedItems));
        }
        if(SuperUser.Stores.size()!=0){
            ViewAllStoresComboBox.setItems(FXCollections.observableList(SuperUser.Stores));
        }


    }

    /**
     * Redirecting to another page on an Action Event
     * @param check
     * @throws Exception
     */
    public void forward(String check) throws Exception {

        if (check.equals("End_User")) {
            Stage stage = new Stage();
            stage.setTitle("Super Store");
            Pane myPane = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + check + "/" + check + ".fxml"));
            System.out.println("Trying to redirect to Browsing All Stores");
            myPane = (Pane) loader.load();
            Scene scene = new Scene(myPane);
            stage.setScene(scene);

            stage.show();
//            Store_view.Controller controller1 = (Store_view.Controller) loader.getController();
//            controller1.setPrevStage(stage);
//            controller1.s = this.s;
//            controller1.set_user("store");
        }

    }

}
