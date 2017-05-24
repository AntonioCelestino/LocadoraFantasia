package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapping<T> {
    T mapeamento(ResultSet rs) throws SQLException;
}
