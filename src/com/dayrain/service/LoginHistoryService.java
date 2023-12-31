package com.dayrain.service;

import com.dayrain.Dao.DaoHolder;
import com.dayrain.Dao.LoginHistoryDao;
import com.dayrain.entity.LoginHistory;

public class LoginHistoryService{

	private final LoginHistoryDao loginHistoryDao = DaoHolder.loginHistoryDao;

	/**
	 * 登录记录 + 1
	 * @param loginHistory
	 */
	public void addLoginHistory(LoginHistory loginHistory) {
		LoginHistoryDao loginHistoryDao = new LoginHistoryDao();
		loginHistoryDao.addLoginHistory(loginHistory);
	}
}
