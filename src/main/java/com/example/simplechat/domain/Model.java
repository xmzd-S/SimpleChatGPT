package com.example.simplechat.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Model implements Serializable {

    private String id;
    private String object;
    private long created;
    @JsonProperty("owned_by")
    private String ownedBy;
    @JsonProperty("permission")
    private List<Permission> permission;
    private String root;
    private Object parent;
}