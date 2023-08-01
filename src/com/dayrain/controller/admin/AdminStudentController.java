package com.dayrain.controller.admin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Student;
import com.dayrain.service.*;

/**
 *跳转到学生管理
 */
@WebServlet("/admin/adminStudentUrl")
public class AdminStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final StudentService studentService = ServiceHolder.studentService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String query = request.getParameter("query");
		List<Student> studentList = studentService.getStudentList(query);
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/WEB-INF/pages/admin/admin-student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
