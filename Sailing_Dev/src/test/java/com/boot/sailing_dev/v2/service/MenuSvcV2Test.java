package com.boot.sailing_dev.v2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuSvcV2Test {

    @Autowired
    MenuSvcV2 menuSvcV2;

    @Test
    void doInsertUpdate() {

        List<String> chkList = new ArrayList<>();
        chkList.add("1");
        chkList.add("2");

        String strPrice = "888888";
        menuSvcV2.doInsertUpdate(chkList, strPrice);
    }
}