package com.boot.sailing_jsp.comm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcMariaDbConnTest {

    @Test
    void doConn() {
        JdbcMariaDbConn dbConn = new JdbcMariaDbConn();

        dbConn.doConn();
    }
}