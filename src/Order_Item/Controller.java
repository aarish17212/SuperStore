package Order_Item;

//import Classes.Cart;
import Classes.Item;
import Classes.OrderedItem;
import Classes.SubCategory;
import Classes.SuperUser;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    TextField ItemName;
    @FXML
    TextField Quantity;
    public static SubCategory sc;
    public static Item it;

    /**
     * Iniatilizing Controller Object
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    /**
     * Submit Button event handler
     */
    public void Submit(){
//        String item_name = ItemName.getText();
        int quantity = Integer.parseInt(Quantity.getText());
        if(quantity<=it.getQuantity()){
//        ;it.setQuantity(it.getQuantity()-quantity)
            OrderedItem order = new OrderedItem(it.getName(),quantity);
            SuperUser.OrderedItems.add(order);

        }

        else{
            Quantity.clear();
        }

//        SuperUser.serial();
//        Cart.DebugCart();
    }

    /**
     * Cancel Button Event Handler
     */
    public void Cancel(){

    }

}
