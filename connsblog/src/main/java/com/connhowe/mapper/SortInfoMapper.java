package com.connhowe.mapper;

import com.connhowe.entity.SortInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 分类信息Mapper
 */
@Mapper
@Repository
public interface SortInfoMapper {

    @Select("select * from sort_info")
    List<SortInfo> getSortInfos();

    @Select("select * from sort_info where id=#{id}")
    SortInfo getSortInfoById(@Param("id") Long id);

    @Update("update sort_info set name=#{name}, modified_by=#{modifiedBy}, is_effective=#{isEffective} where id=#{id}")
    void update(SortInfo sortInfo);

    @Delete("delete from sort_info where id=#{id}")
    void delSortById(@Param("id") Long id);

    @Insert("insert into sort_info(name, number, create_by, modified_by, is_effective) values (#{name}, #{number}, #{createBy}, #{modifiedBy}, #{isEffective})")
    void addSort(SortInfo sortInfo);
}
