package com.dayrain.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.service.*;

/**
 * 删除分数
 */
@WebServlet("/admin/deleteScore")
public class DeleteScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ScoreService scoreService = ServiceHolder.scoreService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		scoreService.deleteScore(Integer.valueOf(id));
		request.getRequestDispatcher("/admin/adminScoreUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
