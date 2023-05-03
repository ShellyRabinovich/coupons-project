package com.shelly.coupons.enums;

public enum ErrorType {
        INVALID_PRICE(1, "Please enter a valid price", false),
        INVALID_START_DATE(2, "The start date of the coupon can't be later than it's end date", false),
        GENERAL_ERROR(3, "There seems to be a problem, please try again later", true),
        UNMATCHED_USER_NAME_AND_PASSWORD(4, "Incorrect user name/password", false),
        INVALID_PASSWORD(5, "Invalid password", false),
        INVALID_USER_NAME(6, "Invalid user name", false),
        USER_NAME_ALREADY_EXIST(7, "This user name is already taken, please enter another one", false),
        INVALID_AMOUNT(8, "Amount cannot be negative", false),
        INVALID_COUPON_NAME(9, "Name has to be at least 8 letters", false),
        INVALID_COMPANY_NAME(10, "Name has to be at least 3 letters", false),
        INVALID_CATEGORY_NAME(11, "Category's name has to be at least 3 letters", false),
        INVALID_ADDRESS(12, "Please fill full address", false),
        INVALID_PHONE_NUMBER(13, "Please enter a valid phone number", false);
        private int errorNumber;
        private String errorMessage;
        private boolean isShowStackTrace;

        ErrorType(int errorNumber, String errorMessage, boolean isShowStackTrace) {
            this.errorNumber = errorNumber;
            this.errorMessage = errorMessage;
            this.isShowStackTrace = isShowStackTrace;
        }

        ErrorType(int errorNumber, String errorMessage) {
            this.errorNumber = errorNumber;
            this.errorMessage = errorMessage;
        }

        ErrorType(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public boolean isShowStackTrace() {
            return isShowStackTrace;
        }

    public int getErrorNumber() {
        return errorNumber;
    }
}




