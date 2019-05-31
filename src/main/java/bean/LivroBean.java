/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import modelo.Livro;

import modelo.Usuario;

/**
 *
 * @author Suporte
 */
@ManagedBean(name = "livro")

public class LivroBean {

    @ManagedProperty(value = "#{sessionScope['usuario-logado']}")
    Usuario usuario;

    Livro livro;

    public LivroBean() {
        livro = new Livro();

    }

    public void salvar() {
        System.out.println(livro);
        System.out.println(usuario);
        System.out.println(usuario.getListaLivros());
        FacesContext context = FacesContext.getCurrentInstance();
      
       	if(!usuario.getListaLivros().contains(livro)){
			
			usuario.getListaLivros().add(livro);
			livro = new Livro();
	
			
			FacesMessage mensagem = new FacesMessage("Cadastro de livro realizado com sucesso !!");
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, mensagem);
			
		}
		this.livro = new Livro();

        this.livro = new Livro();

    }

    public void editarLivro(Livro l) {
        this.livro = l;
    }

    public void removerLivro(Livro livro) {
        System.out.println(livro);

        FacesContext context = FacesContext.getCurrentInstance();

        usuario.getListaLivros().remove(livro);

        FacesMessage mensagem = new FacesMessage("livro removido com sucesso !!");
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, mensagem);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
