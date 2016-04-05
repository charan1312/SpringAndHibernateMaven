package com.javat.mypackage;  

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp242")
public class EmployeeWithAnnotation {  
    
    @Override
    public String toString() {
        return "EmployeeWithAnnotation [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }

    @Id
    private int id;  
    
    private String firstName;
    private String lastName;  

    public int getId() {  
        return id;  
    }
    
    public void setId(int id) {  
        this.id = id;  
    }  
    
    public String getFirstName() {  
        return firstName;  
    }
    
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }
    
    public String getLastName() {  
        return lastName;  
    }
    
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    }
}