package com.ozel.minibankingapp.Exceptions;

public class UserDoesNotExist extends Exception {
    public UserDoesNotExist(String message){
        super(message);
    }
    public UserDoesNotExist(){
        super();
    }
}
