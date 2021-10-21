package com.hs.service.impl;

import com.hs.entity.Customer;
import com.hs.entity.Xc;
import com.hs.mapper.CustomerMapper;
import com.hs.service.CustomerService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int login(String username, String passwd) {
        Customer customer = customerMapper.selectCustomerByUsername(username);
        if (customer==null){
            return -1;
        }else {
            if (customer.getPasswd().equals(passwd)){
                return 1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public int register(Customer customer) {
        Customer customer1 = customerMapper.selectCustomerByUsername(customer.getUsername());
        if (customer1==null){
            int i = customerMapper.addCustomer(customer);
            return i;
        }else {
            return -1;
        }
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        Customer customer = customerMapper.selectCustomerByUsername(username);
        return customer;
    }

}
