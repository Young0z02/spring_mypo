package com.spring.springmvc2.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class memberListController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("MemberListController -->");

        // �˻��� �� ���� �ɼ� ��������
        String keyword = request.getParameter("keyword");
        String sortOption = request.getParameter("sortOption");

        // ����¡�� ���� �Ķ���� �߰�
        int currentPage = 1;
        int itemsPerPage = 10;

        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        // 1. ���κ��� �˻� �� ���ĵ� ������ ��������
        BoardDao bdao = new BoardDao();
        ArrayList<BoardDo> bList;

        if (keyword != null || sortOption != null) {
            // �˻��� �Ǵ� ���� �ɼ��� ���޵� ���
            bList = bdao.searchAndSortAddr(sortOption, keyword, currentPage, itemsPerPage);
        } else {
            // �˻���� ���� �ɼ��� ���޵��� ���� ��� ��ü ������ ��������
            bList = bdao.getBoardList();
        }

        // 2. ��ü ������ �� ���
        int totalItems = bdao.getTotalItems(); // ��ü ������ �� ��������
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        // 3. �� ȣ���ϸ鼭, �����Ϳ� ����¡ ���� �ѱ��
        ModelAndView mav = new ModelAndView();
        mav.addObject("bList", bList);
        mav.addObject("currentPage", currentPage);
        mav.addObject("totalPages", totalPages);
        mav.setViewName("memberList");

        return mav;
    }
}
