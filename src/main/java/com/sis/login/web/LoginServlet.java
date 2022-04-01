package com.sis.login.web;

import com.sis.login.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ClassName: LoginServlet
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2022/3/8 16:04
 * @Version: 1.0
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        // 校验用户名密码

        LoginService loginService = new LoginService();
        if (loginService.login(userName, userPassword)) {
            req.setAttribute("userName",userName);
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }

        req.setAttribute("msg","用户名密码错误！登录失败！");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

}
