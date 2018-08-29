package com.zella.crm.service.impl;

import com.zella.common.utils.Page;
import com.zella.crm.mapper.CustomerMapper;
import com.zella.crm.pojo.Customer;
import com.zella.crm.pojo.QueryVo;
import com.zella.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    public Page<Customer> queryPageByQueryVo(QueryVo vo) {

        Page<Customer> page = new Page<>();
        page.setSize(5);
        vo.setSize(5);
        if (vo != null) {
            if (vo.getPage() != null) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }

            if (vo.getCustName() != null && !"".equals(vo.getCustName().trim())) {
                vo.setCustName(vo.getCustName().trim());
            }
            if (vo.getCustSource() != null && !"".equals(vo.getCustSource().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }

            page.setTotal(customerMapper.queryCustomerCountByQueryVo(vo));
            page.setRows(customerMapper.queryCustomerByQueryVo(vo));
        }

        /*System.out.println();
        System.out.println("....................");
        System.out.println(page.toString());
        System.out.println("....................");
        System.out.println();*/

        return page;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.deleteCustomerById(id);
    }

}
