package com.demo;

import com.codeborne.selenide.Configuration;
import com.demo.actions.*;
import com.demo.data.RandomEmail;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SavingJobsTest
{

    CreateAccountAction createAccount = new CreateAccountAction();
    SearchForJobsAction searchForJobs = new SearchForJobsAction();
    WaitForSpinnerAction waitForSpinner = new WaitForSpinnerAction();
    JobResultsActions jobResultsActions = new JobResultsActions();
    ViewSavedJobsAction viewSavedJobs = new ViewSavedJobsAction();

    @Before
    public void openTheApplication() {

        Configuration.timeout = 10000;

        open(HomePage.URL);
        waitForSpinner.toDissapear();

    }

    @Test
    public void jobSeekersCanSaveTheJobsTheyAreInterestedIn()
    {
        createAccount.withEmailAndPassword(RandomEmail.address(),"Secret123!");
        searchForJobs.forPopularCompany("Philips Jobs");
        jobResultsActions.saveJobNumber(2);
        jobResultsActions.saveLastJob();

        List<String> savedJobs = viewSavedJobs.viewMySavedJobs();
        assertThat(savedJobs).hasSize(2).containsAll(jobResultsActions.savedJobs());
    }
}
