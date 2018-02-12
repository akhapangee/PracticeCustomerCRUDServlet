/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.webapp.dao;

import com.akhilesh.webapp.entity.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public interface CustomerDAO {
    List<Customer> getAllCustomers()throws ClassNotFoundException,SQLException;
    int insert(Customer customer) throws ClassNotFoundException,SQLException;
    int update(Customer customer) throws ClassNotFoundException,SQLException;
    int delete(int customerId) throws ClassNotFoundException,SQLException;
    Customer getByCustomerId(int customerId) throws ClassNotFoundException,SQLException;
}
