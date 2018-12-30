package Classes;

public class Store_Admin extends User {



    public Store_Admin(String name,String password) {
        super(name,password);
    }

    @Override
    public String toString() {
        return "StoreAdmin [AdminName=" + name + ", Passoword=" + password + "]";
    }
}
