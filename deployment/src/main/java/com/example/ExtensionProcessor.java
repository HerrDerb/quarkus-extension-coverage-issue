package com.example;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtensionProcessor {

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem("example");
    }

    @BuildStep
    @Record(RUNTIME_INIT)
    public void registerClients(BuildProducer<SyntheticBeanBuildItem> syntheticBeans, ClientRecorder recorder) {

        log.info("Registering Azure FileShare Client");
        syntheticBeans.produce(SyntheticBeanBuildItem.configure(AdvancedClient.class)
                .scope(ApplicationScoped.class)
                .setRuntimeInit()
                .injectInterceptionProxy()
                .createWith(recorder.createAdvancedClientWith("test"))
                .done());
    }
}
