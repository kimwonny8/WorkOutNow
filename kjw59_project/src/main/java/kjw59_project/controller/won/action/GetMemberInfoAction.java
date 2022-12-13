package kjw59_project.controller.won.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kjw59_project.controller.won.Action;
import kjw59_project.controller.won.ActionForward;
import kjw59_project.model.won.MemberDAO;
import kjw59_project.model.won.MemberDTO;

public class GetMemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		request.setCharacterEncoding("utf-8");

		String m_id = request.getParameter("m_id");
		request.setCharacterEncoding("utf-8");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO member = new MemberDTO();
		ArrayList<MemberDTO> list = memberDAO.getMemberInfoList(m_id);
		session.setAttribute("list", list);
		
		forward.setPath("/com/yju/2wda/team1/view/won/updateMember.jsp");
		return forward;
	}

}