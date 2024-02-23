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

        // 검색어 및 정렬 옵션 가져오기
        String keyword = request.getParameter("keyword");
        String sortOption = request.getParameter("sortOption");

        // 페이징을 위한 파라미터 추가
        int currentPage = 1;
        int itemsPerPage = 10;

        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        // 1. 디비로부터 검색 및 정렬된 데이터 가져오기
        BoardDao bdao = new BoardDao();
        ArrayList<BoardDo> bList;

        if (keyword != null || sortOption != null) {
            // 검색어 또는 정렬 옵션이 전달된 경우
            bList = bdao.searchAndSortAddr(sortOption, keyword, currentPage, itemsPerPage);
        } else {
            // 검색어와 정렬 옵션이 전달되지 않은 경우 전체 데이터 가져오기
            bList = bdao.getBoardList();
        }

        // 2. 전체 페이지 수 계산
        int totalItems = bdao.getTotalItems(); // 전체 아이템 수 가져오기
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        // 3. 뷰어를 호출하면서, 데이터와 페이징 정보 넘기기
        ModelAndView mav = new ModelAndView();
        mav.addObject("bList", bList);
        mav.addObject("currentPage", currentPage);
        mav.addObject("totalPages", totalPages);
        mav.setViewName("memberList");

        return mav;
    }
}
