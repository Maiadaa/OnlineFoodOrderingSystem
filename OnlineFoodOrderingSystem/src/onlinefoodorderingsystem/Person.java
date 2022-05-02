package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Person {

    private int ID;
    private String Name;
    private String Email;
    private String Phone_number;
    private String Address;
    private String Username;
    private String Password;
    private char Gender;

    public Person() {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone_number(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public String getAddress() {
        return Address;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public char getGender() {
        return Gender;
    }
    
    

}//end Person
