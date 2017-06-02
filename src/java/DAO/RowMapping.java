package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;

public interface RowMapping<T> {
    T mapeamento(ResultSet rs) throws SQLException, ServletException;
}
