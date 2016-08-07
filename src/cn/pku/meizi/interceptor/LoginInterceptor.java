package cn.pku.meizi.interceptor;


import cn.pku.meizi.domain.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sunbo on 16/7/29.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*HttpSession session=httpServletRequest.getSession();
        Manager curManager=(Manager) session.getAttribute("curManager");
        if(curManager==null)
            httpServletResponse.sendRedirect("login");*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session=httpServletRequest.getSession();
        Manager curManager=(Manager) session.getAttribute("curManager");
        if(curManager==null)
            httpServletResponse.sendRedirect("/manager/login");
        //httpServletResponse.sendRedirect("/page/login/user_login");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
