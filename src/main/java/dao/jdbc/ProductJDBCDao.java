package dao.jdbc;

import dao.ProductDao;
import model.Product;
import model.enums.Status;
import org.apache.log4j.Logger;
import util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDao implements ProductDao {

    private static final String INSERT = "INSERT INTO product (id, products_title, price, " +
            "status, category_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE product SET products_title=?, " +
            "price = ?, status=?, category_id=? WHERE id=?";
    private static final String SELECT_BY_CATEGORY_ID = "SELECT * FROM product WHERE " +
            "category_id = ?";
    private static final Logger logger = Logger.getLogger(ProductJDBCDao.class);

    @Override
    public void create(Product product) {
        try (Connection connection = DBConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setString(4, String.valueOf(product.getStatus()));
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.executeUpdate();
            logger.info(product + " was created.");
        } catch (SQLException e) {
            logger.error(product + " can't be created.", e);
        }
    }

    @Override
    public void update(Product product) {
        try (Connection connection = DBConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, String.valueOf(product.getStatus()));
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
            logger.info(product + " was updated.");
        } catch (SQLException e) {
            logger.error(product + " can't be updated.", e);
        }
    }

    @Override
    public List<Product> getByCategoriesId(int id) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CATEGORY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setTitle(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setStatus(Status.fromString(resultSet.getString(4)));
                product.setCategoryId(resultSet.getInt(5));
                products.add(product);
            }
            logger.info("Category with id=" + id + " was founded in DB.");
        } catch (SQLException e) {
            logger.error("Category with id=" + id + " can't be founded in DB.", e);
        }
        return products;
    }

}
