package com.zella.crm.service.impl;

import com.zella.crm.mapper.BaseDictMapper;
import com.zella.crm.pojo.BaseDict;
import com.zella.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper mapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return mapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}
