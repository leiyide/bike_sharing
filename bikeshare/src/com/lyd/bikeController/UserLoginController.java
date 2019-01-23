package com.lyd.bikeController;


import java.io.IOException;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyd.bikeEntity.Column;
import com.lyd.bikeEntity.Employee;
import com.lyd.bikeEntity.LimiteRole;
import com.lyd.bikeEntity.User;
import com.lyd.bikeServiceDao.LoginServiceDao;

@Controller
public class UserLoginController {

	//ҵ���߼���LoginServiceDao��ע��
	@Resource(name="loginServiceDao")
	private LoginServiceDao loginServiceDao;

	//��¼�ĺ�̨����
	@RequestMapping("/login.do")
	public String userLogin(String radioUser,String radioAdmin,String UserName,String UserPassword, HttpServletRequest request,HttpServletResponse response,ModelMap model){
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = null;
		//�û����е�¼
		if(radioUser!=null){
			User userLogin = loginServiceDao.getUserLogin(UserName, UserPassword);
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(userLogin==null){
				out.print("<script language=\"javascript\">alert('��¼ʧ�ܣ������µ�¼��');window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				//��ö�Ӧ�Ĳ˵�����Ȩ�ޣ�
				Integer userRank = userLogin.getUserRank();
				//�õ�Ȩ�޵ȼ������Ķ��󼯺�
				List<LimiteRole> userLimit = loginServiceDao.getUserLimit(userRank);
				//��Ÿ����˵�������ļ���
				List<Column> parent=new ArrayList<Column>();
				//��Ÿ��Ӽ���ӦȨ�޲˵�
				Map<Integer,List<Column>> relateColumn=new HashMap<Integer,List<Column>>();
				for (LimiteRole limiteRole : userLimit) {
					//�õ����û������е�һ���˵�
					Column columnLimite = loginServiceDao.getColumnLimite(limiteRole.getColumnId());
					parent.add(columnLimite);
				}
				//�������˵�����session
				session.setAttribute("parent", parent);
				if(parent!=null){
					for (Column column : parent) {
						List<Column> child=new ArrayList<Column>();
						Integer columnPermissionid = column.getColumnPermissionid();
						//����һ���˵��õ����еĸ��Ӽ��˵�
						List<Column> childColumn = loginServiceDao.getChildColumn(column.getColumnPermissionid());
						for (Column column2 : childColumn) {
							if(column2.getColumnId()!=column2.getColumnPermissionid()&&column2.getColumnFirstid()==2){
								child.add(column2);
							}
						}
						//�����Ӽ���Ӧ��Ȩ�޲˵�����map����
						relateColumn.put(column.getColumnId(), child);
					}
					//����Ӧ��ϵ����session��
					session.setAttribute("relateColumn", relateColumn);
				}
				return "index.jsp";
			}
		//Ա�����е�¼
		}else{
			Employee employeeLogin = loginServiceDao.getEmployeeLogin(UserName, UserPassword);
			try {
				out = response.getWriter();
			} catch (IOException e) { 
				e.printStackTrace();
			}
			if(employeeLogin==null){
				out.print("<script language=\"javascript\">alert('��¼ʧ�ܣ������µ�¼��');window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				return "index.jsp";
			}
		}
	}

	//�һ�����
	@RequestMapping("/findPassword.do")
	public String findPassword(String radioUser,String radioAdmin,String Name,String Email, String Phone, String IdCard, HttpServletRequest request,HttpServletResponse response,ModelMap model){
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		if(radioUser!=null){
			User userLogin = loginServiceDao.findUserPassword(Name, Email, Phone, IdCard);
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(userLogin!=null){
				out.print("<script language=\"javascript\">alert('���ĵ�¼����Ϊ��"+userLogin.getUserPassword()+"'"+");window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				out.print("<script language=\"javascript\">alert('���û�������');window.location.href='findpassword.jsp'</script>");
				return null;
			}
		}else{
			Employee employeeLogin = loginServiceDao.findEmployeePassword(Name, Email, Phone, IdCard);
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(employeeLogin!=null){
				out.print("<script language=\"javascript\">alert('���ĵ�¼����Ϊ��"+employeeLogin.getEmployeePassword()+"'"+");window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				out.print("<script language=\"javascript\">alert('���û�������');window.location.href='findpassword.jsp'</script>");
				return null;
			}
		}
	}

	//ע�����û�
	@RequestMapping("/regist.do")
	public String addNewUser(String Name,String Email,String Phone,String IdCard,String Password,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ѯ�����û���Ϣ�Ƿ����
		User findUserPassword = loginServiceDao.findUserPassword(Name, Email, Phone, IdCard);
		if(findUserPassword==null&&StringUtils.isNotBlank(Name)&&StringUtils.isNotBlank(Email)&&StringUtils.isNotBlank(Password)&&StringUtils.isNotBlank(Phone)&&StringUtils.isNotBlank(IdCard)){
			//�����ͻ�
			Boolean addNewUser = loginServiceDao.addNewUser(Name, Email, Phone, IdCard, Password);
			if(addNewUser!=null&&addNewUser==true){
				return "login.jsp";
			}else{
				out.print("<script language=\"javascript\">alert('ע��ʧ�ܣ�������ע�ᣡ');window.location.href='registration.jsp'</script>");
				return null;
			}
		}else{
			out.print("<script language=\"javascript\">alert('���û��Ѵ���!');window.location.href='registration.jsp'</script>");
			return null;
		}
	}

	//У�����֤��Ψһ�ԣ�
	@RequestMapping(value="/checkIdCard.do",method=RequestMethod.POST)
	public void checkIdCard(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		try {
			response.setContentType("text/html; charset=utf-8");
			//�õ�ǰ��ҳ�洫������ֵ
			String parameter = request.getParameter("IdCard");
			User checkIdCard = loginServiceDao.checkIdCard(parameter);
			String userIdcard=null;
			if(checkIdCard!=null){
				userIdcard = checkIdCard.getUserIdcard();
			}	
			//�˴����ض���ǰ̨�����������ܣ�
			response.getWriter().write("{\"checkIdCard\":"+userIdcard+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
