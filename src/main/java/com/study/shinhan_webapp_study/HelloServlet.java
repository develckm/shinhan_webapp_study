package com.study.shinhan_webapp_study;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//리소스 : 조회(url)가 가능한 자원
//동적리소스,정적리소스
@WebServlet("/hello-servlet")//동적리소스의 url 을 생성
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    //Get url을 이용해서 조회할때
    //Post 양식 제출을 요청
    //REST aip(js AJAX) : PUT(수정),DELETE + (파라미터를 패스에 추가 가능)
    //ip(도메인주소)[==서버주소]/path[==서버내의 리소스 주소]?id=123&name=a&test=c.......
    //naver.com/자바의정석/2020/저자/search.do


    //모든 언어의 동적리소스는 요청정보와 응답정보로 이루어져있다.
    //HttpServletRequest request : 이 동적 리소스는 어떤 정보여야 합니다.
    //파라미터,쿠키(서버가 브라우저에 저장하는 정보),세션
    //세션 : 비연결성통신 http 통신 마치 연결된 것처럼 보이게 하기 위해 서버에 저장 유지하는 객체

    //HttpServletResponse response : 클라이언트가 요청한 내역을 응답하는 문서(html,json,xml...),상태


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> 메세지 : " + message + "</h1>");
        out.println("<h2>10.4*50.98="+(10.4*50.98)+"</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}