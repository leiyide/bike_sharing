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

	//业务逻辑层LoginServiceDao的注入
	@Resource(name="loginServiceDao")
	private LoginServiceDao loginServiceDao;

	//登录的后台控制
	@RequestMapping("/login.do")
	public String userLogin(String radioUser,String radioAdmin,String UserName,String UserPassword, HttpServletRequest request,HttpServletResponse response,ModelMap model){
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = null;
		//用户进行登录
		if(radioUser!=null){
			User userLogin = loginServiceDao.getUserLogin(UserName, UserPassword);
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(userLogin==null){
				out.print("<script language=\"javascript\">alert('登录失败！请重新登录！');window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				//获得对应的菜单栏（权限）
				Integer userRank = userLogin.getUserRank();
				//得到权限等级关联的对象集合
				List<LimiteRole> userLimit = loginServiceDao.getUserLimit(userRank);
				//存放父级菜单栏对象的集合
				List<Column> parent=new ArrayList<Column>();
				//存放父子级对应权限菜单
				Map<Integer,List<Column>> relateColumn=new HashMap<Integer,List<Column>>();
				for (LimiteRole limiteRole : userLimit) {
					//得到该用户下所有的一级菜单
					Column columnLimite = loginServiceDao.getColumnLimite(limiteRole.getColumnId());
					parent.add(columnLimite);
				}
				//将父级菜单放入session
				session.setAttribute("parent", parent);
				if(parent!=null){
					for (Column column : parent) {
						List<Column> child=new ArrayList<Column>();
						Integer columnPermissionid = column.getColumnPermissionid();
						//根据一级菜单得到所有的父子级菜单
						List<Column> childColumn = loginServiceDao.getChildColumn(column.getColumnPermissionid());
						for (Column column2 : childColumn) {
							if(column2.getColumnId()!=column2.getColumnPermissionid()&&column2.getColumnFirstid()==2){
								child.add(column2);
							}
						}
						//将父子级对应的权限菜单放入map集合
						relateColumn.put(column.getColumnId(), child);
					}
					//将对应关系放入session中
					session.setAttribute("relateColumn", relateColumn);
				}
				return "index.jsp";
			}
		//员工进行登录
		}else{
			Employee employeeLogin = loginServiceDao.getEmployeeLogin(UserName, UserPassword);
			try {
				out = response.getWriter();
			} catch (IOException e) { 
				e.printStackTrace();
			}
			if(employeeLogin==null){
				out.print("<script language=\"javascript\">alert('登录失败！请重新登录！');window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				return "index.jsp";
			}
		}
	}

	//找回密码
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
				out.print("<script language=\"javascript\">alert('您的登录密码为："+userLogin.getUserPassword()+"'"+");window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				out.print("<script language=\"javascript\">alert('该用户不存在');window.location.href='findpassword.jsp'</script>");
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
				out.print("<script language=\"javascript\">alert('您的登录密码为："+employeeLogin.getEmployeePassword()+"'"+");window.location.href='login.jsp'</script>");
				return null;
			}
			else{
				out.print("<script language=\"javascript\">alert('该用户不存在');window.location.href='findpassword.jsp'</script>");
				return null;
			}
		}
	}

	//注册新用户
	@RequestMapping("/regist.do")
	public String addNewUser(String Name,String Email,String Phone,String IdCard,String Password,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//查询新增用户信息是否存在
		User findUserPassword = loginServiceDao.findUserPassword(Name, Email, Phone, IdCard);
		if(findUserPassword==null&&StringUtils.isNotBlank(Name)&&StringUtils.isNotBlank(Email)&&StringUtils.isNotBlank(Password)&&StringUtils.isNotBlank(Phone)&&StringUtils.isNotBlank(IdCard)){
			//新增客户
			Boolean addNewUser = loginServiceDao.addNewUser(Name, Email, Phone, IdCard, Password);
			if(addNewUser!=null&&addNewUser==true){
				return "login.jsp";
			}else{
				out.print("<script language=\"javascript\">alert('注册失败！请重新注册！');window.location.href='registration.jsp'</script>");
				return null;
			}
		}else{
			out.print("<script language=\"javascript\">alert('该用户已存在!');window.location.href='registration.jsp'</script>");
			return null;
		}
	}

	//校验身份证的唯一性；
	@RequestMapping(value="/checkIdCard.do",method=RequestMethod.POST)
	public void checkIdCard(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		try {
			response.setContentType("text/html; charset=utf-8");
			//得到前端页面传进来的值
			String parameter = request.getParameter("IdCard");
			User checkIdCard = loginServiceDao.checkIdCard(parameter);
			String userIdcard=null;
			if(checkIdCard!=null){
				userIdcard = checkIdCard.getUserIdcard();
			}	
			//此处返回对象前台不能正常接受；
			response.getWriter().write("{\"checkIdCard\":"+userIdcard+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
