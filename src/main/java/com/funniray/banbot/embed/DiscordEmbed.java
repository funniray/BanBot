package com.funniray.banbot.embed;

public class DiscordEmbed {

    private String title;
    private String type;
    private String description;
    private String url;
    private String timestamp;
    private long color;
    private EmbedFooter footer;
    private EmbedImage image;
    private EmbedImage thumbnail;
    private EmbedAuthor author;
    private EmbedField[] fields;

    public DiscordEmbed(String title, String desc, String url, String timestamp, String color,
                        EmbedFooter footer, EmbedImage image, EmbedImage thumbnail,
                        EmbedAuthor author, EmbedField[] fields) {
        this.title = title;
        this.type = "rich";
        this.description = desc;
        this.url = url;
        this.timestamp = timestamp;
        if (color != null)
            this.color = Long.parseLong(color.replace("#",""), 16);
        if (footer != null)
            this.footer = footer;
        if (image != null)
            this.image = image;
        if (thumbnail != null)
            this.thumbnail = thumbnail;
        if (author != null)
            this.author = author;
        if (fields != null)
            this.fields = fields;
    }

}
