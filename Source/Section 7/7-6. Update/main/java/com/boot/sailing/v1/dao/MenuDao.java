package com.boot.sailing.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {
    List<Map<String, Object>> doList();

    int doInsert(String strCoffee, String strKind, String strPrice);

    int doDelete(String strNo);

    // One row 조회
    Map<String, Object> doListOne(String strNo);

    // Update
    int doUpdate(String strNo, String strCoffee, String strKind, String strPrice);
}
