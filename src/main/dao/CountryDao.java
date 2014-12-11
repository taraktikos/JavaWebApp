package main.dao;

import main.db.Database;
import main.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

    private Connection connection;

    public CountryDao() {
        connection = Database.getConnection();
    }

    public void add(Country country) {
        try {
            String query = "INSERT INTO country (name, code, long_code) values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getName());
            ps.setString(2, country.getCode());
            ps.setString(3, country.getLongCode());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating region fail, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String query = "DELETE FROM country WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Country country) {
        try {
            String query = "UPDATE country SET name=?, code=?, long_code=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getName());
            ps.setString(2, country.getCode());
            ps.setString(3, country.getLongCode());
            ps.setInt(4, country.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM country");
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setLongCode(rs.getString("long_code"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public Country getById(int id) {
        Country country = new Country();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM country where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setLongCode(rs.getString("long_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

}
