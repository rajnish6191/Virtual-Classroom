/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.dts.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dts.core.util.CoreList;
import com.dts.project.dao.ChatRoomMasterDao;

/** 
 * MyEclipse Struts
 * Creation date: 01-29-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="viewChatRoom" path="/ViewChatRoomMaster.jsp"
 */
public class ViewChatRoomMasterAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ChatRoomMasterDao dao=new ChatRoomMasterDao();
		 CoreList cl=dao.ViewChatRoomMaster();
		 request.setAttribute("cl", cl);
		return mapping.findForward("viewChatRoom");
	}
}