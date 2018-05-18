package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import libs.ConMySQL;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/user"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        if(request.getParameter("logout").equals("1")){
            request.getSession().invalidate();
            response.sendRedirect("login");
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *https://stackoverflow.com/questions/13274279/authentication-filter-and-servlet-for-login?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        PreparedStatement p;
        ResultSet r;
        Connection c;
        String m;
        try{
            c = ConMySQL.conecta();
            p = c.prepareStatement("SELECT * FROM users where user = ? AND pass = ?");
            p.setString(1, user);
            p.setString(2, pass);
            r = p.executeQuery();
            if(r.next()){       
                request.getSession().setAttribute("logado", true);
                request.getSession().setAttribute("user", r.getString("user"));
                response.sendRedirect("/scalar/publicar");
            }
            else{
                m = "Usuario ou senha estão incorretos.";
                response.sendRedirect("/scalar/login");
            }
        }catch(SQLException e){
           e.printStackTrace();
        }
        
        
        processRequest(request, response);
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
