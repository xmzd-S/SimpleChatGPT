package com.example.simplechat.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ModelResponse implements Serializable {
    private String object;
    private List<Model> data;
}