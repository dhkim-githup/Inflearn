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

    /* 검색 */
    List<Map<String, Object>> doSerch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    /* 가격 변경 */
    int doUpdatePrice(String strNo, String strPrice);

    /* 가격 로그입력 */
    int doInsertLog(String strNo, String strPrice);

    /* 로그 원 쿼리 */
    int doInsertLogOne(List<String> chkList, String strPrice);

    /* Update 원 쿼리 */
    int doUpdatePriceOne(List<String> chkList, String strPrice);
}
