package org.study.design.design.delegationpattern.simple;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.study.design.design.delegationpattern.simple.controller.OrderController;
import org.study.design.design.delegationpattern.simple.controller.SystemController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: design
 * @description: DispatcherServlet 调度服务实现，简单示例
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 11:16
 **/
@Component
public class DispatcherServlet extends HttpServlet {
    // 调度服务实现类
    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 根据不同的 Url 请求，调用不同的方法
        String uri = request.getRequestURI();
        String mid = request.getParameter("mid");

        if("getMemberById".equals(uri)) {
            new MemberController().getMemberById(mid);
        } else if("getOrderById".equals(uri)) {
            new OrderController().getOrderIdByClientId(mid);
        } else if("doSomethingInterest".equals(uri)) {
            new SystemController().doSomethingInteresting(mid);
        } else {
            response.getWriter().write("404 Not Found!");
        }
    }

    @GetMapping("/service/testDispatcher")
    // 调度服务对外接口 因为不是真实的分发类，需要自己开放 请求接口
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try{
            doDispatch(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
