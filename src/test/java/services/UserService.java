package services;

import dto.CreateUserRequest;
import dto.CreateUserResponse;
import dto.UserFull;
import io.restassured.http.Cookies;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends BaseService{

    public UserService(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(CreateUserRequest req){
        return given()
                .spec(REQ_SPEC)
                .body(req)
                .post()
                .as(CreateUserResponse.class);
    }

    public List<UserFull> getUsersWithPage(int page) {
        return given()
                .spec(REQ_SPEC)
                .queryParam("page", page)
                .get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", UserFull.class);
    }

    @Override
    protected String getBasePath() {
        return "/users";
    }

}

