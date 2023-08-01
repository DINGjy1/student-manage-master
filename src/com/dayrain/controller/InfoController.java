package com.dayrain.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Student;
import com.dayrain.entity.User;
import com.dayrain.service.ServiceHolder;
import com.dayrain.service.StudentService;


/**
 * 跳转到学生个人信息界面
 */
@WebServlet("/infoUrl")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final StudentService studentService = ServiceHolder.studentService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("loginUser");
		Student student = studentService.getStudentByNo(user.getStudentNo());
	
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/pages/info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
