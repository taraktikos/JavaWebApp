package main.dao;

import main.db.Database;
import main.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDao {

    private Connection connection;

    public CountryDao() {
        connection = Database.getConnection();
    }

    public Map<String, String> validate(Country country) {
        Map<String, String> errors = new HashMap<>();
        if (country.getName() == null || country.getName().isEmpty()) {
            errors.put("name", "Name can't be empty");
        } else if (getByNameCode(country.getName(), country.getCode()).getId() > 0 &&
                getByNameCode(country.getName(), country.getCode()).getId() != country.getId()) {
            errors.put("name", "Name and code must be unique");
        }
        if (country.getCode() == null || country.getCode().isEmpty()) {
            errors.put("code", "Code can't be empty");
        } else if (country.getCode().length() > 2) {
            errors.put("code", "Code too long (allow 2 characters)");
        }
        if (country.getLongCode() == null || country.getLongCode().isEmpty()) {
            errors.put("longCode", "Long code can't be empty");
        } else if (country.getLongCode().length() > 3) {
            errors.put("longCode", "Long code too long (allow 3 characters)");
        } else if (getByLongCode(country.getLongCode()).getId() > 0 &&
                getByLongCode(country.getLongCode()).getId() != country.getId()) {
            errors.put("longCode", "Long code must be unique");
        }
        return errors;
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
        return getAll(null, null);
    }

    public List<Country> getAll(String name, String code) {
        if (name != null && name.isEmpty()) {
            name = null;
        }
        if (code != null && code.isEmpty()) {
            code = null;
        }
        List<Country> countries = new ArrayList<>();
        try {
            String query = "SELECT * FROM country";
            if (name != null || code != null) {
                query += " WHERE ";
            }
            if (name != null && code != null) {
                query += "name LIKE ? and code LIKE ?";
            } else if (name != null) {
                query += "name LIKE ?";
            } else if (code != null) {
                query += "code LIKE ?";
            }
            PreparedStatement ps = connection.prepareStatement(query);
            if (name != null && code != null) {
                ps.setString(1, name + "%");
                ps.setString(2, code + "%");
            } else if (name != null) {
                ps.setString(1, name + "%");
            } else if (code != null) {
                ps.setString(1, code + "%");
            }
            ResultSet rs = ps.executeQuery();
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

    public Country getByLongCode(String longCode) {
        Country country = new Country();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM country where long_code=?");
            preparedStatement.setString(1, longCode);
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

    public Country getByNameCode(String name, String code) {
        Country country = new Country();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM country where name=? and code=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, code);
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
