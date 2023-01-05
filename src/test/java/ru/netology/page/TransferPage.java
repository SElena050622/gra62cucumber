package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.DashboardPage;
import ru.netology.page.VerificationPage;
import ru.netology.steps.TemplateStepsOld;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement toInput = $("[data-test-id='to'] input"); // добавлено для работы нового makeTransfer
    // а в  DataHelper есть два номера карт, тогда это зачем?
    private SelenideElement transferHead = $(byText("Пополнение карты"));
    private SelenideElement errorMessage = $("[data-test-id='error-message']");

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    /* public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();  // закомичено для String  TemplateStepsOld, но все-равно не принимается Идеей
    } */

    public DashboardPage makeValidTransfer(String amount, String debitCardNumber, String creditCardNumber) {
        makeTransfer(amount, debitCardNumber, creditCardNumber);
        return new DashboardPage();
    }

    /* public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click(); // закомичено для String  TemplateStepsOld, но все-равно не принимается Идеей
    } */

    public void makeTransfer(String amount, String debitCardNumber, String creditCardNumber) {
        amountInput.setValue(amount);
        fromInput.setValue(debitCardNumber);
        toInput.setValue(creditCardNumber);
        transferButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
