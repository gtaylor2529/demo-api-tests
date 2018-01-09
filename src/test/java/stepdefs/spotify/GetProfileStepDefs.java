package stepdefs.spotify;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtos.responses.GetProfileResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static properties.PropertyReader.getProperty;
import static state.State.*;

public class GetProfileStepDefs {

    @When("^I get profile$")
    public void iGetProfile() throws Throwable {
        response = requests.getRequest("/me", headers.map());
    }

    @Then("^the profile will be returned$")
    public void theProfileWillBeReturned() throws Throwable {
        GetProfileResponse getProfileResponse = gson.fromJson(response.getBody().toString(), GetProfileResponse.class);
        assertThat(getProfileResponse.getBirthdate()).isEqualToIgnoringCase(getProperty("profile.birthdate"));
        assertThat(getProfileResponse.getCountry()).isEqualToIgnoringCase("GB");
        assertThat(getProfileResponse.getDisplayName()).isNullOrEmpty();
        assertThat(getProfileResponse.getEmail()).isEqualToIgnoringCase(getProperty("profile.email"));
        assertThat(getProfileResponse.getExternalUrls().getSpotify()).isEqualToIgnoringCase(getProperty("profile.spotify.external.url"));
        assertThat(getProfileResponse.getFollowers().getHref()).isNullOrEmpty();
        assertThat(getProfileResponse.getFollowers().getTotal()).isEqualTo(1);
        assertThat(getProfileResponse.getHref()).isEqualToIgnoringCase(getProperty("profile.href"));
        assertThat(getProfileResponse.getId()).isEqualToIgnoringCase(getProperty("profile.id"));
        assertThat(getProfileResponse.getImages()).isEmpty();
        assertThat(getProfileResponse.getProduct()).isEqualToIgnoringCase("premium");
        assertThat(getProfileResponse.getType()).isEqualToIgnoringCase("user");
        assertThat(getProfileResponse.getUri()).isEqualToIgnoringCase(getProperty("profile.uri"));
    }
}
