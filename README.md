# Conn‘s Personal Website

## 数据库

### 建表

```sql
CREATE TABLE `sort_info` (
	`id` BIGINT(40) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL COMMENT '分类名称',
    `number` TINYINT(10) NOT NULL DEFAULT '0' COMMENT '该分类下文章的数量',
    `create_by` DATETIME NOT NULL COMMENT '分类创建时间',
    `modified_by` DATETIME NOT NULL COMMENT '分类修改时间',
    `is_effective` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认为1有效，为0无效',
    PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```

```sql
CREATE TABLE `article_info` (
	`id` BIGINT(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`title` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '文章标题',
	`summary` VARCHAR(300) NOT NULL DEFAULT '' COMMENT '文章简介，默认100个汉字以内',
	`is_top` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '文章是否置顶，0为否，1为是',
	`traffic` INT(10) NOT NULL DEFAULT '0' COMMENT '文章访问量',
	`create_by` DATETIME NOT NULL COMMENT '创建时间',
	`modified_by` DATETIME NOT NULL COMMENT '修改时间',
	PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```

```sql
CREATE TABLE `article_content`(
	`id` BIGINT(40) NOT NULL AUTO_INCREMENT,
	`content` TEXT NOT NULL,
	`article_id` BIGINT(40) NOT NULL COMMENT '对应文章ID',
	`create_by` DATETIME NOT NULL COMMENT '创建时间',
	`modified_by` DATETIME NOT NULL COMMENT '修改时间',
	PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```

```sql
CREATE TABLE `article_sort` (
	`id` BIGINT(40) NOT NULL AUTO_INCREMENT,
	`sort_id` BIGINT(40) NOT NULL COMMENT '分类ID',
	`article_id` BIGINT(40) NOT NULL COMMENT '文章ID',
	`create_by` DATETIME NOT NULL COMMENT '创建时间',
	`modified_by` DATETIME NOT NULL COMMENT '更新时间',
	`is_effective` TINYINT(1) DEFAULT '1' COMMENT '表示当前数据是否有效，默认为1有效，0则无效',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```

