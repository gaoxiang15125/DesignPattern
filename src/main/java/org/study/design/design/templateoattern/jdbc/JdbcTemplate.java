package org.study.design.design.templateoattern.jdbc;

import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.study.design.design.templateoattern.jdbc.mapper.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: design
 * @description: JDBC 模板策略实现
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-29 11:43
 **/
public abstract class JdbcTemplate {
    // 简单的 模板模式实现较为简单，不再编写，直接编写 JDBC 模板实现
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try{
            // 获取链接
            Connection conn = this.getConnection();
            // 创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn, sql);
            // 执行语句集
            ResultSet resultSet = this.executeQuery(pstm, values);
            // 处理结果集
            List<?> result = this.paresResultSet(resultSet, rowMapper);
            // 关闭结果集
            this.closeResultSet(resultSet);
            // 关闭语句集
            this.closeStatement(pstm);
            // 关闭链接
            this.closeConnection(conn);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    protected void closeStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    protected List<?> paresResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while(resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum ++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        for(int i=0;i<values.length;i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }
}
