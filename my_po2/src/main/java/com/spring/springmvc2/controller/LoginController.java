package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("loginController --> ");

        // 1. 전달되는 데이터 받기
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        System.out.println("ID: " + id);
        System.out.println("Password: " + password);

        // 2. 디비로부터 데이터 가져오기 (BoardDo, BoardDao)
        BoardDo bdo = new BoardDo();
        bdo.setId(id);
        bdo.setPassword(password);

        BoardDao bdao = new BoardDao();

        // 3. 사용자 정보 확인
        boolean isValidUser = bdao.checkUser(bdo);

        ModelAndView mav = new ModelAndView();

        if (isValidUser) {
            // 사용자 정보가 확인된 경우
            mav.addObject("message", "사용자 정보 확인");
        } else {
            // 사용자 정보가 확인되지 않은 경우
            mav.addObject("message", "로그인 실패! 아이디 또는 비밀번호를 확인해주세요.");
        }

        mav.setViewName("login");

        return mav;
    }
}
