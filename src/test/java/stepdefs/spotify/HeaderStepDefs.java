package stepdefs.spotify;

import cucumber.api.java.en.Given;
import requests.Headers;

import static properties.PropertyReader.getProperty;
import static state.State.headers;

public class HeaderStepDefs {

    @Given("^I have valid auth$")
    public void iHaveValidAuth() throws Throwable {
        headers.addHeader(Headers.Header.AUTH, getProperty("auth.token"));
    }

    @Given("^I have invalid auth$")
    public void iHaveInvalidAuth() throws Throwable {
        headers.addHeader(Headers.Header.AUTH, "Bearer invalid auth");
    }
}
