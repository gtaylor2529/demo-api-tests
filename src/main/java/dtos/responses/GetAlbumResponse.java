package dtos.responses;

import java.util.List;

public class GetAlbumResponse {

    private List<ArtistsArray> artists;
    private String id;

    public List<ArtistsArray> getArtists() {
        return artists;
    }

    public String getId() {
        return id;
    }

    public class ArtistsArray {

        private ExternalUrlsBlock external_urls;
        private String href;
        private String id;
        private String name;
        private String type;
        private String uri;

        public ExternalUrlsBlock getExternal_urls() {
            return external_urls;
        }

        public String getHref() {
            return href;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getUri() {
            return uri;
        }

        public class ExternalUrlsBlock {

            private String spotify;

            public String getSpotify() {
                return spotify;
            }
        }
    }
}
