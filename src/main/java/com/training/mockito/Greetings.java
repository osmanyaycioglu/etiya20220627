package com.training.mockito;

public class Greetings {

    private HelloWorld helloWorld;

    public Greetings(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String greetings() {
        System.out.println("Greetings çalıştı");
        return helloWorld.hello() + " from Turkey";
    }

    public String greetings(String name) {
        System.out.println("Greetings with name çalıştı");
        return helloWorld.greet(name) + " from Turkey";
    }

    public String greetings(String name,
                            String surname) {
        System.out.println("Greetings with name çalıştı");
        return helloWorld.sayHello(name,surname) + " from Turkey";
    }

}
