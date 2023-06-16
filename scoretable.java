/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */


@Entity
@Table(name="scoretable")
public class scoretable implements Serializable{
    
     
    @Column(name="user_name")
    private String user_name; 
     
     @Id
    @Column(name="id")
    private int id; 
     
       
    @Column(name="dateTime")
    private String dateTime;
       
       
       
    @Column(name="score")
   private  int score;
       
       
       


    public scoretable() {
    }

    public scoretable(String user_name, int id, String dateTime, int score) {
        this.user_name = user_name;
        this.id = id;
        this.dateTime = dateTime;
        this.score = score;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getScore() {
        return score;
    }
       
       
     
    
}
