package com.itheima.exception;

import com.itheima.domain.MyException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //当程序出现异常里面方法会执行
        MyException myException = null;
       if (e instanceof MaxUploadSizeExceededException){
            myException = new MyException("文件大与了2mb!!");
        }else {
            myException = new MyException("系统正在维护");
        }
        if(e!=null){
            e.printStackTrace();
        }
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        String massage = myException.getMassage();
        System.out.println(massage);
        mv.addObject("errorMsg",myException.getMassage());
        mv.setViewName("/WEB-INF/pages/error.jsp");
        //System.out.println("我执行了");
        return mv;

    }
}
