import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import ru.netology.page.LoginPage;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.VerificationPage;
import ru.netology.page.TransferPage;
import ru.netology.steps.TemplateStepsOld;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

@RunWith(Cucumber.class)
@CucumbeOptions(
        plagin= {"pretty", "summary"},
        features = {"src/test/resources/features"},
        glue = {"ru.netology.steps"})

public class RunCucumberTest {
}
