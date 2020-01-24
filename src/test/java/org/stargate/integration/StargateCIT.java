package org.stargate.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.stargate.Stargate;

import java.io.PipedInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test d'intégration des Stargates")
public class StargateCIT {

    private Stargate stargateT;
    private Stargate stargateR;

    @BeforeEach
    public void init_stargate() {
        this.stargateT = new Stargate("stargateT");
        this.stargateR = new Stargate("stargateR");
    }

    @Test
    @DisplayName("Soit une Stargate, lorsque elle se connecte à une autre Stargate, alors on obtient vrai.")
    public void stargate_shouldConnectToAStargate_accordingToTheCoordinatesEntered() {
        // Given
        // ...

        // When
        PipedInputStream outputOfTheVortex = stargateT.accessToTheGatesNetwork("stargateR");
        boolean hasConnected = stargateT.pipedConnectionWith(outputOfTheVortex);

        // Then
        assertThat(hasConnected).isTrue();
    }
}
