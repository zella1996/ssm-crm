package com.zella.crm.service;

import com.zella.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
