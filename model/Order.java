package Foodkart.model;
public class Order{
    private int id;
    private int restaurantId;
    private int userId;
    private int quantity;
    private String item;
    private Long timestamp;
    private Long cost;

    public Long getCost(){
        return cost;
    }
    public void setCost(Long cost){
        this.cost = cost;
    }
    public int getId(){
         return id;
    }
    public void setId(int id){
        this.id = id;   
    }
    public int restaurantId(){
        return restaurantId;
    }
    public void setrestaurantId(this restaurantId){
        this.restaurantId = restaurantId;
    }
    public int getuserId(){
        return userId;
    }
    public void setuserId(int userId){
        this.userId = userId;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String getItem(){
        return item;
    }
    public void setItem(int item){
        this.item = item;
    }
    public Long gettimestamp(){
        return timestamp;
    }
    public void settimestamp(Long timestamp){
        this.timestamp = timestamp;
    }
}