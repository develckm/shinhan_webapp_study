<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<%
    //doGet(HttpServeltRequest request,... response)
    // out,session,cookie....
    int a=10;
%>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
    <nav>
        <ul>
            <li><a href="./board/list.do">게시판 리스트 입니다.</a></li>
            <li><a href="./user/list.dox">유저 리스트 입니다.</a></li>
        </ul>
    </nav>
</body>
</html>