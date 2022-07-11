package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
  
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;
  
    public Contact(String name, String birthDate, String phoneNumber) throws ParseException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number must be greater than 5 characters");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = generateAge(birthDate);
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.birthDate = source.birthDate;
        this.phoneNumber = source.phoneNumber;
        this.age = source.age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        this.age = generateAge(birthDate);
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number must be greater than 5 characters");
        }
        this.phoneNumber = phoneNumber;
    }

    public int generateAge(String birthDate) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        formatDate.setLenient(false);
        long difference = new Date().getTime() - formatDate.parse(birthDate).getTime();
        return (int) (TimeUnit.MILLISECONDS.toDays(difference) / 365);
    }

    public String toString() {
        return "Name: " + this.name + "\n" +
               "Age: " + this.age + "\n" +
               "Birth Date: " + this.birthDate + "\n" +
               "Phone Number: " + this.phoneNumber + "\n"; 
    }

}
