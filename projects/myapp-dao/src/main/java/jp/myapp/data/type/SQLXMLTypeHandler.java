package jp.myapp.data.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class SQLXMLTypeHandler extends BaseTypeHandler<SQLXML> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SQLXML parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setSQLXML(i, parameter);
    }

    @Override
    public SQLXML getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getSQLXML(columnName);
    }

    @Override
    public SQLXML getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getSQLXML(columnIndex);
    }

    @Override
    public SQLXML getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getSQLXML(columnIndex);
    }
}
