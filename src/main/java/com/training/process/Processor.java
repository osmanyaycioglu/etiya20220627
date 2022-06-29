package com.training.process;

public class Processor {
    private ProcessTask processTask;

    public Processor(ProcessTask processTask) {
        this.processTask = processTask;
    }

    public String process(String taskId) throws Exception {
        return  processTask.process(taskId) + " processed.";
    }

}
