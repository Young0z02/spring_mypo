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

        // 1. ���޵Ǵ� ������ �ޱ�
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        System.out.println("ID: " + id);
        System.out.println("Password: " + password);

        // 2. ���κ��� ������ �������� (BoardDo, BoardDao)
        BoardDo bdo = new BoardDo();
        bdo.setId(id);
        bdo.setPassword(password);

        BoardDao bdao = new BoardDao();

        // 3. ����� ���� Ȯ��
        boolean isValidUser = bdao.checkUser(bdo);

        ModelAndView mav = new ModelAndView();

        if (isValidUser) {
            // ����� ������ Ȯ�ε� ���
            mav.addObject("message", "����� ���� Ȯ��");
        } else {
            // ����� ������ Ȯ�ε��� ���� ���
            mav.addObject("message", "�α��� ����! ���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
        }

        mav.setViewName("login");

        return mav;
    }
}
