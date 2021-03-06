package com.sample.bank.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.entity.Transaction;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.UserView;

public class DownloadPassbookAction implements ModelDriven<UserView>, SessionAware {

	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private UserView userView;

	@Override
	public UserView getModel() {
		userView = new UserView();
		return userView;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	public void getCSV() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		List<Transaction> transactions = svc.getTransactions(userSession.get("name").toString());
		try {
			response.setContentType("text/csv");
			String reportName = userSession.get("name").toString()+"-transactions.csv";
			response.setHeader("Content-disposition", "attachment;filename=" + reportName);

			
			String CSV = "ID, Amount, Type, Date\n";
			
			for(Transaction t : transactions) {
				CSV += t.getId() + ", " + t.getAmount() + ", " 
						+ t.getType() + ", " + t.getDate() + "\n";
			}

			response.getOutputStream().print(CSV);
			response.getOutputStream().flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
