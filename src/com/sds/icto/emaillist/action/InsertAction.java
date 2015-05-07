package com.sds.icto.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;
import com.sds.icto.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String firstName = request.getParameter( "fn" );
		String lastName = request.getParameter( "ln" );
		String email = request.getParameter( "email" );

		EmailListVo vo = new EmailListVo();
		vo.setFirstName( firstName );
		vo.setLastName( lastName );
		vo.setEmail( email );

		EmailListDao dao = new EmailListDao();
		dao.insert( vo );
		
		response.sendRedirect("/emaillist2/el");
	}

}
