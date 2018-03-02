package com.niit.dao;

import com.niit.model.Customer;
import com.niit.model.User;

public interface CustomerDao {
void registerCustomer(Customer customer);
boolean isEmailValid(String email);
boolean isUsernameValid(String username);
User getUser(String username);
}
