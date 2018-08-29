package com.zella.crm.mapper;

import com.zella.crm.pojo.Customer;
import com.zella.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    List<Customer> queryCustomerByQueryVo(QueryVo vo);

    Integer queryCustomerCountByQueryVo(QueryVo vo);

    Customer queryCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}
