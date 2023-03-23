package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");

  private ElementsCollection cards = $$(".list__item div");
  private final String balanceStart = "баланс: ";
  private final String balanceFinish = " р.";


  public int getFirstCardBalance() {
    val text = cards.first().text();
    return extractBalance(text);
  }

  private int extractBalance(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
  }

  public DashboardPage() {
    heading.shouldBe(visible);
    $("[data-test-id='action-deposit']").click();
    $("[class='heading heading_size_xl heading_theme_alfa-on-white']").shouldBe(visible);
    $("[type='text']").setValue(DataHelper.getCardInfo().getAddMoney());
    $("[type='tel']").setValue(DataHelper.getCardInfo().getSecondNumber());
    $("[class='button__text']").click();
    $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").shouldHave(Condition.text(String.valueOf(getFirstCardBalance())));

  }





}
