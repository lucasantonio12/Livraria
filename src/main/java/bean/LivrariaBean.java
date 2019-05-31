/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

/**
 *
 * @author lucas
 */
@ManagedBean(name = "livraria", eager = true)
@ApplicationScoped
public class LivrariaBean {

    private Usuario usuario;
    private List<Usuario> listaUsuario;

    public LivrariaBean() {
        Date d1 = new GregorianCalendar(1986, Calendar.FEBRUARY, 03).getTime();
        Usuario u = new Usuario("Lucas antonio", "(84)999-999-999", d1, "123.456.789-10", "admin", "admin", true);
        Usuario u2 = new Usuario("Lucas antonio", "(84)999-999-999", d1, "123.456.789-10", "user", "user", false);

        this.usuario = new Usuario();
        this.listaUsuario = new ArrayList<Usuario>();
        
        listaUsuario.add(u);
        listaUsuario.add(u2);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
