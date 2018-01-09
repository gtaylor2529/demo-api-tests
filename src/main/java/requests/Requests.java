package requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.MultipartBody;
import com.mashape.unirest.request.body.RequestBodyEntity;
import cucumber.api.java.lv.Un;

import java.util.Map;

import static properties.PropertyReader.getProperty;

public class Requests {

    private final String host = getProperty("url");

    public HttpResponse getRequest(String path, Map <String, String> headers) {
        GetRequest request = Unirest.get(host + path)
                .headers(headers);
        requestLogger(request);
        HttpResponse response = null;
        try {
            response = request.asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        responseLogger(response);
        return response;
    }

    public HttpResponse putRequest(String path, Map <String, String> headers, String body) {
        return bodyRequest(Unirest::put, path, headers, body);
    }

    public HttpResponse postRequest(String path, Map <String, String> headers, String body) {
        return bodyRequest(Unirest::post, path, headers, body);
    }

    public HttpResponse deleteRequest(String path, Map <String, String> headers, String body) {
        return bodyRequest(Unirest::delete, path, headers, body);
    }

    public HttpResponse putRequest(String path, Map <String, String> headers, Map <String, Object> fields) {
        return fieldsRequest(Unirest::put, path, headers, fields);
    }

    public HttpResponse postRequest(String path, Map <String, String> headers, Map <String, Object> fields) {
        return fieldsRequest(Unirest::post, path, headers, fields);
    }

    public HttpResponse deleteRequest(String path, Map <String, String> headers, Map <String, Object> fields) {
        return fieldsRequest(Unirest::delete, path, headers, fields);
    }

    private HttpResponse bodyRequest(RequestType requestType, String path, Map <String, String> headers, String body) {
        RequestBodyEntity request = requestType.method(host + path)
                .headers(headers)
                .body(body);
        requestLogger(request);
        HttpResponse response = null;
        try {
            response = request.asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        responseLogger(response);
        return response;
    }

    private HttpResponse fieldsRequest(RequestType requestType, String path, Map <String, String> headers,
                                       Map <String, Object> fields) {
        MultipartBody request = requestType.method(host + path)
                .headers(headers)
                .fields(fields);
        requestLogger(request);
        HttpResponse response = null;
        try {
            response = request.asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        responseLogger(response);
        return response;
    }

    private void requestLogger(BaseRequest request) {
        HttpRequest httpRequest = request.getHttpRequest();
        String requestBody;
        try {
            requestBody = ((RequestBodyEntity) request).getBody().toString();
        } catch (java.lang.ClassCastException e) {
            requestBody = null;
        }
        String log = String.format("\nREQUEST\n-------\nMETHOD: %s\nURL: %s\nHEADERS: %s\nBODY: %s\n",
                httpRequest.getHttpMethod(), httpRequest.getUrl(), httpRequest.getHeaders(), requestBody);
        System.out.println(log);
    }

    private void responseLogger(HttpResponse response) {
        String log = String.format("\nRESPONSE\n-------\nSTATUS_CODE: %d\nSTATUS_TEXT: %s\nHEADERS: %s\nBODY: %s\n",
                response.getStatus(), response.getStatusText(), response.getHeaders(), response.getBody());
        System.out.println(log);
    }

    private interface RequestType {
        HttpRequestWithBody method(String url);
    }
}
