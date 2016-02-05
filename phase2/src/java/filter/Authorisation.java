/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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

/**
 *
 * @author chike189
 */
@WebFilter(filterName = "Authorisation", urlPatterns = {"/restricted/*"})
public class Authorisation implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // cast the request and reponse objects into something useful
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // get the session
        HttpSession session = httpRequest.getSession();
        // is the customer object in the session?

        if (session.getAttribute("customer") == null) { // get the requested page
            String requestedPath = httpRequest.getRequestURI();
            // save it so that it can be used later
            session.setAttribute("requestedPath", requestedPath);
            //send back an UNAUTHORIZED response and a nice error message
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "You need to log in to view that page.");
        } else {
            //user already logged in so pass the request on unmodified
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
