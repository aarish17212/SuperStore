package Classes;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String code;
    private int H,D,K;
    private int quantity;
    private String decription;

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
    }

    public Item(String name, int h, int d, int k, int quantity) {
        this.name = name;
        this.quantity= quantity;
        H = h;
        D = d;
        K = k;
//        this.decription=decription;
    }

    public String toString(){
        return this.name;
    }
}
