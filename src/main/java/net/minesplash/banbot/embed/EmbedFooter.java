package net.minesplash.banbot.embed;

public class EmbedFooter {

    public String text;
    public String icon_url;

    public EmbedFooter(String text) {
        this.text = text;
    }

    public EmbedFooter(String text, String icon_url) {
        this.text = text;
        this.icon_url = icon_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
}
