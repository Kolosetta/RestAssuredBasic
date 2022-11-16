import dto.CreateUserRequest;
import dto.CreateUserResponse;
import dto.UserFull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;



public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepare(){
        api = RestWrapper.loginAs("eve.holt@reqres.in","cityslicka");
    }

    @Test
    public void getUsers(){
        //Ассертим, что лист юзеров содержит элемент с полем email george.bluth@reqres.in"
        assertThat(api.userService.getUsers()).extracting(UserFull::getEmail).contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser(){
        CreateUserRequest request = UserGenerator.getSimpleUserReq();
        CreateUserResponse response = api.userService.createUser(request);

        assertThat(response)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(request.getName());
    }
}

 /*List<UserFull> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", UserFull.class);*/