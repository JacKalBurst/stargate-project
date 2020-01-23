package org.stargate.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Timeout;
import org.stargate.Stargate;

import static org.assertj.core.api.Assertions.assertThat;

@Timeout(1)
public class StargateSteps {

    private Stargate stargate;
    private TestThread testThread;

    @Given("un développeur qui utilise une stargate pour se connecter à une autre stargate")
    public void a_developer_who_uses_a_stargate_to_connect_to_another_stargate() {
        stargate = new Stargate("stargateR");
        testThread = new TestThread("stargateT");
        testThread.connect("stargateR");
    }

    @When("{int} est transmis à travers la stargate")
    public void is_transmitted_through_the_stargate(int argument) {
        testThread.setArgument(argument);
        testThread.start();
    }

    @Then("on récupère {int} à travers l'autre stargate")
    public void we_get_through_the_other_stargate(int expectedResult) {
        int currentInteger = stargate.getAnInteger();
        assertThat(currentInteger).isEqualTo(expectedResult);
    }


    class TestThread extends Thread implements Runnable {

        private Stargate stargate;
        private int argument;

        public TestThread(String gateCoordinates) {
            stargate = new Stargate(gateCoordinates);
        }

        public void connect(String gateCoordinates) {
            stargate.connectTo(gateCoordinates);
        }

        public void setArgument(int argument) {
            this.argument = argument;
        }

        @Override
        public void run() {
            try {
                sleep(500);
                stargate.passAnInteger(argument);
                stargate.disconnect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
