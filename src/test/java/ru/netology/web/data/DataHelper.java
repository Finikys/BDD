package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  @Value
  public static class CardInfo {
    private String firstNumber;
    private String secondNumber;
    private String addMoney;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

//  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
//    return new AuthInfo("petya", "123qwerty");
//  }

  public static CardInfo getCardInfo(){return new CardInfo("5559 0000 0000 0002","5559 0000 0000 0002", "2000");}
  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }


}
