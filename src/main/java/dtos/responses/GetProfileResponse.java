package dtos.responses;

import java.util.List;

public class GetProfileResponse {

    private String birthdate;
    private String country;
    private String display_name;
    private String email;
    private ExternalUrls external_urls;
    private Followers followers;
    private String href;
    private String id;
    private List<String> images;
    private String product;
    private String type;
    private String uri;

    public String getBirthdate() {
        return birthdate;
    }

    public String getCountry() {
        return country;
    }

    public String getDisplayName() {
        return display_name;
    }

    public String getEmail() {
        return email;
    }

    public ExternalUrls getExternalUrls() {
        return external_urls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public List<String> getImages() {
        return images;
    }

    public String getProduct() {
        return product;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public class ExternalUrls {

        private String spotify;

        public String getSpotify() {
            return spotify;
        }
    }

    public class Followers {

        private String href;
        private int total;

        public String getHref() {
            return href;
        }

        public int getTotal() {
            return total;
        }
    }
}
