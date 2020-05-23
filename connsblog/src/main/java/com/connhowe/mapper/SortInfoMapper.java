package com.connhowe.mapper;

import com.connhowe.entity.SortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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
}
