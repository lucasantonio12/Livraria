/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 *
 * @author lucas
 */
@ManagedBean(name = "login", eager = true)
@ApplicationScoped
public class LoginBean {

    @ManagedProperty(value = "#{livraria.listaUsuario}")
    private List<Usuario> listaUsuario;

    private Usuario usuario;

    public LoginBean() {
        this.listaUsuario = new ArrayList<Usuario>();
        this.usuario = new Usuario();
    }

    public void cadastra() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.listaUsuario.add(this.usuario);
        FacesMessage mensagem = new FacesMessage("Cadastro Feito com Sucesso");
        context.addMessage(null, mensagem);
        this.usuario = new Usuario();
    }

    public String validar() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("ESTOU AQUI");

        for (Usuario u : this.listaUsuario) {

            if (u.getLogin().equals(this.getUsuario().getLogin())) {

                if (u.getSenha().equals(this.getUsuario().getSenha())) {

                    if (u.isAdmin() == true) {
                        System.out.println("ENTROU NO ADMIN");
                        ExternalContext ec = context.getExternalContext();
                        HttpSession s = (HttpSession) ec.getSession(true);
                        s.setAttribute("admin-logado", u);
                        this.usuario = new Usuario();
                        return "/admin/bemVindoAdmin";
                    } else {
                        System.out.println("ENTROU NO USUARIO");
                        ExternalContext ec = context.getExternalContext();
                        HttpSession s = (HttpSession) ec.getSession(true);
                        s.setAttribute("usuario-logado", u);
                        this.usuario = new Usuario();
                        return "/user/bemVindoUser";
                    }

                }
            }

        }
        FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, mensagem);
        return "";
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
