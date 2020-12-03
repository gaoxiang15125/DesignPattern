package org.study.design.design.templateoattern.jdbc.mapper;

import java.sql.ResultSet;

/**
 * @program: design
 * @description: 按行读取数据库接口
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-29 11:46
 **/
public interface RowMapper<T> {

    T mapRow(ResultSet resultSet, int rowNum) throws Exception;
}
