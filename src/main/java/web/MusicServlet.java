package web;

import dao.MusicDao;
import model.Music;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MusicServlet  extends HttpServlet {

    private static final Long serialVersionUID = 1L;
    private MusicDao dao;

    public MusicServlet()throws ClassNotFoundException, SQLException{
        super();
        this.dao = new MusicDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.getWriter().append("Server at:").append(req.getContextPath());
        RequestDispatcher index = req.getRequestDispatcher("index.jsp");
        try{
            req.setAttribute("musics", dao.getAllMusics());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        index.forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        Music music = new Music(1, req.getParameter("name"), Double.parseDouble(req.getParameter("duration")));
        dao.addMusic(music);
    }
}
