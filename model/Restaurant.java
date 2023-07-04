package Foodkart.model;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Restaurant{
    private int id;
    private String name;
    private String item;
    private int price;
    private List<Long> servicablePincode;
    private int quantity;
    private Float rating;
    private List<Review> reviews = new ArrayList<>();
    private Integer createdBy;

    public Integer getcreatedBy(){
        return createdBy;
    }
    public void setcreatedBy(Integer createdBy){
        this.createdBy = createdBy;
    }
    public Float getRating(){
        return rating;
    }
    public void setRating(Float rating){
        this.rating = rating;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(){
        this.quantity = quantity;
    }
    public int getprice(){
        return price;
    }
    public void setprice(int price){
        this.price = price;
    }
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
    public String getname(){
        return name;
    }
    public void setname(this.name){
        this.name = name;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public List<Long> getserviceablePincode(){
        return servicablePincode;
    }
    public void setserviceablePincode(List<Long> servicablePincode){
        this.servicablePincode = servicablePincode;
    }
}