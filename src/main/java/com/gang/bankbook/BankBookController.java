package com.gang.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("통장 관리");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*
		String method = request.getMethod();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		
		System.out.println(method);
		System.out.println(url);
		System.out.println(uri);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
		BankBookDAO bankbookDAO = new BankBookDAO();
		String path = request.getPathInfo();
		if(path.equals("/list")) {
			try {
				ArrayList<BankBookDTO> ar = bankbookDAO.getList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				path = "/WEB-INF/view/bankbook/list.jsp";
			
		}else if(path.equals("/detail")) {
			
			String bookNum = request.getParameter("bookNum");
			System.out.println(bookNum);
			
			BankBookDTO bankbookDTO = new BankBookDTO();
			Long l = Long.parseLong(bookNum);
			bankbookDTO.setBooknum(l);
			
			try {
				bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
				request.setAttribute("dto", bankbookDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			path="/WEB-INF/view/bankbook/detail.jsp";
			//path = "../WEB-INF/view/bankbook/detail.jsp";
		}else if(path.equals("/login")) {
			path = "/WEB-INF/view/member/login.jsp";
			
		}else if(path.equals("/join")) {
			path = "/WEB-INF/view/member/join.jsp";
			
		}
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
