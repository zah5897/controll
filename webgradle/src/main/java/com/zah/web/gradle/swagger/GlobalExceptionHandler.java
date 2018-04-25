package com.zah.web.gradle.swagger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zah on 2018/1/11.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String allExceptionHandler(HttpServletRequest request,
                                      Exception exception) throws Exception {
        exception.printStackTrace();
        System.out.println("我报错了：" + exception.getLocalizedMessage());
        System.out.println("我报错了：" + exception.getCause());
        System.out.println("我报错了：" + exception.getSuppressed());
        System.out.println("我报错了：" + exception.getMessage());
        System.out.println("我报错了：" + exception.getStackTrace());
        return "服务器异常，请联系管理员！";
    }

}
