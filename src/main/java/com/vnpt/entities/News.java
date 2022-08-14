package com.vnpt.entities;

import lombok.*;

import java.time.LocalDate;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private Integer id;
    private String title;
    private Integer status;
    private String content;
    private Integer newsType;
    private Integer keyword;
    private String description;
    private Integer fillerType;
    private String image;
    private String author;
    private LocalDate createDate;
    private Integer categoryId;

}
