package com.knowonespace.longblack.exception;

import com.knowonespace.longblack.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice//拦截异常用
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)//表示拦截异常
    @ResponseBody
    public Object handleException(Exception e){
        log.error("Default Exception:", e);
        return ApiRestResponse.error(LongBlackExceptionEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(LongblackException.class)//表示拦截业务异常
    @ResponseBody
    public Object handleMallException(LongblackException e){
        log.error("LongblackException:", e);
        return ApiRestResponse.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        //MethodArgumentNotValidException入参1是一个特殊异常，方法校验异常
        log.error("MethodArgumentNotValidException:", e);//首先打出日志
        return handleBindingResult(e.getBindingResult());//返回是调用一个方法处理
    }

    private ApiRestResponse handleBindingResult(BindingResult result) {
        //入参BindingResult，我们这个方法是把BindingResult绑定的异常处理成返回的结果
        //把异常处理为对外暴露的提示
        List<String> list=new ArrayList<>();//把所有错误提示的错误信息都放入这个列表
        if (result.hasErrors()) {//检查是否包含错误
            List<ObjectError> allErrors=result.getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {//如果包含先拿到包含错误的列表
                ObjectError objectError= allErrors.get(i);//得到所有的错误
                String message=objectError.getDefaultMessage();//得到错误中的信息
                list.add(message);//添加错误信息
            }
        }
        if (list.size() == 0) {
            return ApiRestResponse.error(LongBlackExceptionEnum.REQUEST_PARAM_ERROR);//如果list是空，传入参数错误异常，因为没有定义好的错误信息
        }
        return ApiRestResponse.error(LongBlackExceptionEnum.REQUEST_PARAM_ERROR.getCode(), list.toString());//如果有信息就传入参数错误的code，和具体错误信息
    }

}
