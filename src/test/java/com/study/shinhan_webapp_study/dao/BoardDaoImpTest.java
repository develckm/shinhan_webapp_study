package com.study.shinhan_webapp_study.dao;

import com.study.shinhan_webapp_study.DBConnection;
import com.study.shinhan_webapp_study.dto.BoardDto;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardDaoImpTest {
    static BoardDao boardDao;
    static Connection conn;
    //@AfterAll,@BeforeEach,@AfterEach
    @BeforeAll //모든 단위 테스트 전에 실행되는 함수(테스트의 초기값)
    static void init() throws Exception {
        conn= DBConnection.getConn();
        boardDao=new BoardDaoImp(conn);
    }
    //@Transactional
    @Test
    void findAll() {
        try {
            //service
            conn.commit();
            List<BoardDto> boardList=boardDao.findAll();
            assertNotNull(boardList);
            //insert
            //update
            //update
            //delete
        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Test
    void updateViewCountByBId() {
    }

    @Test
    void updateStatusByBId() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByPk() {
    }

    @Test
    void count() {
    }
}