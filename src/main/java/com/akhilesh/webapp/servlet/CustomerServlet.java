/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.webapp.servlet;

import com.akhilesh.webapp.dao.CustomerDAO;
import com.akhilesh.webapp.dao.impl.CustomerDAOImpl;
import com.akhilesh.webapp.entity.Customer;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akhilesh
 */
@WebServlet(displayName = "customer", urlPatterns = {"/customers/*"})
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getRequestURI().contains("customers/add")) {
                request.getRequestDispatcher("/WEB-INF/jsp/customers/add_customer.jsp").forward(request, response);
            } else if (request.getRequestURI().contains("customers/edit_customer")) {
                int customerId = Integer.parseInt(request.getParameter("id"));
                Customer customer = customerDAO.getByCustomerId(customerId);
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("/WEB-INF/jsp/customers/edit_customer.jsp").forward(request, response);
            } else if (request.getRequestURI().contains("customers/delete_customer")) {
                int customerId = Integer.parseInt(request.getParameter("id"));
                int result = customerDAO.delete(customerId);
                if (result > 0) {
                    System.out.println("Delete Successful!");
                    request.setAttribute("customers", customerDAO.getAllCustomers());
                    request.getRequestDispatcher("/WEB-INF/jsp/customers/index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("customers", customerDAO.getAllCustomers());
                request.getRequestDispatcher("/WEB-INF/jsp/customers/index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = "";
        String lastName = "";
        String email = "";
        String contact = "";
        boolean status = false;
        Customer customer;
        try {
            if (request.getRequestURI().contains("customers/add")) {
                firstName = request.getParameter("firstname");
                lastName = request.getParameter("lastname");
                email = request.getParameter("email");
                contact = request.getParameter("contact");
                status = request.getParameter("status") != null;
                customer = new Customer();
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setContact(contact);
                customer.setStatus(status);

                int result = customerDAO.insert(customer);
                if (result > 0) {
                    request.setAttribute("customers", customerDAO.getAllCustomers());
                    request.getRequestDispatcher("/WEB-INF/jsp/customers/index.jsp").forward(request, response);
                    System.out.println("Add Customer Successful!");

                }
            } else if (request.getRequestURI().contains("customers/edit_customer")) {
                System.out.println("HELLO AKHILESH");
                int id = Integer.parseInt(request.getParameter("id"));
                firstName = request.getParameter("firstname");
                lastName = request.getParameter("lastname");
                email = request.getParameter("email");
                contact = request.getParameter("contact");
                status = request.getParameter("status") != null;

                customer = new Customer();
                customer.setId(id);
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setContact(contact);
                customer.setStatus(status);

                System.out.println("updte: " + firstName);
                int result = customerDAO.update(customer);
                if (result > 0) {
                    System.out.println("Update Successful");
                    request.setAttribute("customers", customerDAO.getAllCustomers());
                    request.getRequestDispatcher("/WEB-INF/jsp/customers/index.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Error Update!");
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
