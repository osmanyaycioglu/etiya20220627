package com.training.pack.usage.abc;

import com.training.pack.usage.ProcessSomething;

public class ProcessSomethingExt extends ProcessSomething {

    public void abc(){
        super.processProtected("xyz");
    }
}
