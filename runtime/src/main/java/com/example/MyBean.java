package com.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyBean {
 
    public int doStuff(){
        int i = 0;
        i += 1;
        return i;
    }
}
