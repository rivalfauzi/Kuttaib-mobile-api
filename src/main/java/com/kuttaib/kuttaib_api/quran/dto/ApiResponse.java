package com.kuttaib.kuttaib_api.quran.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private Integer code;

    private String message;

    private T data;
}