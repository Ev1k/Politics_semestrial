package com.derezhenko.server;

import com.derezhenko.dao.impl.UserDaoImpl;
import com.derezhenko.model.User;
import com.derezhenko.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTIONS_COUNT = 100;

    private final UserDaoImpl userDao;

    public AccountServlet(UserDaoImpl userDao) {
        this.userDao = UserDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Upload - doPost");
        Part part = req.getPart("photo");
        System.out.println("after part");

        String filename = Paths.get(part.getSubmittedFileName()).toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        File file = new File(uploadDir, filename);
        try (InputStream input = part.getInputStream()) {
            if (!Files.exists(file.toPath())) {
                Files.copy(input, file.toPath());
            }
        }

        HttpSession session = LoginServlet.getSession();
        session.setAttribute("image-user", filename);

        Connection connection = DatabaseConnectionUtil.getConnection();

        // апдейт фото в бд
        int userId = Integer.parseInt((String) session.getAttribute("userId"));
        req.setAttribute("userId", userId);

        User user = userDao.get(userId);
        req.setAttribute("user", user);
        String sql = "UPDATE users SET photo = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filename);
            statement.setInt(2, userId);

            int rowsAffected = statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/account");
    }
}
