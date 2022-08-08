package com.gang.members;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("멤버 관리");
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
		
		String path = request.getPathInfo();


		//member/login : GET => 로그인 가입 양식을 보려 함
		//member/login : POST => 입력한 ID, PW로 로그인 판단
		if(path.equals("/login")) {
			ArrayList<BankMembersDTO> ar = null;
			if(request.getMethod().equals("POST")) {
				System.out.println("로그인 처리");
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				//BankMembersDTO bankMembersDTO = new BankMembersDTO();
				try {
					ar = bankMembersDAO.getList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(BankMembersDTO bankMembersDTO : ar) {
					if(id.equals(bankMembersDTO.getUserName()) && (pw.equals(bankMembersDTO.getPassword()))) {
						System.out.println("로그인 성공");
						break;
					}else {
						System.out.println("로그인 실패");
					}
				}
				path = "/WEB-INF/view/member/login.jsp";
				
			}else {
				//로그인 처리
				path = "/WEB-INF/view/member/login.jsp";
				
			}
		
			
			/*
			//redirect
			response.sendRedirect("../");
			return;
			*/
			
		}else if(path.equals("/join")) {
			

			String username = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(username);
			bankMembersDTO.setPassword(pw);
			bankMembersDTO.setName(name);
			bankMembersDTO.setEmail(email);
			bankMembersDTO.setPhone(phone);
			
			int result = 0;
			try {
				result = bankMembersDAO.setJoin(bankMembersDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == 1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		//	request.setAttribute("join", ar);
			
			path = "/WEB-INF/view/member/join.jsp";
			
			
		}else if(path.equals("/search")) {
			String method = request.getMethod();
			
			if(method.equals("GET")) {
				path = "/WEB-INF/view/member/search.jsp";
				
			}else {
				//파라미터를 꺼내서 출력
				String test = request.getParameter("search");
				System.out.println(test);
				try {
					ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(test);
					request.setAttribute("list", ar);
					path = "/WEB-INF/view/member/list.jsp";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		}
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
		
		/*
		String method =  request.getMethod();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		String pathinfo = request.getPathInfo();
		String contextpath = request.getContextPath();
		System.out.println(method);
		System.out.println(url);
		System.out.println(uri);
		System.out.println(pathinfo);
		System.out.println(contextpath);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
