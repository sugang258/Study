package com.gang.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gang.bankbook.BankBookDAO;
import com.gang.bankbook.BankBookDTO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello~~~");
		/*
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = null;
		try {
			ar = bankBookDAO.getList();
			
			request.setAttribute("list", ar);
			
			*/
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			view.forward(request, response);
			/*
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		PrintWriter out = response.getWriter();
		out.println("<html>");
		//out.println("<body>");
		out.println("<h1>HiHiHiHiHI</h1>");
		out.println("BookBank 리스트 (최신순)");
		for(BankBookDTO bankBookDTO : ar) {
			out.println("<h3>");
			out.println(bankBookDTO.getBooknum());
			out.println("</h3>");
			out.println("<h3>");
			out.println(bankBookDTO.getBookname());
			out.println("</h3>");
			out.println("<h3>");
			out.println(bankBookDTO.getBookrate());
			out.println("</h3>");
			out.println("<h3>");
			out.println(bankBookDTO.getBooksale());
			out.println("</h3>");
			



		}
		//out.println("</body>");
		out.println("</html>");
		*/

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
