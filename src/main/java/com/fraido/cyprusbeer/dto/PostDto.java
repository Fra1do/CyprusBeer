package com.fraido.cyprusbeer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PostDto {
    @JsonProperty("id")
    int id;

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String  description;

    @JsonProperty("user_id")
    int userId;
}
