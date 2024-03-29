package kjw59_project.controller.won.action;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kjw59_project.controller.won.Action;
import kjw59_project.controller.won.ActionForward;
import kjw59_project.model.won.MemberDAO;
import kjw59_project.model.won.MemberDTO;

public class UpdateMemberChkPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		request.setCharacterEncoding("utf-8");

		try {
			String m_pw = encrypt(request.getParameter("m_pw"));
			request.setCharacterEncoding("utf-8");
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO member = new MemberDTO();

			String m_id = (String) session.getAttribute("m_id");
			member.setM_id(m_id);
			String pw = memberDAO.updateMemberChkPw(member);

			if (m_pw.equals(pw)) {
				forward.setPath("/com/yju/2wda/team1/view/won/myPage.jsp");
				return forward;
			} else {
				return null;
			}
		} catch (Exception e) {
			response.sendRedirect("/kjw59_project/com/yju/2wda/team1/view/etc/error.jsp");
			return null;
		}
	}

	// 비밀번호 암호화
	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

}
