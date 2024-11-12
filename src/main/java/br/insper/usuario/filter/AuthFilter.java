package br.insper.usuario.filter;

import br.insper.usuario.service.UsuarioService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = request.getHeader("Authorization");

        if (request.getServletPath().equals("/usuario") && request.getMethod().equals("GET")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (request.getServletPath().equals("/usuario/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (usuarioService.verifyToken(token)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Unauthorized: Token is missing or invalid.");
        }


    }
}
