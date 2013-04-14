package jp.myapp.dao.util;

import java.sql.SQLException;
import java.sql.SQLXML;

import javax.annotation.Resource;
import javax.sql.DataSource;

import jp.myapp.exception.SystemException;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeFactoryImpl implements TypeFactory {

    @Resource
    private DataSource dataSource;

    @Override
    @Transactional
    public SQLXML createSQLXML() {
        try {
            return DataSourceUtils.getConnection(this.dataSource).createSQLXML();
        } catch (SQLException e) {
            throw new SystemException(e);
        }
    }
}
