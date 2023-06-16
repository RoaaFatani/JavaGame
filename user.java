/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Asus
 */

@Entity
@Table(name="user")
public class user implements Serializable {
    @Id
    @Column(name="user_name")
     private String user_name; 
    
    @Column(name="password")
    private String password; 
     
    @Column(name="email")
    private String email; 
    
    @Column(name="coun")
    private String coun; 

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCoun() {
        return coun;
    }

    public void setCoun(String coun) {
        this.coun = coun;
    }

    public user(String user_name, String password, String email, String coun) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.coun = coun;
    }
 public user() {
    }
      
      
    
}

   class HighToLowComparator implements Comparator<scoretable> {

    @Override
    public int compare(scoretable p1, scoretable p2) {
        return Integer.compare(p2.getScore(), p1.getScore());
    }
    
}
   