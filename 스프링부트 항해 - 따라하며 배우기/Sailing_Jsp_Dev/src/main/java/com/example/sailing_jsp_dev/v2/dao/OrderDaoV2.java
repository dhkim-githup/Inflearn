package com.example.sailing_jsp_dev.v2.dao;


import com.example.sailing_jsp_dev.v2.vo.Order_list;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDaoV2 {
    List<Order_list> doList();

    /* 조회하기 */
    List<Order_list> doSerch(String strStartDate, String strEndDate, String strCoffee, String strName);
}
