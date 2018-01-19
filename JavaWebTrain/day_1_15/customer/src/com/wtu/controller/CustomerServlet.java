package com.wtu.controller;

import com.wtu.entity.Customer;
import com.wtu.entity.PageBean;
import com.wtu.service.CustomerService;
import com.wtu.utils.DateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

public class CustomerServlet extends BaseServlet {

    private CustomerService customerService = new CustomerService();

    public String addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取请求参数
        String cname = request.getParameter("cname");
        System.out.println(cname);
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birthday");
        //System.out.println(birthday);
        Date birthday = DateUtil.strToDate(birth, "yyyy-MM-dd");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");

        //使用UUID生成一个客户的id
        UUID uuid = UUID.randomUUID();
        String cid = uuid.toString();
        cid = cid.replace("-", "");

        //封装一个Customer对象
        Customer customer = new Customer(cid, cname, gender, birthday, cellphone, email, description);

        //调用service添加客户
        customerService.addCustomer(customer);
        return "redirect:/msg.jsp";
    }

    public String editCustomer(HttpServletRequest request, HttpServletResponse response) {

        //获取请求参数
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        Date date = DateUtil.strToDate(birthday, "yyyy-MM-dd");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        Customer customer = new Customer(cid, cname, gender, date, cellphone, email, description);
        try {
            customerService.editCustomer(customer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "redirect:/msg.jsp";
    }

    public String deleteCustomerById(HttpServletRequest request, HttpServletResponse response) {
        //获取客户id
        String cid = request.getParameter("cid");
        try {
            customerService.deleteCustomerById(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/CustomerServlet?method=findAllCustomer";
    }

    public String findCustomerById(HttpServletRequest request, HttpServletResponse response) {

        //获取客户的id
        String cid = request.getParameter("cid");
        try {
            Customer customer = customerService.findCustomerById(cid);
            request.setAttribute("customer", customer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "forward:/edit.jsp";
    }

    /**
     * 使用分页查询
     *
     * @param request
     * @param response
     * @return
     */
    public String findAllCustomer(HttpServletRequest request, HttpServletResponse response) {

        //获取当前页码
        Integer cp = getCurrentPage(request);
        //设置每页记录数
        Integer pr = 5;
        //创建PageBean对象  封装  分页的参数
        PageBean<Customer> pageBean = new PageBean<Customer>();
        pageBean.setPr(pr);
        pageBean.setCp(cp);
        try {
            pageBean = customerService.findAllCustomer(pageBean);
            request.setAttribute("pageBean", pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/list.jsp";
    }

    /**
     * 高级搜索
     *
     * @param request
     * @param response
     * @return
     */
    public String query(HttpServletRequest request, HttpServletResponse response) {

        //获取请求参数
        String cname = request.getParameter("cname");
        String gender = request.getParameter("gender");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        //封装Customer对象
        Customer customer = new Customer();
        customer.setCname(cname);
        customer.setGender(gender);
        customer.setCellPhone(cellphone);
        customer.setEmail(email);
        //得到当前页
        Integer cp = getCurrentPage(request);
        //每页记录数
        Integer pr = 5;
        //调用service
        PageBean<Customer> pb = null;
        try {
            pb = customerService.query(customer, cp, pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存到request域
        request.setAttribute("pageBean", pb);

        return "forward:/list.jsp";
    }

    /**
     * 获取当前页的页码
     *
     * @param request
     * @return
     */
    private int getCurrentPage(HttpServletRequest request) {

        String cp = request.getParameter("cp");
        if (cp == null) {
            return 1;
        }
        return Integer.parseInt(cp);
    }
}
