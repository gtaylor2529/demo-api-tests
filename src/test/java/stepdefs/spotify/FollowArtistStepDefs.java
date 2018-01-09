package stepdefs.spotify;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dtos.responses.GetFollowedArtistResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static params.Params.*;
import static state.State.*;

public class FollowArtistStepDefs {

    @When("^I follow the (.*) with id (.*)$")
    public void iFollowTheArtistWithId(String type, String id) throws Throwable {
        String params = followArtistParams(type, id);
        response = requests.putRequest("/me/following" + params, headers.map(), "");
    }

    @And("^the artist with id (.*) will be returned in my followed artists list$")
    public void theArtistWithIdWillBeReturnedInMyFollowedArtistsList(String id) throws Throwable {
        String params = getFollowedArtistParams();
        response = requests.getRequest("/me/following" + params, headers.map());
        GetFollowedArtistResponse getFollowedArtistResponse = gson.fromJson(response.getBody().toString(),
                GetFollowedArtistResponse.class);
        assertThat(getFollowedArtistResponse.getArtists().getItems().get(0).getId()).isEqualToIgnoringCase(id);
    }

    @When("^I unfollow the artist with id (.*)$")
    public void iUnfollowTheArtistWithId(String id) throws Throwable {

        String params = unfollowArtistParams(id);
        response = requests.deleteRequest("/me/following" + params, headers.map(), "");
    }

    @And("^no artists will be returned in my followed artists list$")
    public void noArtistsWillBeReturnedInMyFollowedArtistsList() throws Throwable {
        String params = getFollowedArtistParams();
        response = requests.getRequest("/me/following" + params, headers.map());
        GetFollowedArtistResponse getFollowedArtistResponse = gson.fromJson(response.getBody().toString(),
                GetFollowedArtistResponse.class);
        assertThat(getFollowedArtistResponse.getArtists().getTotal()).isEqualTo(0);
    }
}
