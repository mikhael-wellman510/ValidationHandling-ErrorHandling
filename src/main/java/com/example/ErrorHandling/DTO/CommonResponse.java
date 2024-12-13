package com.example.ErrorHandling.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class CommonResponse<T> {
    private T data;
    private String message;
    private Integer Status;


}
