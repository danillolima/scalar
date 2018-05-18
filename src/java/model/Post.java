package model;
import java.nio.file.Files;

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
    private int publish_by;
    private String content;
    private Files[] anexos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublish_by() {
        return publish_by;
    }

    public void setPublish_by(int publish_by) {
        this.publish_by = publish_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Files[] getAnexos() {
        return anexos;
    }

    public void setAnexos(Files[] anexos) {
        this.anexos = anexos;
    }
}
