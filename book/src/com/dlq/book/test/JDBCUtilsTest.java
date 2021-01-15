package com.dlq.book.test;

import com.dlq.book.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-14 16:46
 */
public class JDBCUtilsTest {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);

            JDBCUtils.close(connection);
        }
    }
}
