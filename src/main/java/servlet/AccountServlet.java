package servlet;

import com.google.gson.Gson;
import dao.RepositoryBase;
import dao.impl.AccountDaoImpl;
import data.AccountDto;
import entity.Account;
import mapper.AccountMapperImpl;
import mapper.DtoEntityMapper;
import org.hibernate.SessionFactory;
import service.api.AccountService;
import service.impl.AccountServiceImpl;
import util.hibernate.HibernateUtil;
import util.json.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private final DtoEntityMapper<Account, AccountDto> mapper = new AccountMapperImpl();
    private final RepositoryBase<Long, Account, AccountDto> accountRepositoryBase = new AccountDaoImpl(sessionFactory, mapper);

    private final AccountService accountService = new AccountServiceImpl(mapper, accountRepositoryBase);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<AccountDto> accountOptional = accountService.findById(id);

        if (accountOptional.isPresent()) {
            AccountDto account = accountOptional.get();
            String json = new Gson().toJson(account);
            resp.getWriter().write(json);
            resp.setStatus(200);
        } else {
            resp.setStatus(404); // Возвращаем статус 404, если запись не найдена
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
