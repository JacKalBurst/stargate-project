package org.stargate.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.stargate.Stargate;

public class StargateTest {


    private Stargate stargate;

    @BeforeEach
    public void init_stargate() {
        this.stargate = new Stargate("stargate");
    }

    @Test
    @DisplayName("Renvoi la sortie du vortex en accedent au réseau des Stargates via les coordonnées de la portes.")
    public void accessAtTheGatesNetwork_shouldReturnTheVortexOutput_accordingToTheCoordinatesOfTheGate() {
        // Given
        // ...

        // When

        // Then
    }
}
