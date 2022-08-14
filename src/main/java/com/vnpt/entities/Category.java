package com.vnpt.entities;

import lombok.*;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Integer id;
    private String name;
    private Integer status;
    private String description;

}
