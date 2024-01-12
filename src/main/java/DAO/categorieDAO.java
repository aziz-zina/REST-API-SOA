package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modele.categorie;

public class categorieDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_magasin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public categorieDAO() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createCategorie(categorie cat) {
    	System.out.print(cat.toString());
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO categorie (lib) VALUES (?)")) {
            statement.setString(1, cat.getLib());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<categorie> getAllCategories() {
        List<categorie> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie")) {
            while (resultSet.next()) {
                categorie categorie = new categorie();
                categorie.setCode(resultSet.getInt("id"));
                categorie.setLib(resultSet.getString("lib"));
                categories.add(categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public categorie getCategorieById(int id) {
    	categorie category = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM categorie WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	category = new categorie();
                	category.setCode(resultSet.getInt("id"));
                	category.setLib(resultSet.getString("lib"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public void updateCategorie(categorie categorie) {
    	try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE categorie SET lib = ? WHERE id = ?")) {
               statement.setString(1, categorie.getLib());
               statement.setInt(2, categorie.getCode()); 
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }

    public void deleteCategorie(int id) {
    	try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM categorie WHERE id = ?")) {
               statement.setInt(1, id);
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
}

