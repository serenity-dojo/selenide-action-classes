package com.demo.ui;

import org.openqa.selenium.By;

public class Dropdown {
    public static By withLabel(String label) {
        return By.xpath(String.format("//div[label[contains(.,'%s')]]//select",label));
    }
}
