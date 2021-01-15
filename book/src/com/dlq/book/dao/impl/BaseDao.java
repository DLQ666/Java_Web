package com.dlq.book.dao.impl;

import com.dlq.book.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-14 16:52
 */
public abstract class BaseDao {

    //使用DBUtils 操作数据
    private QueryRunner queryRunner = new QueryRunner();

    //update方法用来执行
    public int update(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        int count = -1;
        try {
            count = queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return count;
    }

    /**
     * 查询返回一个javaBean的sqL语句
     * @param type 返回的对象类型
     * @param sql  执行的sqL语句
     * @param args sqL对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sqL语句
     * @param type 返回的对象类型
     * @param sql  执行的sqL语句
     * @param args sqL对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql 语句
     * @param sql 执行的sql语句
     * @param args SQL对应的参数值
     * @return
     */
    public Object getForSingleValue(String sql, Object... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
