package Foodkart.model;
import Foodkart.constants.Gender;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class user{
    private int id;
    private String name;
    private Long phone;
    private Long pinCode;
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Order> orders = new ArrayList<>(); 

    public user(int id, Long phone, String name, Long pinCode, Gender gender){
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.pinCode = pinCode;
        this.gender = gender; 
    }
    public List<Order> getOrders(){
        return orders;
    }
    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
    public List<Restaurant> getRestaurants(){ return restaurants;}
    public void setRestaurants(List<Restaurant> restaurants){ this.restaurants=restaurants;}
    public int getId(){ return id; }
    public void setId(){ this.id = id;}
    public String getName(){ return name;}
    public void setName(String name){
        this.name = name;
    }
    public Gender getGender(){ return gender; }
    public void getGender(Gender gender){ this.gender = gender;}
    public Long getPhone(){ return phone;}
    publid void getPhone(Long phone){ this.phone = phone;}
    public Long getpinCode(){ return pinCode; }
    public void setpinCode(Long pinCode){ this.pinCode = pinCode;}
    public 
}