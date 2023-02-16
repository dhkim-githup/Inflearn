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

    /* 검색 */
    List<Map<String, Object>> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    /* 가격 로그입력 */
    int doInsertLog(String strNo, String strPrice);

    /* 가격 변경 */
    int doUpdatePrice(String strNo, String strPrice);

    int doInsertLogOne(List<String> chkList, String strPrice);

    int doUpdatePriceOne(List<String> chkList, String strPrice);
}
