package com.example;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@Slf4j
public class AdvancedClient extends BaseClient {

    AdvancedClient() {
        super(null);
        log.info("Initializing AdvancedClient with noArgs constructor");
    }

    public AdvancedClient(String name) {
        super(name);
        log.info("Initializing AdvancedClient with name {}", name);
    }

    @Retry
    public String getProxiedName() {
        return getName();
    }

    // ... much more incredible and complex logic that justifies the need for this class
    // A SQL query walks into a bar, walks up to two tables and asks:
    // "Can I join you?"
}
