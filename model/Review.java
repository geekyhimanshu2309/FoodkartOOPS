package Foodkart.model;
import java.io.*;
import java.util.*;
public class Review{
    private int id;
    private int score;
    private String comment;
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}