package com.connhowe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleInfo {

    private Long id;
    private String title;
    private String summary;
    private Long sortId;
    private String sortName;
    private String filename;
    private Integer isTop;
    private Integer traffic;
    private Date createBy;
    private Date modifiedBy;

}
