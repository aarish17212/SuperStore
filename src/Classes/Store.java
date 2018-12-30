package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {
    private Store_Admin admin;
    private String name;

    public void setList(ArrayList<Category> list) {
        List = list;
    }

    public ArrayList<Category> getList() {
        return List;
    }

    ArrayList<Category> List;
    Warehouse parent_warehouse;

    public Store(Store_Admin admin,String name){
        this.admin = admin;
        this.name = name;
        List = new ArrayList<Category>();
        parent_warehouse = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void LinkStoreWarehouse(Warehouse w){
        this.parent_warehouse = w;
    }

    public Store_Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Store_Admin admin) {
        this.admin = admin;
    }



    public Warehouse getParent_warehouse() {
        return parent_warehouse;
    }

    public void setParent_warehouse(Warehouse parent_warehouse) {
        this.parent_warehouse = parent_warehouse;
    }

    @Override
    public String toString() {
        return this.name + "(" + admin.name + ")";
    }


    public boolean check(ArrayList<Warehouse> list , Item a) {
        int required_quantity = (int) Math.ceil(Math.sqrt((2 * a.getD() * a.getK()) / (a.getH())));
        for (Warehouse h : list) {
            System.out.println("nameeeeeeeee"+  h.getName());
            for (Category c1 : h.getListOfCategories()) {
                System.out.println("namee" + c1.getName());
                for (SubCategory sc : c1.getList()) {
                        System.out.println(sc.getName());
                    for (Item it : sc.getList()) {
                        System.out.println(it.getName());
                        if (it.getName().equals(a.getName()) && it.getQuantity() >= required_quantity) {
                            a.setQuantity(a.getQuantity() + required_quantity);
                            it.setQuantity(it.getQuantity() - required_quantity);
                            System.out.println("match found");
                            System.out.println("Quantity" + a.getQuantity());
                            System.out.println(it.getQuantity());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void handle_orders(Item a){
        System.out.println("Started handling");
        Warehouse parent = this.getParent_warehouse();
        String c = parent.getCity();
        System.out.println(c);
       boolean check  = false;
        int required_quantity = (int)Math.ceil(Math.sqrt((2*a.getD()*a.getK())/(a.getH())));
        for(Category c1: parent.getListOfCategories()){
            for(SubCategory sc: c1.getList()){
                System.out.println("size" + sc.getList().size());
                for(Item it : sc.getList()){
                    System.out.println(it.getName());
                    if(it.getName().equals(a.getName()) && it.getQuantity()>=required_quantity){
                       check = true;
                       a.setQuantity(a.getQuantity()+required_quantity);
                       it.setQuantity(it.getQuantity()-required_quantity);
                       System.out.println("checkkk" + a.getQuantity() + it.getQuantity());
                       break;
                    }
                }
            }
        }
        int i = SuperUser.cities.indexOf(c);
        if(i==0){
            boolean ch = check(SuperUser.Delhi,a);
            check=ch;
        }
        if(i==1){
            boolean ch = check(SuperUser.Mumbai,a);
            check=ch;
        }
        else{
            boolean ch = check(SuperUser.Kolkata,a);
            check=ch;
        }

        if(check==false){

        if (i != 2) {
            i=i+1;
        }
        else{
            i=0;
        }

        while(c.equals(SuperUser.cities.get(i))==false){
            System.out.println("loop");
            if(i==0){
                boolean ch = check(SuperUser.Delhi,a);
                if(ch==false)
                i+=1;
                else{
                    break;
                }
            }

            else if(i==1){
                boolean ch = check(SuperUser.Mumbai,a);
                if(ch==false)
                i+=1;

                else{
                    break;
                }
            }

            else{
                boolean ch = check(SuperUser.Kolkata,a);
                if(ch==false)
                i=0;
                else{
                    break;
                }
            }

        }

    }
    SuperUser.serial();}
}
