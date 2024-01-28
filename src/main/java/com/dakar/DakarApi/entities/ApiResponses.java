package com.dakar.DakarApi.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponses<T> {
    private int status;
    private boolean success;
    private String message;
    private T data;
}
