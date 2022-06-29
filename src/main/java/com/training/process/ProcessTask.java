package com.training.process;

import java.util.UUID;
import java.util.concurrent.Callable;

public class ProcessTask {

    public String process(String name) throws Exception {
        // web service den bir task id
        // DB task ın uuid
        Callable<String> runnable = new Callable<>() {
            private UUID uuid;
            @Override
            public String call() throws Exception {
                return "Task " + uuid + " executed.";
            }
        };
        return runnable.call();
    }

}
