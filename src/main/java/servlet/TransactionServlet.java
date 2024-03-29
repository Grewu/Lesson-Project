package servlet;

import com.google.gson.Gson;
import dao.RepositoryBase;
import dao.impl.TransactionDaoImpl;
import data.TransactionDto;
import entity.Transaction;
import lombok.RequiredArgsConstructor;
import mapper.DtoEntityMapper;
import mapper.TransactionMapperImpl;
import org.hibernate.SessionFactory;
import service.api.TransactionService;
import service.impl.TransactionServiceImpl;
import util.hibernate.HibernateUtil;
import util.json.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transaction")
@RequiredArgsConstructor
public class TransactionServlet extends HttpServlet {
    private final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private final DtoEntityMapper<Transaction, TransactionDto> mapper = new TransactionMapperImpl();
    private final RepositoryBase<Long, Transaction, TransactionDto> transactionRepositoryBase = new TransactionDaoImpl(sessionFactory, mapper);

    private final TransactionService transactionService = new TransactionServiceImpl(mapper, transactionRepositoryBase);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            Long id = Long.valueOf(req.getParameter("id"));
            String json = new Gson().toJson(transactionService.findById(id));
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        TransactionDto transactionDto = gson.fromJson(json, TransactionDto.class);
        transactionService.create(transactionDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        TransactionDto transactionDto = gson.fromJson(json, TransactionDto.class);
        transactionService.update(transactionDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        transactionService.delete(id);
        String json = new Gson().toJson("Transaction with id " + id + "has been deleted");
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }
}
