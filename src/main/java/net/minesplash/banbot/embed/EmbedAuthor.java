package net.minesplash.banbot.embed;

public class EmbedAuthor {

    private String name;
    private String url;
    private String icon_url;

    public EmbedAuthor(String name, String url, String icon_url) {
        this.name = name;
        this.url = url;
        this.icon_url = icon_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
}
