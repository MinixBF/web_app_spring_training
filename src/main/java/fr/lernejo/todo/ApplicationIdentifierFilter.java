package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements Filter {
    private final String applicationIdentifier;

    public ApplicationIdentifierFilter () {
        applicationIdentifier = UUID.randomUUID().toString();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ((HttpServletResponse)servletResponse).setHeader("Instance-Id", applicationIdentifier);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
