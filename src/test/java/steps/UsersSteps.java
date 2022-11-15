package steps;

import dto.CreateUserRequest;
import dto.CreateUserResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UsersSteps {

    private CreateUserResponse user;
    public CreateUserResponse createUser(CreateUserRequest req){
        user = given()
                .spec(REQ_SPEC)
                .body(req)
                .post()
                .as(CreateUserResponse.class);
        return user;
    }


    static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();
}
