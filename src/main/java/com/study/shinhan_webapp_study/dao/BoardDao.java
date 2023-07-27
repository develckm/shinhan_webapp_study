package com.study.shinhan_webapp_study.dao;

import com.study.shinhan_webapp_study.dto.BoardDto;

public interface BoardDao extends CURD<BoardDto,Integer>{
    int updateViewCountByBId(int bId) throws Exception;
    int updateStatusByBId(String status) throws Exception;
}
