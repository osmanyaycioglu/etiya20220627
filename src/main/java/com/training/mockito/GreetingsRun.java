package com.training.mockito;

public class GreetingsRun {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        Greetings greetings = new Greetings(helloWorld);
        System.out.println(greetings.greetings());
    }
}
