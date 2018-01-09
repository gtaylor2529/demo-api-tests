package params;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Params {

    public static String followArtistParams(String type, String id) {
        List <BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("type", type));
        params.add(new BasicNameValuePair("ids", id));
        return "?" + URLEncodedUtils.format(params, "UTF-8");
    }

    public static String getFollowedArtistParams() {
        List <BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("type", "artist"));
        params.add(new BasicNameValuePair("limit", "20"));
        return "?" + URLEncodedUtils.format(params, "UTF-8");
    }

    public static String unfollowArtistParams(String id) {
        List <BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("type", "artist"));
        params.add(new BasicNameValuePair("ids", id));
        return "?" + URLEncodedUtils.format(params, "UTF-8");
    }
}
