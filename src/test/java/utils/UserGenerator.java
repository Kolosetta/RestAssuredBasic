package utils;

import dto.CreateUserRequest;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static CreateUserRequest getSimpleUserReq(){
        return CreateUserRequest.builder()
                .name(RandomStringUtils.randomAlphabetic(10))
                .job(RandomStringUtils.randomAlphabetic(10))
                .build();
    }
}
