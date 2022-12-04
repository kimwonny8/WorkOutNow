package kjw59_project.controller.won.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kjw59_project.controller.won.Action;
import kjw59_project.controller.won.ActionForward;
import kjw59_project.model.won.*;

public class uploadPTAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");
		productDAO productDAO = new productDAO();
		ptDTO pt = new ptDTO();

		// pt 테이블에 내용 추가
		pt.setT_id((String)session.getAttribute("m_id"));
		pt.setPt_title(request.getParameter("pt_title"));
		pt.setPt_one_c(Integer.parseInt(request.getParameter("pt_one_c")));
		pt.setPt_con_c(Integer.parseInt(request.getParameter("pt_con_c")));
		pt.setPt_content(request.getParameter("pt_content"));
		
		boolean result = productDAO.insertProduct(pt);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(result == true) {
			forward.setPath("/getClassList.won");
		}
		else {
			forward.setPath("/com/yju/2wda/team1/view/etc/error.jsp");
		}
		
		return forward;
	}

}
