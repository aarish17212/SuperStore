package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class SubCategory implements Serializable {

    private String name;
    public ArrayList<Item> List;
    public SubCategory(String name){
        List = new ArrayList<Item>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getList(){
        return List;
    }

    public void setList(ArrayList a){
        this.List = a;
    }

    void addItem(Item s){
        List.add(s);
    }

    void removeItem(Item s){
        for(Item x:List){
            if(x==s) List.remove(x);
        }
        return;
    }

    public String toString(){
        return (this.name);
    }
}
