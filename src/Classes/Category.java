package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable
{
    private String name;
    public String Store_Name;
    public ArrayList<SubCategory> List;
    public Category(String name,String StoreName){
        List = new ArrayList<SubCategory>();
        this.name = name;
        this.Store_Name = StoreName;
//        SuperUser.AllCategories.add(this);
    }

    public String toString(){
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubCategory> getList(){
        return List;
    }

    public void setList(ArrayList<SubCategory> c){
        List=c;
    }

    void addSubcategory(SubCategory s){
        List.add(s);
    }

    void removeSubcategory(SubCategory s){
        for(SubCategory x:List){
            if(x==s) List.remove(x);
        }
        return;
    }
}
