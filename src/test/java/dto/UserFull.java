package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserFull {
    private int id;
    private String avatar;
    @JsonProperty("first_name") //Задает имя в json, который парсим
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
}
