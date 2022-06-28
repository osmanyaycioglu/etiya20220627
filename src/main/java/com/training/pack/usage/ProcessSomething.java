package com.training.pack.usage;

public class ProcessSomething {

    public String processPublic(String str) {
        return "Processed : " + str;
    }

    protected String processProtected(String str) {
        return "Processed : " + str;
    }

    private String processPrivate(String str) {
        return "Processed : " + str;
    }

    String processPrivateProxy(String str) {
        return processPrivate(str);
    }

    String processPackagePrivate(String str) {
        return "Processed : " + str;
    }

}
