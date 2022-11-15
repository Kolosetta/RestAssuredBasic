import dto.CreateUserRequest;
import dto.CreateUserResponse;
import dto.UserFull;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.UsersSteps;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepare(){
        api = RestWrapper.loginAs("eve.holt@reqres.in","cityslicka");
    }

    @Test
    public void getUsers(){
        List<UserFull> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", UserFull.class);

        //Ассертим, что лист юзеров содержит элемент с полем email george.bluth@reqres.in"
        assertThat(users).extracting(UserFull::getEmail).contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser(){
        CreateUserRequest request = UserGenerator.getSimpleUserReq();
        UsersSteps userApi = new UsersSteps();
        CreateUserResponse response = userApi.createUser(request);

        assertThat(response)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(request.getName());

         /* CreateUserResponse response = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(request)
                .when().post()
                .then().extract().as(CreateUserResponse.class);*/
    }
}
