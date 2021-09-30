package com.funniray.banbot.embed;

public class EmbedField {

    public String name;
    public String value;
    public boolean inline;

    public EmbedField(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public EmbedField(String name, String value, boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isInline() {
        return inline;
    }

    public void setInline(boolean inline) {
        this.inline = inline;
    }
}
