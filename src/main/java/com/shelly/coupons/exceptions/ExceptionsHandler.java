package com.shelly.coupons.exceptions;


import com.shelly.coupons.dto.ErrorBean;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
    public class ExceptionsHandler {

        //	Response - Object in Spring
        @ExceptionHandler
        @ResponseBody
        // Variable name is throwable in order to remember that it handles Exception and Error
        public ErrorBean toResponse(Throwable throwable, HttpServletResponse response) {

            //	ErrorBean errorBean;
            if(throwable instanceof ServerException) {

                ServerException serverException = (ServerException) throwable;

                ErrorType errorType = serverException.getErrorType();
                int errorCode = errorType.getErrorNumber();
                String errorMessage = errorType.getErrorMessage();
//                String errorName = errorType.getErrorName();
                response.setStatus(errorCode);

                if(serverException.getErrorType().isShowStackTrace()) {
                    serverException.printStackTrace();
                }

                ErrorBean errorBean = new ErrorBean(errorCode ,errorMessage);


                return errorBean;
            }

            response.setStatus(600);

            String errorMessage = throwable.getMessage();
            ErrorBean errorBean = new ErrorBean(601, "General error");
            throwable.printStackTrace();

            return errorBean;
        }

    }


