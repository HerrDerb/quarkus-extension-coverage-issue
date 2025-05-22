package com.example;

import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Recorder
@RequiredArgsConstructor
public class ClientRecorder {

    public Function<SyntheticCreationalContext<AdvancedClient>, AdvancedClient> createAdvancedClientWith(String name) {
        return context -> {
            log.info("Creating advanced client for {}", name);
            return (AdvancedClient) context.getInterceptionProxy().create(new AdvancedClient(name));
        };
    }
}
