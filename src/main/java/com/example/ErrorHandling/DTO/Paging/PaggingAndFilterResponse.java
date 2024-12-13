package com.example.ErrorHandling.DTO.Paging;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class PaggingAndFilterResponse<T> {
    private Data<T> data;
    private String message;
    private Integer status;
}
