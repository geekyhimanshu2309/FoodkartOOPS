package Foodkart.service;
import java.util.*;
public class OrderService {
    private static OrderService instance=null;
    private OrderService(){

    }
    public static OrderService getinstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;
    }
    UserDao userDao=UserDao.getInstance();
    public Order placeOrder(String name, Integer quantity){
        if(quantity <= 0){
            System.out.println("invalid value for mandatory fields");
        }
        return userDao.placeOrder(name,quantity);
    }
    public List<Order> listOrders(){
        return userDao.listOrders();
    }

}
