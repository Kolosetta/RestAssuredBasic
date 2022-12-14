package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {
    protected Cookies cookies;
    protected RequestSpecification REQ_SPEC;
    private static final String BASE_URL = "https://reqres.in/api";

    public BaseService(Cookies cookies) {
        this.cookies = cookies;
        REQ_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }

    protected abstract String getBasePath();
}
