package com.ozel.minibankingapp.Model.Enum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TransactionStatusConverter implements AttributeConverter<TransactionStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(TransactionStatusEnum attribute) {
        return attribute.getTransactionStatusEnum();
    }
    @Override
    public TransactionStatusEnum convertToEntityAttribute(String dbData) {
        return TransactionStatusEnum.getStatusFromValue(dbData);
    }
}