package Classes;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class SuperUser extends User {
    public static ArrayList<Store> Stores = new ArrayList<>();
    public static ArrayList<Warehouse> Warehouses = new ArrayList<>();
    public static ArrayList<Store_Admin> StoreAdmins = new ArrayList<>();
    public static ArrayList<Warehouse_Admin> WarehouseAdmins = new ArrayList<>();
    public static ArrayList<OrderedItem> OrderedItems = new ArrayList<>();

    public static ArrayList<String> cities = new ArrayList<>(Arrays.asList("Delhi" , "Mumbai" , "Kolkata"));

    public static ArrayList<Warehouse> Delhi = new ArrayList<>();
    public static ArrayList<Warehouse> Mumbai = new ArrayList<>();
    public static ArrayList<Warehouse> Kolkata = new ArrayList<>();

    public static int CounterForUser = 0;

//    public static ArrayList<Category> AllCategories = new ArrayList<>();

    public static void DebugData(){
        System.out.println("The Store Admin Names and passwords are ");
        for(Store_Admin x : StoreAdmins){
            System.out.println(x);
        }
        System.out.println("The Warehouse Admin Names and passwords are ");
        for(Warehouse_Admin x : WarehouseAdmins){
            System.out.println(x);
        }
        System.out.println("The Store Names and their admin names are ");
        for(Store x : Stores){
            System.out.println(x);
            System.out.println("The Categories in the store are ");
            for(Category y : x.getList()){
                System.out.println("\t" + y);
                System.out.println("The List of SubCategories in this Category are ");
                for(SubCategory z : y.getList()){
                    System.out.println("\t \t" + z);
                    for(Item it: z.getList()){

                    }
                }
            }
        }
        System.out.println("The Warehouse Names and their admin names are");
        for(Warehouse x : Warehouses){
            System.out.println(x);
            System.out.println("The Categories in the warehouse are ");
            for(Category y : x.getListOfCategories()){
                System.out.println("\t" + y);
                System.out.println("The List of SubCategories in this Category are ");
                for(SubCategory z : y.getList()){
                    System.out.println("\t \t" + z);
                }
            }
        }
        System.out.println("All Categories Are ");
//        for(Category x : AllCategories){
//            System.out.println("\t" + x.getName() + " " + x.Store_Name );
//        }
    }

    public static void serial(){

        try
        {
            FileOutputStream fos = new FileOutputStream("StoreData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Stores);
            oos.close();
            fos.close();
            fos = new FileOutputStream("WarehouseData");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Warehouses);
            oos.close();
            fos.close();
            fos = new FileOutputStream("StoreAdminData");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(StoreAdmins);
            oos.close();
            fos.close();
            fos = new FileOutputStream("WarehouseAdminData");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(WarehouseAdmins);
            oos.close();
            fos.close();
            fos = new FileOutputStream("Counter");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(User.counter);
            fos.close();
            oos.close();
//            fos = new FileOutputStream("OrderedItems");
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(OrderedItems);
//            fos.close();
//            oos.close();
            fos = new FileOutputStream("Delhi");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Delhi);
            fos.close();
            oos.close();
            fos = new FileOutputStream("Mumbai");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Mumbai);
            fos.close();
            oos.close();
            fos = new FileOutputStream("Kolkata");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Kolkata);
            fos.close();
            oos.close();

//            fos = new FileOutputStream("AllCategories");
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(AllCategories);
//            fos.close();
//            oos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static void deserial(){
        try
        {
            FileInputStream fis = new FileInputStream("StoreData");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Stores = (ArrayList<Classes.Store>) ois.readObject();

            fis = new FileInputStream("WarehouseData");
            ois = new ObjectInputStream(fis);

            Warehouses = (ArrayList<Classes.Warehouse>) ois.readObject();

            fis = new FileInputStream("StoreAdminData");
            ois = new ObjectInputStream(fis);

            StoreAdmins = (ArrayList<Store_Admin>) ois.readObject();

            fis = new FileInputStream("WarehouseAdminData");
            ois = new ObjectInputStream(fis);

            WarehouseAdmins = (ArrayList<Warehouse_Admin>)  ois.readObject();

            ois.close();
            fis.close();

            fis = new FileInputStream("Counter");
            ois = new ObjectInputStream(fis);

            CounterForUser = (Integer) ois.readObject();

            ois.close();
            fis.close();

//            fis = new FileInputStream("OrderedItems");
//            ois = new ObjectInputStream(fis);
//
//            OrderedItems = (ArrayList<OrderedItem>) ois.readObject();
//
//            ois.close();
//            fis.close();

            fis = new FileInputStream("Delhi");
            ois = new ObjectInputStream(fis);

            Delhi = (ArrayList<Warehouse>) ois.readObject();

            ois.close();
            fis.close();

            fis = new FileInputStream("Mumbai");
            ois = new ObjectInputStream(fis);

            Mumbai = (ArrayList<Warehouse>) ois.readObject();

            ois.close();
            fis.close();

            fis = new FileInputStream("Kolkata");
            ois = new ObjectInputStream(fis);

            Kolkata = (ArrayList<Warehouse>) ois.readObject();

            ois.close();
            fis.close();

//            fis = new FileInputStream("AllCategories");
//            ois = new ObjectInputStream(fis);

//            AllCategories = (ArrayList<Category>) ois.readObject();
//
//            for(Category x : AllCategories){
//                for(Store y : Stores){
//                    if(x.Store_Name.equals(y.getName())){
//                        y.getList().add(x);
//                    }
//                }
//            }

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }



        DebugData();
    }

    static public int getCounter() {
        return CounterForUser;
    }

    void create_warehouse(){

    }

    void create_store(){

    }
}
