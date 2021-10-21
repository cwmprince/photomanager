package com.hs.mapper;

import com.hs.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    Customer selectCustomerByUsername(String username);

    int addCustomer(Customer customer);

    Customer selectCustomerByCid(int c_id);
}
