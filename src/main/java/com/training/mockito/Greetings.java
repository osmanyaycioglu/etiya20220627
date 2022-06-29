package com.training.mockito;

import java.util.List;

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

    public String greetings2(String name) {
        System.out.println("Greetings2 with name çalıştı");
        String greetMsg;
        try {
            greetMsg = helloWorld.greet(name);
            helloWorld.greet(greetMsg);
        } catch (Exception e) {
            greetMsg = "Error";
        }
        return greetMsg + " from Turkey";
    }

    public String greetings(String name,
                            String surname) {
        System.out.println("Greetings with name çalıştı");
        return helloWorld.sayHello(name,
                                   surname) + " from Turkey";
    }

    public String greetingsToAll(NameHolder nameHolder) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("I greet all ");
        for (int i = 0; i < nameHolder.size(); i++) {
            stringBuilder.append(nameHolder.getName());
            stringBuilder.append(" ");
        }
        stringBuilder.append(".");
        return stringBuilder.toString();
    }

    public void proc(NameHolder nameHolder) {
        for (int i = 0; i < nameHolder.size(); i++) {
            System.out.println(nameHolder.getName());
        }
        nameHolder.reset();
    }

}
