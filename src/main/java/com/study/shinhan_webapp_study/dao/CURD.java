package com.study.shinhan_webapp_study.dao;

import com.study.shinhan_webapp_study.dto.BoardDto;

import java.util.List;

public interface CURD <T,P>{
    //db에서 클라이언트에게 제공하는 공통 서비스
    //Create Update Read(전체 조회,1개 조회) Delete (Model==DB)
    int insert(T dto) throws Exception;
    int update(T dto) throws Exception;
    int delete(P pk) throws Exception;
    //jpa : ORM POJO로 작성한 Entity를 기반으로 쿼리를 자동 작성 및 결과를 맵핑
    //jpa에서 함수 이름으로 쿼리를 자동완성하는데 그 이름이 명시적이고 유지 보수에 유리
    List<T> findAll() throws Exception;
    T findByPk(P pk) throws Exception;
    int count() throws Exception;
}
