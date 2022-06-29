package com.training.mockito;

public class HelloWorldDelegatedProxy extends HelloWorld {


    private HelloWorld helloWorld;

    private int helloCounter = 0;

    public HelloWorldDelegatedProxy(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public String hello() {
        // String hello = helloWorld.hello();
        helloCounter++;
        switch (helloCounter){
            case 1:
                return "Test data";
            case 2:
                return "Merhaba data";
            case 3:
                return "Ola data";
            default:
                return "data";
        }
    }

    @Override
    public String greet(String name) {
        return "Test greet " + name;
    }

    @Override
    public String sayHello(String name,
                           String surname) {
        return "Test hello " + name + " " + surname;
    }
}
