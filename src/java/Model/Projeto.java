/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author thiag
 */

@SessionScoped
@ManagedBean
public class Projeto {
    
    public Projeto(int id, String nomeProjeto, String descProjeto)
    {
        this.descProjeto = descProjeto;
        this.id = id;
        this.nomeProjeto = nomeProjeto;
    }
    
    private int id;
    private String nomeProjeto;
    private String descProjeto;

    public String getDescProjeto() {
        return descProjeto;
    }

    public int getId() {
        return id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setDescProjeto(String descProjeto) {
        this.descProjeto = descProjeto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
    
           
}
