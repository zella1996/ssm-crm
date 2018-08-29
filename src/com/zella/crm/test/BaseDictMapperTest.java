package com.zella.crm.test;

import com.zella.crm.mapper.BaseDictMapper;
import com.zella.crm.pojo.BaseDict;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BaseDictMapperTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        this.context =
                new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
    }


    @Test
    public void queryBaseDictByDictTypeCode() {

        BaseDictMapper mapper = this.context.getBean(BaseDictMapper.class);

        List<BaseDict> baseDictList = mapper.queryBaseDictByDictTypeCode("001");

        for (BaseDict baseDict : baseDictList) {
            System.out.println(baseDict.toString());
        }

    }
}
