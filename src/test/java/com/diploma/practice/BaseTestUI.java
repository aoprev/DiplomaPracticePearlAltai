package com.diploma.practice;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.diploma.practice.pages.PearlAltaiMainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import static com.diploma.practice.Properties.UI_BASE_URL;
import static com.diploma.practice.Properties.UI_BROWSER;

public class BaseTestUI {

        @BeforeSuite
        public void setupBrowser() {
            Configuration.browser = PropertyReader.getProperty(UI_BROWSER);
            Configuration.browserSize = "1280x720";

        }

        @BeforeClass
        public void openPearlAltaiMainPage() {
            Selenide.open(PropertyReader.getProperty(UI_BASE_URL));
        }
    }
