package com.fraido.cyprusbeer.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRequest {

    @JsonProperty("username")
    String username;

}