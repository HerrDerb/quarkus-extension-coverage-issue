package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.QuarkusUnitTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class MyBeanTest {
    
    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest();
    
    @Inject
    MyBean myBean;

    @Test
    void test(){
        int i = myBean.doStuff();
        assertEquals(1, i);
    }
}
