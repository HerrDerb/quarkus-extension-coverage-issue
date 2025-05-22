package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import io.quarkus.test.QuarkusUnitTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class AdvancedClientDefaultTest {

    @RegisterExtension
    static final QuarkusUnitTest config =
            new QuarkusUnitTest().withConfigurationResource("application-default.properties");

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    AdvancedClient advancedClient;

    @Test
    void isDefaultClients_shouldBeDefault() {
        assertThat(advancedClient.getProxiedName()).isEqualTo("test");
        assertThat(advancedClient.getName()).isEqualTo("test");
    }
}
