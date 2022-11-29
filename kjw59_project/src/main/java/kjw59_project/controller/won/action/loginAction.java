package kjw59_project.controller.won.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import kjw59_project.controller.won.*;
import kjw59_project.controller.*;
import kjw59_project.model.won.*;

public class loginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		memberDAO memberDAO = new memberDAO();
		memberDTO member = new memberDTO();
		cityDTO city = new cityDTO();

		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		member.setM_id(m_id);
		String Chk_m_pw = memberDAO.loginPwMember(member);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(m_pw.equals(Chk_m_pw)) {
			memberDAO = new memberDAO();
			String m_name = memberDAO.loginNameMember(member);
			
			memberDAO = new memberDAO();
			String c_code = memberDAO.getCityCode(member);
			city.setC_code(c_code);
			
			memberDAO = new memberDAO();
			String c_name = memberDAO.getCityName(city);
			
			session.setAttribute("m_id",m_id);
			session.setAttribute("m_name",m_name);
			session.setAttribute("c_name",c_name);
			session.setAttribute("loginState","login");
			
			JOptionPane.showMessageDialog(null, "로그인 성공!");
			forward.setPath("/index.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호 확인 후 다시 입력하세요");
			forward.setPath("/com/yju/2wda/team1/view/won/login.jsp");
		}
		
		
		return forward;
		
		
	}
}
