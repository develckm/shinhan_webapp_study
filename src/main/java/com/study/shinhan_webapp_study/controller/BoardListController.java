package com.study.shinhan_webapp_study.controller;

import com.study.shinhan_webapp_study.DBConnection;
import com.study.shinhan_webapp_study.dao.BoardDao;
import com.study.shinhan_webapp_study.dao.BoardDaoImp;
import com.study.shinhan_webapp_study.dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//web.xml 서블릿의 url 을 명시 (DD 배포서술자 톰캣 1개(기본설정), 웹앱 1개(동적리소스))
@WebServlet("/board/list.do")//컴파일시 dd에 동적리소스 주소 자동 등록
public class BoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //board/list.do?page=3&search=test&a=3.1
        //page,search ...
        //http 통신은 문자열기반 통신
        String pageStr=req.getParameter("page");
        String search=req.getParameter("search");
        String aStr=req.getParameter("a");
        //list page(default=1) : 기본값이 존재하는 파라미터 처리법
        int page=(pageStr!=null)?Integer.parseInt(pageStr):1;

        List<BoardDto> boardList=null;
        try {
            BoardDao boardDao=new BoardDaoImp(DBConnection.getConn());
            boardList=boardDao.findAll();
            //if(boardList!=null)throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(500,"DB 서버에 문제가 발생 다시 시도");
            return;
            //1.404 : url의 리소스가 없음
            //2.400 : 잘못된 요청
            //3.200 : 성공
            //4.500 : 서버오류
        }
        //html 문자열로 view -> jsp
        //템플릿엔진 : 동적리소스인 view를 html로 렌더링(포워드)하는 언어
        //jsp : 템플릿 엔진인데 인터프리터 언어로 자바형식의 문법을 사용가능
        //주의!! view(jsp)는 html 처럼 보이지만 동적리소스로 정적리소스의 위치에 두면 해킹 위험이 존재
        req.setAttribute("boardList",boardList);
        req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req,resp);
        //렌더링 : view 인 템플릿을 html로만 변환 (1개의 서블릿에서 view를 렌더링해서 응답)
        //포워드 : view 인 템플릿으로 이동해서 실행 결과를 반환 (2개의 서블릿이 1개처럼 동작)
    }
}
