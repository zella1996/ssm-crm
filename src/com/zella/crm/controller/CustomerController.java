package com.zella.crm.controller;

import com.zella.common.utils.Page;
import com.zella.crm.pojo.BaseDict;
import com.zella.crm.pojo.Customer;
import com.zella.crm.pojo.QueryVo;
import com.zella.crm.service.BaseDictService;
import com.zella.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

    @Value("${fromType.code}")
    private String fromTypeCode;
    @Value("${industryType.code}")
    private String industryTypeCode;
    @Value("${levelType.code}")
    private String levelTypeCode;


    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("list")
    public String list(QueryVo vo, Model model) {

        // 出现硬编码了
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(industryTypeCode);
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(levelTypeCode);

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 通过四个条件查询分页对象
        Page<Customer> page = customerService.queryPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevle", vo.getCustLevel());

        return "customer";
    }

    @RequestMapping("edit")
    public @ResponseBody
    Customer queryCustomerById(Long id) {
        return customerService.queryCustomerById(id);
    }

    @RequestMapping("update")
    public @ResponseBody
    String updateCustomer(Customer customer) {

        customerService.updateCustomer(customer);

        return "OK";
    }

    @RequestMapping("delete")
    public @ResponseBody
    String deleteCustomerById(Long id) {

        customerService.deleteCustomerById(id);

        return "OK";
    }

}
