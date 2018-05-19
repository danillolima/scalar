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
import model.Usuario;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println(getServletContext().getInitParameter("upload.location"));
            
        }
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
        if(request.getParameter("action") != null){
            if(request.getParameter("action").equals("1")){
                request.getSession().invalidate();
                response.sendRedirect("login");
            }
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String msg = "";
        
        if(request.getParameter("action").equals("2")){
           
            Usuario newUser = new Usuario(); 
            String user = null, pass = null, mail = null, adress = null;
            if(request.getParameter("user")!= null && request.getParameter("user").equals("") == false)
                user = request.getParameter("user");
            else
                msg = msg + "<li>Usuário vazio</li>";
                
            if(request.getParameter("pass") != null && request.getParameter("pass").equals("") == false){
                pass = request.getParameter("pass");
            }
            else
                msg = msg + "<li>Senha vazia</li>";
                        
            if(request.getParameter("mail") != null  && request.getParameter("mail").equals("") == false)
                mail = request.getParameter("mail");
            else
                msg = msg + "<li>E-mail vazio</li>";
            
            if(request.getParameter("adress") != null  && request.getParameter("adress").equals("") == false){
                adress = request.getParameter("adress");
            }
            if(!msg.equals("")){
                request.getSession().setAttribute("message", msg);
                response.sendRedirect("cadastro");
                //request.getRequestDispatcher("/scalar/cadastro").forward(request, response);
            }
            else{
                Usuario.saveUsuario(new Usuario(user, mail,  pass, adress));
                response.sendRedirect("login");
            }
        }
        if(request.getParameter("action").equals("3")){
        
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
