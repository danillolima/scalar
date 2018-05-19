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

public class Post {
    
    private int id;
    private String title;
    private String publish_by;
    private String content;
    private String img;
    private String video;
    private String hora;
   
    public Post(String title, String publish_by, String content, String img, String video) {
        this.title = title;
        this.publish_by = publish_by;
        this.content = content;
        this.img = img;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublish_by() {
        return publish_by;
    }

    public void setPublish_by(String publish_by) {
        this.publish_by = publish_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
        public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    public static void savePost(Post newPost){
        Connection c;
        c = ConMySQL.conecta();
        PreparedStatement p;
        ResultSet r;
          try{
              // insert into posts values("a post", null, null, null, "14494d49-5b87-11e8-b245-80ee7335c3ca");
            p = c.prepareStatement(" insert into posts values(default, default, ?, ?, ?, ?, ?)");
            p.setString(1, newPost.getTitle());
            p.setString(2, newPost.getContent());
            p.setString(3, newPost.getVideo());
            p.setString(4, newPost.getImg());
            p.setString(5, newPost.getPublish_by());
            p.executeUpdate();
        }catch(SQLException e){
            
        }
    }
}
