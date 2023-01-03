package com.boot.sailing_dev.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {


    List<Map<String, Object>> doList();

    int doInsert(String strCoffee, String strKind, String strPrice);

    int doDelete(String strNo);

    /* 커피 One row 가져오기 */
    Map<String, String> doListOne(String strNo);

    /* 메뉴정보 수정하기 */
    int doUpdate(String strNo, String strCoffee, String strKind, String strPrice);
}
