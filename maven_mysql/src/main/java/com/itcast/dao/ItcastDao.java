package com.itcast.dao;

import com.itcast.domain.itcast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ItcastDao {
    public List<itcast> findAll() throws IOException, SQLException, ClassNotFoundException;
}
