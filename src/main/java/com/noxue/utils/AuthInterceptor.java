package com.noxue.utils;

import com.noxue.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by noxue on 2017/4/4.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    private UserService getUserService(HttpServletRequest request) {

        if (userService == null) {//解决service为null无法注入问题
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userServiceImpl");
        }

        return userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String url = request.getRequestURI();
        if(!url.startsWith("/admin")){
            return true;
        }

        // 没有登陆，就跳转到登陆界面
        if(!getUserService(request).CheckLogin(request)) {
            response.getWriter().println("<html><head><meta charset=\"utf-8\" /><meta http-equiv=\"refresh\" content=\"1; url="+getUserService(request).GetLoginUrl()+"\" /></head><body>redirect to login ...... </body</html>");
            response.getWriter().flush();
            return false;
        }
        return true;
    }


}
