package com.derezhenko.server;

import com.derezhenko.model.User;
import com.derezhenko.server.seevice.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateUserServlet extends HttpServlet {

    private final UserService service;

    public UpdateUserServlet(UserService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        int userId = Integer.parseInt((String) session.getAttribute("userId"));
        String res = "?";
        if(password.equals(password2)){
            User user2 = new User(userId, name, email, phone, password);
            if(service.updateInfo(user2)){
                res = "success changing info";
            } else {
                res = "falling changing info";
            }
            session.setAttribute("username", user2.getName());
            session.setAttribute("email", user2.getEmail());
            session.setAttribute("phone", user2.getPhone_number());
            session.setAttribute("password", user2.getPassword());
        }
        System.out.println(res);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("account.jsp");
        requestDispatcher.forward(req, resp);
    }
}
