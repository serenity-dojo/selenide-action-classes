package com.demo.actions;

import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class ViewSavedJobsAction {

    WaitForSpinnerAction waitForSpinner = new WaitForSpinnerAction();

    private final String SAVED_JOB_TITLE = ".list-item-heading";

    public List<String> viewMySavedJobs() {
        actions().moveToElement($(By.partialLinkText("My Job Search"))).perform();
        $(By.partialLinkText("Saved Jobs")).click();
        waitForSpinner.toDissapear();

        return $$(SAVED_JOB_TITLE).shouldHave(sizeGreaterThan(0)).texts();
    }
}
