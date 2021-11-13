package com.connhowe.mapper;

import com.connhowe.entity.SortDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分类Mapper
 */
@Mapper
@Repository
public interface SortMapper {
    @Select("select * from sort")
    List<SortDO> getSortInfos();

    @Select("select * from sort where id=#{id}")
    SortDO getSortInfoById(@Param("id") Long id);

    @Update("update sort set name=#{name}, modified_time=#{modifiedTime}, is_effective=#{isEffective} where id=#{id}")
    void update(SortDO sortDO);

    @Delete("delete from sort where id=#{id}")
    void delSortById(@Param("id") Long id);

    @Insert("insert into sort(name, article_number, created_time, modified_time, is_effective) values (#{name}, #{articleNumber}, #{createdTime}, #{modifiedTime}, #{isEffective})")
    void addSort(SortDO sortDO);
}
