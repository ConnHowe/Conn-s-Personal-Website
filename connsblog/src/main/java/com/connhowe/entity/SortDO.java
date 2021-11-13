package com.connhowe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortDO {
    private Long id;

    private String name;

    private Integer articleNumber;

    private Date createdTime;

    private Date modifiedTime;

    private Integer isEffective;
}
