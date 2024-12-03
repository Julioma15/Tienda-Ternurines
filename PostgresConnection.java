/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */

public class PostgresConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/inventory";
    private static final String USER = "postgres";
    private static final String PASSWORD = "terraneitor";

    public static List<InventoryItem> fetchData() {
        List<InventoryItem> inventario = new ArrayList<>();
        String sql = "SELECT * FROM inventory ORDER BY item_id ASC";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Conexión exitosa a PostgreSQL");

            while (rs.next()) {
                InventoryItem item = new InventoryItem(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getInt("stock"),
                    rs.getDouble("price"),
                    rs.getString("description"),
                    rs.getString("supplier")
                );
                inventario.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a PostgreSQL: " + e.getMessage());
        }

        return inventario;
    }
    
    public static List<InventoryItem> searchByItemName(String itemName) {
    List<InventoryItem> inventario = new ArrayList<>();
    String sql = "SELECT * FROM inventory WHERE item_name ILIKE ? ORDER BY item_id DESC";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, "%" + itemName + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            InventoryItem item = new InventoryItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("stock"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("supplier")
            );
            inventario.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return inventario;
}
    
    public static List<InventoryItem> searchBySupplier(String supplier) {
    List<InventoryItem> inventario = new ArrayList<>();
    String sql = "SELECT * FROM inventory WHERE supplier ILIKE ? ORDER BY item_id DESC";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, "%" + supplier + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            InventoryItem item = new InventoryItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("stock"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("supplier")
            );
            inventario.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return inventario;
}

public static List<InventoryItem> searchByCategory(String category) {
    List<InventoryItem> inventario = new ArrayList<>();
    String sql = "SELECT * FROM inventory WHERE category ILIKE ? ORDER BY item_id DESC";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, "%" + category + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            InventoryItem item = new InventoryItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("stock"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("supplier")
            );
            inventario.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return inventario;
}

public static List<InventoryItem> searchByItemId(int itemId) {
    List<InventoryItem> inventario = new ArrayList<>();
    String sql = "SELECT * FROM inventory WHERE item_id = ? ORDER BY item_id DESC";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, itemId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            InventoryItem item = new InventoryItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("stock"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getString("supplier")
            );
            inventario.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return inventario;
}

public static void addItem(InventoryItem item) {
    String sql = "INSERT INTO inventory (item_id, item_name, category, stock, price, description, supplier) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, item.getItemId());
        stmt.setString(2, item.getItemName());
        stmt.setString(3, item.getCategory());
        stmt.setInt(4, item.getStock());
        stmt.setDouble(5, item.getPrice());
        stmt.setString(6, item.getDescription());
        stmt.setString(7, item.getSupplier());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void removeItem(int itemId) {
    String sql = "DELETE FROM inventory WHERE item_id = ?";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, itemId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void updateStock(int itemId, int newStock) {
    String sql = "UPDATE inventory SET stock = ? WHERE item_id = ?";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, newStock);
        stmt.setInt(2, itemId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}