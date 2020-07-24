package com.mycrm.tools;

import java.sql.ResultSet;
import java.sql.SQLException;

//泛型接口
public interface RowMapper<T> {
    public <T> T makeBean(ResultSet rs) throws SQLException;

}

