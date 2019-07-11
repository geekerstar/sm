package com.geekerstar.sm.controller;

import com.geekerstar.sm.entity.Department;
import com.geekerstar.sm.entity.Staff;
import com.geekerstar.sm.service.DepartmentService;
import com.geekerstar.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 员工列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }

    /**
     * 新增员工(查）
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }

    /**
     * 新增员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = new Staff();
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    /**
     * 编辑员工(查）
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ", staff);
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }

    /**
     * 编辑员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = staffService.get(id);
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    /**
     * 删除员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    /**
     * 查看员工详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ", staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
    }
}
