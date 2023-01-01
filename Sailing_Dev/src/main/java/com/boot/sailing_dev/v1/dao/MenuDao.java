package com.boot.sailing_dev.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {

    List<Map<String, Object>> doList();
}
