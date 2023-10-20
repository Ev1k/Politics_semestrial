package com.derezhenko.server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTIONS_COUNT = 100;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Upload - doPost");
        Part part = req.getPart("photo");
        System.out.println("after part");

        String filename = Paths.get(part.getSubmittedFileName()).toString();

        File file = new File(/*FILE_PATH_PREFIX  + File.separator +*/ filename);

        part.write(filename);
        resp.setContentType(filename);


//        req.setAttribute("image", filename);
//        resp.sendRedirect(getServletContext().getContextPath() + "/account.jsp");
        HttpSession session = req.getSession();
        session.setAttribute("image-user", filename);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/account.jsp");
        requestDispatcher.forward(req, resp);
    }
}
