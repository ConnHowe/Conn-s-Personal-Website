package com.connhowe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortInfo {

    private Long id;
    private String name;
    private Integer number;
    private Date createBy;
    private Date modifiedBy;
    private Integer isEffective;

}
