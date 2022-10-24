package bean;

/**
 * JavaBean for Customer
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;


    public Customer(){
        super();
    }

    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

