package MPP1.src.ppp.builderDesignPathern;

import java.util.Arrays;

public class Customer {
    //required fields
    private String firstName;
    private String lastName;
    private int age;
    //optional fields
    private String email;
    private String address;
    private String phoneNumber;

    //Constructor to take the customerBuilder as parameter
    private Customer(CustomerBuilder customerBuilder) {
   this.firstName=customerBuilder.firstName;
   this.lastName= customerBuilder.lastName;
   this.age=customerBuilder.age;
   this.email= customerBuilder.email;
   this.address= customerBuilder.address;
   this.phoneNumber= customerBuilder.phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class CustomerBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String address;
        private String phoneNumber;

        public CustomerBuilder(String firstName, String lastName, int age){
            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
        }
        public CustomerBuilder setAddress(String address){
            this.address=address;
            return this;
        }
        public CustomerBuilder setEmail(String email){
            this.email=email;
            return this;
        }
        public CustomerBuilder setPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }

    }
}

class BuilderDemo{
    public static void main(String[] args) {
//Customer customer=new Customer.CustomerBuilder("Alexa","John",23)
//        .setEmail("alexa@gmail.com")
//        .setAddress("Asmara")
//        .setPhoneNumber("123-345-234")
//        .build();
//        System.out.println(customer);
//Customer cust=new Customer.CustomerBuilder("Ali","Mussa",27)
//        .setEmail("alimussa@gmail.com")
//                .build();
//        System.out.println(cust);
//Customer customer1=new Customer.CustomerBuilder("Sudip","Shresta",19).build();
//        System.out.println(customer1);
        Customer[] customersArray = {
                new Customer.CustomerBuilder("Alexa", "John", 23)
                        .setEmail("alexa@gmail.com")
                        .setAddress("Asmara")
                        .setPhoneNumber("123-345-234")
                        .build(),

                new Customer.CustomerBuilder("Ali", "Mussa", 27)
                        .setEmail("alimussa@gmail.com")
                        .build(),

                new Customer.CustomerBuilder("Sudip", "Shresta", 19).build()
        };

        // Use Arrays.stream() to create a stream from the array and forEach to print each customer
        Arrays.stream(customersArray).forEach(System.out::println);


    }
}
