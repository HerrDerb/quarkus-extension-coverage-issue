package com.example;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class MyBean {

    @Inject
    BadConfig badconfig;
    @Inject
    GoodConfig goodConfig;


    void init(@Observes StartupEvent ev){
        int size = badconfig.nested().size();
    }
    
}
