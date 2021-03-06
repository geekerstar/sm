package com.geekerstar.sm.controller;

import com.geekerstar.sm.entity.Staff;
import com.geekerstar.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;

    /**
     * 进入登录页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = selfService.login(account, password);
        if (staff == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", staff);
            response.sendRedirect("main.do");
        }
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        response.sendRedirect("toLogin.do");
    }

    /**
     * 主界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * /self/info.do 查看个人信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request, response);
    }

    /**
     * 打开修改密码界面 /self/toChangePassword.do
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request, response);
    }

    /**
     * 修改密码 /self/changePassword.do
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        if (!staff.getPassword().equals(password)) {
            response.sendRedirect("toChangePassword.do");
        } else {
            selfService.changePassword(staff.getId(), password1);
            //response.sendRedirect("../logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }
}
