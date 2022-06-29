package com.training.mockito;

public class HelloWorld {

    public String hello() {
        System.out.println("Data from DB");
        return "hello world";
    }

    public String greet(String name) {
        System.out.println("Data from File");
        return "hello " + name;
    }

    public String sayHello(String name,
                           String surname) {
        System.out.println("Data from WS");
        return "hello " + name + " " + surname;
    }


}
