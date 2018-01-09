package state;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import requests.Headers;
import requests.Requests;

public class State {

    public static Headers headers = new Headers();
    public static Requests requests = new Requests();
    public static HttpResponse response;
    public static Gson gson = new Gson();
}
