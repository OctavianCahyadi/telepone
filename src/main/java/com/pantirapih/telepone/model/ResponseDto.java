package com.pantirapih.telepone.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseDto<T> {
    private Boolean status = true;
    private String message;
    private List<String> errorMessage = new ArrayList<>();
    private T payload;
}
