package com.connhowe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDO {

    private Long id;
    private String title;
    private String summary;
    private String content;
    private Integer isTop;
    private Integer visitNumber;
    private Date createdTime;
    private Date modifiedTime;

}
