package com.example.ErrorHandling.DTO.Paging;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Pageable {
    private Sort sort;
    private Integer offset;
    private Integer pageSize;
    private Integer pageNumber;
    private Boolean paged;
    private Boolean unpaged;



//    private String
}
