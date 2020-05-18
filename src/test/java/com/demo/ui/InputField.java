package com.demo.ui;

import org.openqa.selenium.By;

public class InputField {
    public static By withLabel(String label) {
        return By.xpath(String.format("//div[label[contains(.,'%s')]]//input[not(contains(@class, 'ng-hide'))]",label));
    }
}
