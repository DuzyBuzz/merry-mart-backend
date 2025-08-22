package com.accounting_system.merry_mart.repository;

import com.accounting_system.merry_mart.model.Users;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UsersRepo {

    private final DataSource dataSource;

    public UsersRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // ------------------ CREATE ------------------
    public void createUser(Users user) {
        String sql = "INSERT INTO users (user_id, first_name, last_name, position, user_name, password, role) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, UUID.randomUUID().toString()); // Generate UUID for new user
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getPosition());
            stmt.setString(5, user.getUserName());
            stmt.setString(6, user.getPassword()); // Hash in real app
            stmt.setString(7, user.getRole());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------ READ ------------------

    // Find all users
    public List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usersList.add(mapResultSetToUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    // Find user by ID
    public Users findById(UUID id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Find by username and password (login)
    public Users findByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userName);
            stmt.setString(2, password); // Hash in real app

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ------------------ UPDATE ------------------
    public void update(Users user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, position = ?, user_name = ?, password = ?, role = ? " +
                "WHERE user_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getPosition());
            stmt.setString(4, user.getUserName());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRole());
            stmt.setString(7, user.getUserId().toString());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------ DELETE ------------------
    public boolean deleteById(UUID id) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ------------------ UTILITY ------------------
    private Users mapResultSetToUser(ResultSet rs) throws SQLException {
        return new Users(
                UUID.fromString(rs.getString("user_id")),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("position"),
                rs.getString("user_name"),
                rs.getString("password"),
                rs.getString("role")
        );
    }
}
