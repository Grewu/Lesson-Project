package servlet;

import com.google.gson.Gson;
import dao.RepositoryBase;
import dao.impl.UserDaoImpl;
import data.UserDto;
import entity.User;
import lombok.RequiredArgsConstructor;
import mapper.DtoEntityMapper;
import mapper.UserMapperImpl;
import org.hibernate.SessionFactory;
import service.api.UserService;
import service.impl.UserServiceImpl;
import util.hibernate.HibernateUtil;
import util.json.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
@RequiredArgsConstructor
public class UserServlet extends HttpServlet {
    private final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private final DtoEntityMapper<User, UserDto> mapper = new UserMapperImpl();
    private final RepositoryBase<Long, User, UserDto> userRepositoryBase = new UserDaoImpl(sessionFactory, mapper);

    private final UserService userService = new UserServiceImpl(mapper, userRepositoryBase);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json;
        try (PrintWriter out = resp.getWriter()) {
            Long id = Long.valueOf(req.getParameter("id"));
            json = new Gson().toJson(userService.findById(id));
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        UserDto userDto = gson.fromJson(json, UserDto.class);
        userService.create(userDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        UserDto userDto = gson.fromJson(json, UserDto.class);
        userService.update(userDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        userService.delete(id);
        String json = new Gson().toJson("User with id " + id + "has been deleted");
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }
}