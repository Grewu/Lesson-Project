package servlet;

import com.google.gson.Gson;
import dao.BankDao;
import dao.impl.BankDaoImpl;
import data.BankDto;
import mapper.BankMapper;
import mapper.BankMapperImpl;
import service.api.BankService;
import service.impl.BankServiceImpl;
import util.json.JsonHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {
    private final BankMapper mapper = new BankMapperImpl();
    private final BankDao bankDao = new BankDaoImpl();

    private final BankService bankService = new BankServiceImpl(mapper, bankDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            Long id = Long.valueOf(req.getParameter("id"));
            String json = new Gson().toJson(bankService.findById(id));
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        BankDto bankDto = gson.fromJson(json, BankDto.class);
        bankService.create(bankDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonHandler.getJson(req);
        Gson gson = JsonHandler.getGsonFormat();
        BankDto bankDto = gson.fromJson(json, BankDto.class);
        bankService.update(bankDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        bankService.delete(id);
        String json = new Gson().toJson("Bank with id " + id + "has been deleted");
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }
}
