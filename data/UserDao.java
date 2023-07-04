package Foodkart.data;

import Foodkart.constants.Gender;
import Foodkart.model.Order;
import Foodkart.model.Restaurant;
import Foodkart.model.Review;
import Foodkart.model.user;
import Foodkart.util.IDGenerator;
import java.util.*;

import javax.security.auth.login.LoginException;

public class UserDao {
    private static UserDao userDao = null;
    private UserDao(){

    }   
    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    } 
    //Maps to link data
    private HashMap<Integer, User> userHashMap = new HashMap<>();
    private HashMap<Long, Integer> phoneNumberMap = new HashMap<>();
    private HashMap<String, Restaurant> restaurantHashMap = new HashMap<>();

    private user loggedInUser = null;           //Initially logged in user is null
    public user registerUser(Long phone, String name, Long pinCode, Gender gender){
        if(phoneNumber.containsKey(phone)){
            user user=userHashMap.get(phoneNumberMap.get(phone));
            System.out.println("User already exist with phone number" + phone + "with user id"+user.getId()+ "\n");
            return user;
        }
        user user = new user(IDGenerator.getId(), phone, name, pinCode,gender);
        phoneNumberMap.put(phone, user.getId());
        userHashMap.put(user.getId(),user);
        System.out.println("Successfully created user with user id: "+ user.getId()+"\n");
        return user;
    }
    public user login(Long phone){
        if(phoneNumberMap.containsKey(phone)){
            System.out.println("No user exists with phone " + phone);
            return null;
        }
        user user = userHashMap.get(phoneNumberMap.get(phone));
        loggedInUser = user;
        System.out.println("Successfully logged in user id" + user.getId()+"\n");
        return user;
    }
    public Restaurant registerRestaurant(String name, String pinCode, String item, int price){
        if(loggedInUser == null){
            System.out.println("No logged in user found, request can't be served.");
            return null;
        }
        if(restaurantNameMap.containsKey(name)){
            System.out.println("Restaurant alreday exist with given name, please give unique name");
            return null;
        }
        List<String> pinCodeList = Arrays.asList(pinCodes.split(","));
        List<Long> pins = new ArrayList<>();
        if(pinCodes.isEmpty()){
            for(String s: pinCodeList){
                if(!s.chars().allMatch(Character :: isDigit)){
                    System.out.pritnln("Invalid pinCode provided \n");
                    return null;
                }
                pins.add(Long.parseLong(s));
            }
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setId(IDGenerator.getId());
        restaurant.setName(name);
        restaurant.setItem(item);
        restaurant.setQuantity(quantity);
        restaurant.setprice(price);
        restaurant.setserviceablePincode(pins);
        restaurant.setcreatedBy(loggedInUser.getId());
        restaurantNameMap.put(name,restaurant);
        loggedInUser.getRestaurants().add(restaurant);
        System.out.println("Successfully registered restaurant id"+restaurant.getId()+"\n");
        return restaurant;
    }

    public Review rateRestaurant(String restaurantname, Integer rating, String comment){
        Restaurant restaurant = restaurantNameMap.get(restaurantname);
        if(restaurant == null){
            System.out.println("No restaurant found with given name "+restaurantname);
            return null;
        }
        Review review = new Review();
        review.setId(IDGenerator.getId());
        review.setComment(comment);
        review.setScore(rating);

        if(restaurant.getReview() == null || restaurant.getReview().size()==0){
            restaurant.setRating(Float.valueOf(rating));
        }else{
            float currentScore = (restaurant.getRating() + restaurant.getReview().size() + rating)/restaurant.setRating(currentScore);
        }
        restaurant.getReviews().add(review);
        return review;
    }

    public Restaurant updateQuantity(String restaurantName, int quantity){
        Restaurant restaurant = restaurantNameMap.get(restaurantName);
        if(restaurant == null){
            System.out.println("No Restaurant found with given name "+restaurantName );
            return null;
        }
        restaurant.setQuantity(restaurant.getQuantity()+ quantity);
        return restaurant;
    }
    public List<Restaurant> showRestaurants(String sortBy){
        List<Restaurant> r = loggedInUser.getRestaurants();
        List<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant restaurant: r){
            if(restaurant.getserviceablePincode().contains(loggedInUser.getpinCode()) && restaurant.getQuantity()>0)
                restaurants.add(restaurant);
        }
    }
    if(sortBy.equalsIgnoreCase(anotherString:"rating")){
        Collections.sort(restaurants,new SortByRating());
        for(Restaurant restaurant: restaurants){
            System.out.println("Restaurant id:"+restaurant.getId()+": name ->"+restaurant.getName()+": price -> "+restaurant.getprice() +" : rating -> "+ restaurant.getQuantity());
            return restaurants;
        }
    }
    Collections.sort(restaurants,new SortByPrice());
    for(Restaurant restaurant: restaurants){
        System.out.println("Restaurant id:"+restaurant.getId()+": name ->"+restaurant.getName()+": price -> "+restaurant.getprice() +" : rating -> "+ restaurant.getQuantity());

    }
    return restaurants;

    public Order placeOrder(String restaurantname, Integer quantity){
        Restaurant restaurant = restaurantNameMap.get(name);
        if(restaurant == null){
            System.out.println("No restaurant found with given  name " + restaurantname);
            return null;
        }
        if(restaurant.getQuantity() == 0){
            System.out.println("restaurant is out of stock , please try later ");
            return null;
        }
        if(restaurant.getQuantity() < quantity){
            System.out.println("Restaurant has only"+ restaurant.getQuantity() " Items," + restaurant.item);
            return null;
        }

        Order order = new Order();
        order.setId(IDGenerator.getId());
        order.setItem(restaurant.getItem());
        order.setQuantity(Quantity());
        order.setUserId(loggedInUser.getId());
        order.settimestamp(System.currentTimeMillis());
        order.setCost((long)(quantityrestaurant.getprice()));
        restaurant.setQuantity(restaurant.getQuantity()-quantity);
        loggedInUser.getOrders().add(order);
        return order;
    }
    public List<Order> listOrders(){
        for(Order order : loggedInUser.getOrders()){
            System.out.println("Order Id: "+order.getId()+" item: " + order.getItem() + " quantity: "+ order.getQuantity() + " cost : "+order.getCost());
        }
        return loggedInUser.getOrders();
    }



    class SortByRating implements Comparator<Restaurant>{
        @Override
        public int compare(Restaurant o1, Restaurant o2){
            if(o1.getRating() == null || o2.getRating == null) return 0;
            if(o1.getRating() > o2.getRating)
                return 1;
            else if(o1.getRating()== o2.getRating())
                return 0;
            else 
                return -1;
        }
    }
    class SortByPrice implements Comparator<>Restaurant>{
        @Override
        public int compare(Restaurant o1, Restaurant o2){
            return o1.getprice()-o2.getprice(); 
        }
    }
}

