package com.ozel.minibankingapp.Model.Enum;

public enum TransactionStatusEnum {

    SUCCESS("Success"),
    FAILED("Failed");

    private final String status;
    TransactionStatusEnum(String status){
        this.status = status;
    }

    public String getTransactionStatusEnum(){
        return this.status;
    }

    public static TransactionStatusEnum getStatusFromValue(String source) {
        return TransactionStatusEnum.valueOf(source.toUpperCase());
    }
}
