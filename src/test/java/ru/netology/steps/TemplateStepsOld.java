package ru.netology.steps;

import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.netology.page.LoginPage;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
//import ru.netology.data.DataHelper.getAuthInfo;
import ru.netology.page.VerificationPage;
import ru.netology.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.getAuthInfo;

public class TemplateStepsOld {
    private static DashboardPage dashboardPage;
    //private static VerificationPage verificationPage;
    //private static TransferPage transferPage;

    @Пусть("Пусть пользователь залогинен с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        var loginPage = open("http:localhost:9999/", LoginPage.class);
        var verificationPage = loginPage.validLogin(DataHelper.AuthInfo.login, DataHelper.AuthInfo.password);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Когда("Когда он переводит {string} рублей с карты с номером {string} на карту с номером {string}")
    public void makeTransfer(String amount, String debitCardNumber, String creditCardNumber) {
        var transferPage = dashboardPage.selectCardToTransfer(Integer.parseInt(creditCardNumber));
        dashboardPage = transferPage.makeTransfer(String.valueOf(amount), DataHelper.CardInfo.debitCardNumber);
    }

    @Тогда("Тогда баланс его {string} карты из списка на главной странице должен стать {string} рублей")
    public void verifyCreditBalance(String creditCardNumber, String expectedCardBalance) {
        var actualCreditBalance = dashboardPage.getCardBalance(Integer.parseInt(DataHelper.CardInfo.creditCardNumber));
        assertEquals(expectedCreditBalance, actualCreditBalance);
    }
}
