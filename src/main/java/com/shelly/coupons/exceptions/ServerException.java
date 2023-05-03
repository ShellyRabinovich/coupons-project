package com.shelly.coupons.exceptions;
import com.shelly.coupons.enums.ErrorType;
public class ServerException extends Exception{
        private ErrorType errorType;

        public ServerException(ErrorType errorType,String message){
            //in case the error message is a string
            super(errorType.getErrorMessage()+", "+ message);
            this.errorType=errorType;
        }
        public ServerException(ErrorType errorType,String message,Exception e){
            super(errorType.getErrorMessage()+", "+message,e);
            this.errorType=errorType;

        }

        public ServerException(ErrorType errorType,int message){
            //in case the error message is an int
            super(errorType.getErrorMessage()+", "+ message);
            this.errorType=errorType;
        }
        public ErrorType getErrorType(){
            return errorType;
        }
    }


