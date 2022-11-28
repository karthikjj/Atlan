package org.snowFlake;

public enum Locators {

    Xpath("xpath"),
    ID("id"),
    ClassName("classname"),
    TagName("tagname"),
    LinkText("linktext"),
    PartialLinkText("partiallinktext"),
    CSS("css");

    private String value;

    protected String getValue() {
        return value;
    }

    Locators(String value){
        this.value = value;
    }
}
