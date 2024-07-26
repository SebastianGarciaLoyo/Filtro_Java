package domain.entity;

public class Person {
    private String name;
    private String lastname;
    private int id_city;
    private String address;
    private int age;
    private String email;
    private int gender;
    
    public Person() {
    }

    public Person(String name, String lastname, int id_city, String address, int age, String email, int gender) {
        this.name = name;
        this.lastname = lastname;
        this.id_city = id_city;
        this.address = address;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    

        
}
