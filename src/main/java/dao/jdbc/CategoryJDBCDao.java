package dao.jdbc;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.enums.CategoryName;
import org.apache.log4j.Logger;
import util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryJDBCDao implements CategoryDao {

    private static final String SELECT_BY_SHOP_ID = "SELECT * FROM category WHERE store_id = ?";
    private static final Logger logger = Logger.getLogger(CategoryJDBCDao.class);

    @Override
    public List<Category> getByStoreId(int id) {
        ProductDao productDao = new ProductJDBCDao();
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DBConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_SHOP_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(CategoryName.fromString(rs.getString("category_title")));
                category.setStoreId(rs.getInt("store_id"));
                category.setProducts(productDao.getByCategoriesId(rs.getInt("id")));
                categories.add(category);
            }
        } catch (SQLException e) {
            logger.error("The store with id=" + id + " is not found.", e);
        }
        return categories;
    }

}
