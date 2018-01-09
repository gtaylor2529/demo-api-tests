package dtos.responses;

import java.util.List;

public class GetFollowedArtistResponse {

    private ArtistsBlock artists;

    public ArtistsBlock getArtists() {
        return artists;
    }

    public class ArtistsBlock {

        private CursorBlock cursor;
        private List<ItemsBlock> items;
        private String next;
        private int total;
        private int limit;
        private String href;

        public CursorBlock getCursor() {
            return cursor;
        }

        public List<ItemsBlock> getItems() {
            return items;
        }

        public String getNext() {
            return next;
        }

        public int getTotal() {
            return total;
        }

        public int getLimit() {
            return limit;
        }

        public String getHref() {
            return href;
        }

        public class CursorBlock {

            private String after;

            public String getAfter() {
                return after;
            }
        }

        public class ItemsBlock {

            private String id;

            public String getId() {
                return id;
            }
        }
    }
}
