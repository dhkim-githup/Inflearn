package com.boot.sailing_dev.v1.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuDaoTest {

    @Autowired
    MenuDao menuDao;

    @Test
    void doInsert() {
        menuDao.doInsert("에스프레소","커피","8500");
    }
}