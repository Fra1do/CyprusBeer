package com.fraido.cyprusbeer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
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
