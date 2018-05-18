package model;
import java.sql.*;
import libs.ConMySQL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aluno
 */
public class Usuario {

    private int id;
    private String user;
    private String email;
    private String senha;
    private String endereco;
   
    public Usuario() {
       user = null;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
     public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static Usuario getUsuario(String user){
        Connection c;
        c = ConMySQL.conecta();
        PreparedStatement p;
        ResultSet r;
        Usuario userFound = null;
        try{
            p = c.prepareStatement("select * from users where user = ?");
            p.setString(1, user);
            r = p.executeQuery();
            if(r.next()){
                userFound = new Usuario();
                userFound.setId(r.getInt("idUser"));
                userFound.setSenha(r.getString("pass"));
                userFound.setEmail(r.getString("email"));
                userFound.setUser(r.getString("user"));
                userFound.setEndereco(r.getString("adress"));
            }
        }catch(SQLException e){
            
        }
        return userFound;
    }
}
