package utils;

import dto.UserLoginRequest;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import services.OrderService;
import services.UserService;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/api";
    private Cookies cookies;

    public UserService userService;
    public OrderService orderService;

    private RestWrapper(Cookies cookies){
        this.cookies = cookies;
        userService = new UserService(cookies);
        orderService = new OrderService(cookies);
    }

    public static RestWrapper loginAs(String login, String password){
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLoginRequest(login, password))
                .post()
                .getDetailedCookies();
        return new RestWrapper(cookies);
    }

}
