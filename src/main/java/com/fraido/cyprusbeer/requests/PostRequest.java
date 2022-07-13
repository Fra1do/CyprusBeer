package com.fraido.cyprusbeer.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PostRequest {

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String  description;

    @JsonProperty("user_id")
    int userId;
}