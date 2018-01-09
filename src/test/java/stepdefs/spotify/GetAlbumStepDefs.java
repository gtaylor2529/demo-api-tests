package stepdefs.spotify;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtos.responses.GetAlbumResponse;
import static org.assertj.core.api.Assertions.*;

import static properties.PropertyReader.getProperty;
import static state.State.*;

public class GetAlbumStepDefs {

    @When("^I get the album (.*) from Spotify$")
    public void iGetTheAlbumFromSpotify(String albumId) throws Throwable {
        response = requests.getRequest("/albums/" + albumId, headers.map());
    }

    @Then("^the album (.*) will be returned$")
    public void theAlbumWillBeReturned(String albumId) throws Throwable {
        GetAlbumResponse getAlbumResponse = gson.fromJson(response.getBody().toString(), GetAlbumResponse.class);
        assertThat(getAlbumResponse.getId()).isEqualToIgnoringCase(albumId);
        assertThat(getAlbumResponse.getArtists().get(0).getExternal_urls().getSpotify()).isEqualToIgnoringCase(getProperty("artist.spotify.external.url"));
        assertThat(getAlbumResponse.getArtists().get(0).getHref()).isEqualToIgnoringCase(getProperty("artist.href"));
        assertThat(getAlbumResponse.getArtists().get(0).getId()).isEqualToIgnoringCase(getProperty("artist.id"));
        assertThat(getAlbumResponse.getArtists().get(0).getName()).isEqualToIgnoringCase(getProperty("artist.name"));
        assertThat(getAlbumResponse.getArtists().get(0).getType()).isEqualToIgnoringCase(getProperty("artist.type"));
        assertThat(getAlbumResponse.getArtists().get(0).getUri()).isEqualToIgnoringCase(getProperty("artist.uri"));
    }
}
