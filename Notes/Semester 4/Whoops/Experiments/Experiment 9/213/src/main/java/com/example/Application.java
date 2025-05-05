package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Application extends JFrame {
    private JTextField idField, nameField, deptField, salaryField;
    private JButton insertButton, refreshButton;
    private JTable employeeTable;
    private DefaultTableModel tableModel;

    // MariaDB connection details
    private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/OOPS";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234567890";

    public Application() {
        setTitle("Employee Management System (MariaDB)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize database
        initializeDatabase();

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        insertButton = new JButton("Insert Employee");
        refreshButton = new JButton("Refresh Table");

        buttonPanel.add(insertButton);
        buttonPanel.add(refreshButton);

        // Create table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Department");
        tableModel.addColumn("Salary");

        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertEmployee();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshEmployeeTable();
            }
        });

        // Load initial data
        refreshEmployeeTable();
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Create table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "department VARCHAR(50), " +
                    "salary DECIMAL(10, 2))";
            stmt.execute(createTableSQL);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error initializing database: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String department = deptField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(
                         "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)")) {

                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, department);
                pstmt.setDouble(4, salary);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Employee added successfully!");
                    clearFields();
                    refreshEmployeeTable();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID and Salary",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshEmployeeTable() {
        // Clear existing data
        tableModel.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                tableModel.addRow(new Object[]{id, name, department, salary});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading employees: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        // Ensure the MariaDB JDBC driver is loaded
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MariaDB JDBC Driver not found.");
            // e.printStackTrace();
            // return;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Application().setVisible(true);
            }
        });
    }
}
