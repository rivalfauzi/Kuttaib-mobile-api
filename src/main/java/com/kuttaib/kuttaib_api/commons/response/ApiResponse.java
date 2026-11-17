package com.kuttaib.kuttaib_api.commons.response;

public record ApiResponse<T>(boolean success, String message, T data) {
    
}