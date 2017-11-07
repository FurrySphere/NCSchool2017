package by.nc.school.dev.example.spring.beans.web.filter;

import by.nc.school.dev.example.spring.beans.web.provider.ModelProvider;
import by.nc.school.dev.example.spring.beans.web.provider.ModelProviderFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class ModelProvidersFilter implements Filter {

    protected static ModelProviderFactory modelProviderFactory;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ModelProvider modelProvider = modelProviderFactory.getInstance(request.getRequestURI());
        if (modelProvider != null) {
            modelProvider.fillRequest(request);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    public static void setModelProviderFactory(ModelProviderFactory modelProviderFactory) {
        ModelProvidersFilter.modelProviderFactory = modelProviderFactory;
    }
}
