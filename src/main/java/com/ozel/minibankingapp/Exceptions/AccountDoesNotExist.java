package com.ozel.minibankingapp.Exceptions;

public class AccountDoesNotExist extends Exception {
    public AccountDoesNotExist(String message){
        super(message);
    }
    public AccountDoesNotExist(){
        super();
    }
}
