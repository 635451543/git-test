package com.itcast.impl;

import com.itcast.dao.ItcastDao;
import com.itcast.domain.itcast;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ItcastDaoImpl implements ItcastDao{
    public List<itcast> findAll() throws IOException, ClassNotFoundException, SQLException {
        //加载驱动累
        Class.forName("com.mysql.jdbc.Driver");
        //先获取connction对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://maven");
        //获取真正操作数据库对象
        PreparedStatement pst = connection.prepareCall("select * from itcast");
        //执行数据库查询操作
        ResultSet resultSet = pst.executeQuery();
        //把数据库结果集转化成java的List集合

        return null;
    }
}
