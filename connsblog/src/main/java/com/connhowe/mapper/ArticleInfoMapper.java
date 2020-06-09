package com.connhowe.mapper;

import com.connhowe.entity.ArticleInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleInfoMapper {

    @Select("select * from article_info")
    List<ArticleInfo> getArticleInfos();

    @Insert("insert into article_info(title, summary, filename, create_by, modified_by) values (#{title}, #{summary}, #{filename}, #{createBy}, #{modifiedBy})")
    void addArticle(ArticleInfo articleInfo);
}
