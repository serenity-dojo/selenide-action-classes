package com.demo.ui;

import org.openqa.selenium.By;

public class Button {
    public static By withLabel(String label) {
        return By.xpath(String.format("//a/span[contains(.,'%s')]", label));
    }
}
