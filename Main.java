package Foodkart;

import Foodkart.data.UserDao;
import Foodkart.model.Order;
import Foodkart.model.Restaurant;
import Foodkart.model.Review;
import Foodkart.model.user;
import Foodkart.service.OrderService;
import Foodkart.service.RestaurantService;
import Foodkart.service.UserService;

import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        System.out.println("Execution Started");
        UserService userService = UserService.getInstance();
        RestaurantService restaurantSerview = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();
    }
}
