package web;

import config.MyFeatureManagerProvider;
import org.togglz.core.user.SimpleFeatureUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static config.MyFeatureManagerProvider.*;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 3:30 PM
 */
public class FeaturesServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        try {
            String login = (String) hreq.getSession().getAttribute("login");
            if (login != null) {
                bind(new SimpleFeatureUser(login, login.equals("admin")));
            }
            chain.doFilter(request, response);
        } finally {
            release();
        }
    }

    @Override
    public void destroy() {
    }
}
