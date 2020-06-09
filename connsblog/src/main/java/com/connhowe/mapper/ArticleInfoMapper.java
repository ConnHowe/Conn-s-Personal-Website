package com.connhowe.mapper;

import com.connhowe.entity.ArticleInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleInfoMapper {

    @Select("select * from article_info")
    List<ArticleInfo> getArticleInfos();

    @Insert("insert into article_info(title, summary, filename, is_top, create_by, modified_by) values (#{title}, #{summary}, #{filename}, #{isTop}, #{createBy}, #{modifiedBy})")
    void addArticle(ArticleInfo articleInfo);

    @Select("select * from article_info where id=#{id}")
    ArticleInfo getArticleInfoById(@Param("id") Long id);

    @Update("update article_info set title=#{title}, summary=#{summary}, filename=#{filename}, is_top=#{isTop}, modified_by=#{modifiedBy} where id=#{id}")
    void updateArticle(ArticleInfo articleInfo);

    @Delete("delete from article_info where id=#{id}")
    void deleteArticleById(@Param("id") Long id);
}
