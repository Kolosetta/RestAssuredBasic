package dto;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String name;
    private String job;
    private int id;
    private String createdAt;
}
