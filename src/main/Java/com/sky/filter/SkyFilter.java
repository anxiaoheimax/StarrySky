package com.sky.filter;


import com.sky.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SkyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        String flag=servletPath.substring(servletPath.lastIndexOf(".")+1,servletPath.length());
        System.out.println("houzh:"+flag);
        System.out.println("请求路经"+servletPath);
        if (servletPath.equals("/Login.html")  ) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(servletPath.equals("/Front/index.html")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(servletPath.equals("/User/fondUser.action")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else if(flag.equals("js")|flag.equals("css")|flag.equals("ico")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else {
            //判断用户是否登录
            User user=(User)request.getSession().getAttribute("user");
            if(user==null){
                response.sendRedirect("/Login.html");
            }else{
                filterChain.doFilter(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
