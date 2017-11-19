package by.nc.school.dev.example.servlet.web.filter;

import by.nc.school.dev.example.servlet.web.provider.ModelProvider;
import by.nc.school.dev.example.servlet.web.provider.ModelProviderFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class ModelProvidersFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ModelProvider modelProvider = new ModelProviderFactory().getInstance(request.getRequestURI());
        if (modelProvider != null) {
            modelProvider.fillRequest(request);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
