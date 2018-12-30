package Classes;

import sun.security.util.Password;

import java.io.Serializable;

public class User implements Serializable {
    protected String id;
    protected String password;
    protected String name;


    static int counter = SuperUser.getCounter();

    public User(String name, String password) {
        this.id = (Integer.toString(counter++));
        this.password = password;
        this.name = name;
    }

    public User(){}

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
