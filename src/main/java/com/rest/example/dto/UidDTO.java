package com.rest.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UidDTO {
    public void setUid(long uid) {
        this.uid = uid;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long uid;
}
