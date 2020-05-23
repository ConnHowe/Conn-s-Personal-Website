package com.connhowe.mapper;

import com.connhowe.entity.SortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Collection;
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
    void update(@Param("id") Long id, @Param("name") String name, @Param("isEffective") Integer isEffective, @Param("modifiedBy") Date modifiedBy);
}
