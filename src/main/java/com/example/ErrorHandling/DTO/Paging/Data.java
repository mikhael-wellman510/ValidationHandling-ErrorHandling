package com.example.ErrorHandling.DTO.Paging;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Data<T> {
    private List<T> content;
    private Pageable pageable;
    private Boolean last;
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
    private Integer number;
    private Boolean first;
    private Integer numberOfElements;
    private Boolean empty;

}
