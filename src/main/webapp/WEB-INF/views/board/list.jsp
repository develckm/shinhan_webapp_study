<%@ page import="com.study.shinhan_webapp_study.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>MVC model2 디자인 패턴으로 게시판 리스트 출력</h1>
    <p>
        <%--  out.print(String) : 응답으로 해당 문자열을 작성 --%>
        <%-- <%=request.getAttribute("boardList")%>--%>
    </p>
    <table>
        <thead>
            <tr>
                <th>bId</th>
                <th>title</th>
                <th>postTime</th>
                <th>조회수</th>
                <th>상세보기</th>
            </tr>
        </thead>
        <tbody>
            <%  Object boardListObj=request.getAttribute("boardList");
                List<BoardDto> boardList=(List<BoardDto>)boardListObj;
                for(BoardDto b: boardList){
            %>
                <tr>
                    <td><%=b.getBId()%></td>
                    <td><%=b.getTitle()%></td>
                    <td><%=b.getPostTime()%></td>
                    <td><%=b.getViewCount()%></td>
                    <td><a href="./detail.do?bId=<%=b.getBId()%>">상세보기</a></td>
                </tr>
            <%}%>
        </tbody>
    </table>

</body>
</html>
