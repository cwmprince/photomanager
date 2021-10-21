package com.hs.service;

import com.hs.entity.Customer;

public interface CustomerService {

    int login(String username,String passwd);

    int register(Customer customer);

    Customer findCustomerByUsername(String username);
}
