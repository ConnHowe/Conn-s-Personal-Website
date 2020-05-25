package com.connhowe.mapper;

import com.connhowe.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleInfoMapper {

    @Select(("select * from article_info"))
    List<ArticleInfo> getArticleInfos();
}
