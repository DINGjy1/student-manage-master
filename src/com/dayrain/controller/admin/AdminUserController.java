package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Student;
import com.dayrain.entity.User;
import com.dayrain.service.*;

/**
 * 跳转到用户管理
 */
@WebServlet("/admin/adminUserUrl")
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final StudentService studentService = ServiceHolder.studentService;
	private final UserService userService = ServiceHolder.userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String query = request.getParameter("query");

		List<Student> students = studentService.getStudentUnRegister();

		List<User>users = userService.getUserList(query);
		request.setAttribute("users", users);
		request.setAttribute("students", students);
	
		request.getRequestDispatcher("/WEB-INF/pages/admin/admin-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
