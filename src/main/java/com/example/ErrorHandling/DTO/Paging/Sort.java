package com.example.ErrorHandling.DTO.Paging;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Sort {
    private Boolean empty;
    private Boolean sorted;
    private Boolean unsorted;
}
