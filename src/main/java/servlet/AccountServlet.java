package servlet;

import com.google.gson.Gson;
import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import data.AccountDto;
import lombok.extern.slf4j.Slf4j;
import mapper.AccountMapper;
import mapper.AccountMapperImpl;
import service.api.AccountService;
import service.impl.AccountServiceImpl;
import util.json.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/accounts/changeBalance")
public class AccountServlet extends HttpServlet {
    private  AccountMapper mapper = new AccountMapperImpl();
    private  AccountDao accountDao = new AccountDaoImpl();

    private  AccountService accountService = new AccountServiceImpl(mapper, accountDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            Long id = Long.valueOf(req.getParameter("id"));
            String json = new Gson().toJson(accountService.findById(id));
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        AccountDto accountDto = gson.fromJson(json, AccountDto.class);
        accountService.create(accountDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        AccountDto accountDto = gson.fromJson(json, AccountDto.class);
        accountService.update(accountDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        accountService.delete(id);
        String json = new Gson().toJson("Account with id " + id + "has been deleted");
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }
}