package com.study.shinhan_webapp_study.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/detail.do")
public class BoardDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bIdStr=req.getParameter("bId");
        int bId;
        try {
            bId=Integer.parseInt(bIdStr);
        }catch (NumberFormatException e){
            resp.sendError(400,"id가 필요");
            return;
        }
    }
}
