package com.training.test.usage;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

import java.util.Comparator;
import java.util.List;

public class MyMethodOrderer implements MethodOrderer {

    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors()
               .sort(comparator);
        List<MethodDescriptor> methodDescriptors = (List<MethodDescriptor>) context.getMethodDescriptors();
        MethodDescriptor methodDescriptor0 = methodDescriptors.get(0);
        MethodDescriptor methodDescriptor1 = methodDescriptors.get(1);
        methodDescriptors.set(0,methodDescriptor1);
        methodDescriptors.set(1,methodDescriptor0);
    }

    private static final Comparator<MethodDescriptor> comparator = Comparator.comparing(
            MethodDescriptor::getDisplayName);
}
