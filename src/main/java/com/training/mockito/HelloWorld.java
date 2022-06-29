package com.training.mockito;

public class HelloWorld {

    public String hello() {
        System.out.println("Data from DB");
        return "hello world";
    }

    public String greet(String name) {
        System.out.println("Data from File");
        if (name.length() > 7) {
            throw new IllegalArgumentException("7 den büyük olamaz");
        }
        if (name.length() > 5) {
            name = name.substring(0,
                                  5);
        }
        return "hello " + name;
    }

    public String sayHello(String name,
                           String surname) {
        System.out.println("Data from WS");
        return "hello " + name + " " + surname;
    }

    public String sayGoodbye(String name,
                             String surname) {
        logHello("sayGoodbye",
                 "hello " + name + " " + surname);
        return "hello " + name + " " + surname;
    }


    public void logHello(String type,
                         String message) {
        System.out.println(type + " : " + message);
    }

}
