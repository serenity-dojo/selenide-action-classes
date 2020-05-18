package com.demo.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class JobResultsActions {

    List<String> savedJobs = new ArrayList<>();

    private final static String JOB_TITLES = ".summary h2 a";

    public void saveJobNumber(int jobNumber) {
        ElementsCollection jobTitles = $$(JOB_TITLES);
        String jobTitle = jobTitles.get(jobNumber - 1).getText();
        savedJobs.add(jobTitle);
        jobTitles.get(jobNumber - 1).click();

        $("#SaveJob").shouldBe(visible);
        $("#SaveJob").click();
    }

    public void saveLastJob() {
        ElementsCollection jobTitles = $$(JOB_TITLES);
        int lastJob = jobTitles.size() - 1;

        WebElement lastJobElement = $$(JOB_TITLES).get(lastJob);
        String jobTitle = lastJobElement.getText();
        savedJobs.add(jobTitle);

        actions().moveToElement(lastJobElement).click(lastJobElement).perform();

        $("#SaveJob").shouldBe(visible);
        $("#SaveJob").click();
    }

    public List<String> savedJobs() {
        return savedJobs;
    }

}
