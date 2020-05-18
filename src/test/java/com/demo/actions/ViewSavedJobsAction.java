package com.demo.actions;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class ViewSavedJobsAction {

    WaitForSpinnerAction waitForSpinner = new WaitForSpinnerAction();

    private final String SAVED_JOB_TITLE = ".list-item-heading";

    public void viewMySavedJobs() {
        actions().moveToElement($(By.partialLinkText("My Job Search"))).perform();
        $(By.partialLinkText("Saved Jobs")).click();
        waitForSpinner.toDissapear();
        $$(SAVED_JOB_TITLE).shouldHave(size(2));
    }

    public List<String> savedJobTitles() {
        return $$(SAVED_JOB_TITLE).texts();
    }
}
