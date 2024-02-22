package com.ozel.minibankingapp.Exceptions;

public class UsersAccountDoesNotExist extends Exception {
    public UsersAccountDoesNotExist(String message){
        super(message);
    }
    public UsersAccountDoesNotExist(){
        super();
    }
}
