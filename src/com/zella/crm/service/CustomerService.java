package com.zella.crm.service;

import com.zella.common.utils.Page;
import com.zella.crm.pojo.Customer;
import com.zella.crm.pojo.QueryVo;

public interface CustomerService {

    Page<Customer> queryPageByQueryVo(QueryVo vo);

    Customer queryCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}
