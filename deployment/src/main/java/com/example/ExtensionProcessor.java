package com.example;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

public class ExtensionProcessor {

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem("example");
    }

    @BuildStep
    void addBaseBeans(BuildProducer<AdditionalBeanBuildItem> beanProducer) {
        beanProducer.produce(AdditionalBeanBuildItem.builder()
                .addBeanClass(MyBean.class)
                .build());
    }

}
