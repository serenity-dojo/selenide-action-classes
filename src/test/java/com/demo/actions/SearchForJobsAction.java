package com.demo.actions;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchForJobsAction {

    WaitForSpinnerAction waitForSpinner = new WaitForSpinnerAction();

    public void forPopularCompany(String companyTitle) {
        waitForSpinner.toDissapear();

        Pause.forMilliseconds(2000);
        $(By.linkText(companyTitle)).click();
        $("#SearchResults").shouldBe(Condition.visible);

    }

}
