package com.study.shinhan_webapp_study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {

    @Test
    void getConn() throws Exception {
        //오류 : test 실패의 기본값
        //System.out.println(DBConnection.getConn());
        assertNotNull(DBConnection.getConn());
    }
}