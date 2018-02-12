/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.webapp.dao.impl;

import com.akhilesh.webapp.dao.CustomerDAO;
import com.akhilesh.webapp.entity.Customer;
import com.akhilesh.webapp.utils.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public class CustomerDAOImpl implements CustomerDAO {

    private DbConnection db = new DbConnection();

    @Override
    public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        db.connect();
        db.initStatment(sql);
        ResultSet rs = db.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String contact = rs.getString("contact");
            boolean status = rs.getBoolean("status");

            Customer customer = new Customer();
            customer.setId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setContact(contact);
            customer.setStatus(status);

            customers.add(customer);

        }

        return customers;
    }

    @Override
    public int insert(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customers(first_name,last_name,email,contact,status) values(?,?,?,?,?);";
        db.connect();
        PreparedStatement stmt = db.initStatment(sql);
        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getContact());
        stmt.setBoolean(5, customer.isStatus());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE customers SET first_name = ?, last_name =?, email=?, contact=?, status=? WHERE id = ?;";
        db.connect();
        PreparedStatement stmt = db.initStatment(sql);
        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getContact());
        stmt.setBoolean(5, customer.isStatus());
        stmt.setInt(6, customer.getId());
        System.out.println("implt"+customer.getId());
        int result = db.executeUpdate();
        System.out.println("UPDATE RESULT "+ result);
        db.close();
        return result;
    }

    @Override
    public int delete(int customerId) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM customers WHERE ID=?;";
        db.connect();
        PreparedStatement stmt = db.initStatment(sql);
        stmt.setInt(1, customerId);
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public Customer getByCustomerId(int customerId) throws ClassNotFoundException, SQLException {
        Customer customer = new Customer();
        String sql = "SELECT * FROM customers where id =?;";
        db.connect();
        PreparedStatement stmt = db.initStatment(sql);
        stmt.setInt(1, customerId);
        ResultSet rs = db.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String contact = rs.getString("contact");
            boolean status = rs.getBoolean("status");

            customer.setId(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setContact(contact);
            customer.setStatus(status);
        }
        db.close();
        return customer;
    }

}
