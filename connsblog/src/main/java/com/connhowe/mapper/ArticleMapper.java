package com.connhowe.mapper;

import com.connhowe.entity.ArticleDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章Mapper
 */
@Mapper
@Repository
public interface ArticleMapper {
    @Select("select * from article")
    List<ArticleDO> getArticleInfos();

    @Insert("insert into article(title, summary, content, is_top, created_time, modified_time) values (#{title}, #{summary}, #{content}, #{isTop}, #{createdTime}, #{modifiedTime})")
    void addArticle(ArticleDO articleDO);

    @Select("select * from article where id=#{id}")
    ArticleDO getArticleInfoById(@Param("id") Long id);

    @Update("update article set title=#{title}, summary=#{summary}, content=#{content}, is_top=#{isTop}, modified_time=#{modifiedTime} where id=#{id}")
    void updateArticle(ArticleDO articleDO);

    @Delete("delete from article where id=#{id}")
    void deleteArticleById(@Param("id") Long id);
}
