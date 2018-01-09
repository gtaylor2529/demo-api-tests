package stepdefs.spotify;

import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;
import static state.State.response;

public class ResponseStepDefs {

    @Then("^the response status (\\d+) will be returned$")
    public void theResponseStatusWillBeReturned(int statusCode) throws Throwable {
        assertThat(response.getStatus()).isEqualTo(statusCode);
    }
}
