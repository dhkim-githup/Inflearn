package com.boot.sailing_dev.comm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcMariaDbConnTest {

    @Test
    void doConn() {

        JdbcMariaDbConn jdbcMariaDbConn = new JdbcMariaDbConn();

        jdbcMariaDbConn.doConn();

    }
}