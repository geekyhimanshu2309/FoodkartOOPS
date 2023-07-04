package Foodkart.service;

import Fooodkart.constants.Gender;
import Foodkart.data.UserDao;
import Foodkart.model.user;

public class UserService{
    private static UserService instance = null;
    private UserService(){

    }
    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }
    UserDao UserDao=UserDao.getInstance();
    public  User registerUser(Long phone, String name, Long pinCode, Gender gender){
        if(phone == null || phone<=0){
            System.out.println("Phone number can not be null\n");
            return null;
        }else if(pinCode==null || pinCode<=0){
            System.out.println("invalid pincode\n");
            return null;
        }else if(name.isEmpty()){
            System.out.println("invalid value for name\n");
            return null;
        }
        return UserDao.registerUser(phone,name,pinCode,gender);
    }
    public User login(long id){
        return userDao.login(id);
    }
}