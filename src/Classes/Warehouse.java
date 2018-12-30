package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Serializable {
    private Warehouse_Admin admin;
    private String name;
    private ArrayList<Category> ListOfCategories;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setListOfCategories(ArrayList<Category> listOfCategories) {
        ListOfCategories = listOfCategories;
    }

    public ArrayList<Category> getListOfCategories() {
        return ListOfCategories;
    }

    static ArrayList<Warehouse> ListOfWarehouse;

    public Warehouse(Warehouse_Admin admin,String name){
        this.admin = admin;
        this.name = name;
        ListOfCategories = new ArrayList<Category>();
//        ListOfItems = new ArrayList<Item>();
    }



    public Warehouse_Admin get_Admin(){
        return this.admin;
    }


    public Warehouse_Admin getAdmin() {
        return admin;
    }


    public void setAdmin(Warehouse_Admin admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Warehouse [WarehouseName=" + name + ", AdminName=" + admin + "]";
    }
}
