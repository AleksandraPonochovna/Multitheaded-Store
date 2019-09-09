package dao.jdbc;

import dao.CategoryDao;
import dao.StoreDao;
import model.Store;
import org.apache.log4j.Logger;
import util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreJDBCDao implements StoreDao {

    private static final String SELECT_BY_ID = "SELECT * FROM store WHERE id = ?";
    private static final Logger logger = Logger.getLogger(StoreJDBCDao.class);

    @Override
    public Store read(Store store) {
        CategoryDao categoryDao = new CategoryJDBCDao();
        try (Connection connection = DBConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, store.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                store.setId(resultSet.getInt(1));
                store.setTitle(resultSet.getString(1));
            }
            store.setCategories(categoryDao.getByStoreId(store.getId()));
        } catch (SQLException ex) {
            logger.error("The store can't be readed", ex);
        }
        return store;
    }

}
