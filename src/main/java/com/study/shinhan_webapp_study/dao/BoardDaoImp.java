package com.study.shinhan_webapp_study.dao;

import com.study.shinhan_webapp_study.dto.BoardDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImp implements BoardDao{

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public BoardDaoImp(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<BoardDto> findAll() throws Exception {
        List<BoardDto> findAll=null;//초기값을 null
        String sql="SELECT * FROM BOARDS";
        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        findAll=new ArrayList<>();
        while (rs.next()){
            BoardDto board=new BoardDto();
            board.setBId(rs.getInt("b_id"));
            board.setUId(rs.getString("u_id"));
            board.setTitle(rs.getString("title"));
            switch (rs.getString("status")){
                case "PUBLIC" : board.setStatus(BoardDto.StatusType.PUBLIC); break;
                case "PRIVATE" : board.setStatus(BoardDto.StatusType.PRIVATE); break;
                case "REPORT" : board.setStatus(BoardDto.StatusType.REPORT); break;
                case "BLOCK" : board.setStatus(BoardDto.StatusType.BLOCK); break;
            }
            board.setContent(rs.getString("content"));
            board.setPostTime(rs.getTime("post_time"));
            board.setUpdateTime(rs.getTime("update_time"));
            board.setViewCount(rs.getInt("view_count"));
            findAll.add(board);
        }
        return findAll;
    }

    @Override
    public int updateViewCountByBId(int bId) throws Exception {
        return 0;
    }

    @Override
    public int updateStatusByBId(String status) throws Exception {
        return 0;
    }

    @Override
    public int insert(BoardDto dto) throws Exception {
        return 0;
    }

    @Override
    public int update(BoardDto dto) throws Exception {
        return 0;
    }

    @Override
    public int delete(Integer pk) throws Exception {
        return 0;
    }


    @Override
    public BoardDto findByPk(Integer pk) throws Exception {
        return null;
    }

    @Override
    public int count() throws Exception {
        return 0;
    }
}
