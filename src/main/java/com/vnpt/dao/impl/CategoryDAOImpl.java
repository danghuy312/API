package com.vnpt.dao.impl;

import com.vnpt.dao.CategoryDAO;
import com.vnpt.factory.SQLConnectionFactory;
import com.vnpt.model.response.InfoCategory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Repository
public class CategoryDAOImpl extends AbstractDAO implements CategoryDAO {
    @Override
    public List<InfoCategory> findById(Integer categoryId) throws Exception {
        List<InfoCategory> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = SQLConnectionFactory.getInstance().getSQLConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT C.id, C.name, N.image");
            sql.append(" FROM dbo.Category C");
            sql.append(" INNER JOIN dbo.News N");
            sql.append("    ON C.id = N.category_id");
            if (categoryId != null) {
                sql.append(" WHERE C.id = ?");
            }
            statement = connection.prepareStatement(sql.toString());
            if (categoryId != null) {
                statement.setInt(1, categoryId);
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InfoCategory result = InfoCategory.builder()
                        .categoryId(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .image(resultSet.getString("image"))
                        .build();
                resultList.add(result);
            }
        } catch (Exception e) {
            eLogger.error("Error ItemDAO.findAll item: {}", e.getMessage());
            if (connection != null) {
                connection.rollback();
            }
        } finally {
            releaseResource(connection, statement, resultSet);
        }
        return resultList;
    }
}
