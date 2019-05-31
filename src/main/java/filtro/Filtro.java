/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author lucas
 */
@WebFilter("/admin/*")
public class Filtro implements Filter{

    public Filtro() {
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
     
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Usuario u = null;
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		
		if(session != null){
			u = (Usuario) session.getAttribute("admin-logado");
		}
		
		if (u == null){
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/index.xhtml");
		} else {
			chain.doFilter(request, response);
		}
    }

    @Override
    public void destroy() {
    }
    
}
