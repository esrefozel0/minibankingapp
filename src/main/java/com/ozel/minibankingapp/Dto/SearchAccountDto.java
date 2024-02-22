package com.ozel.minibankingapp.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchAccountDto {

  private String name = "";
  private String number = "";

  public SearchAccountDto(String name, String number){
    setName(name);
    setNumber(number);
  }
}
