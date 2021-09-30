package com.funniray.banbot.embed;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class EmbedBuilder {

    private String title;
    private String description;
    private String url;
    private String timestamp;
    private String color;
    private EmbedFooter footer;
    private EmbedImage image;
    private EmbedImage thumbnail;
    private EmbedAuthor author;
    private ArrayList<EmbedField> fields;

    public EmbedBuilder() {
        this.fields = new ArrayList<>();
    }

    public DiscordEmbed build() {
        return new DiscordEmbed(this.title,this.description,this.url,this.timestamp,
                this.color,this.footer,this.image,this.thumbnail,this.author, this.fields.toArray(new EmbedField[0]));
    }

    public EmbedBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EmbedBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EmbedBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedBuilder setTimestamp(Date timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        format.setTimeZone(TimeZone.getDefault());
        this.timestamp = format.format(timestamp);
        return this;
    }

    public EmbedBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public EmbedBuilder setFooter(String text, @Nullable String icon_url) {
        this.footer = new EmbedFooter(text,icon_url);
        return this;
    }

    public EmbedBuilder setImage(String url, int height, int width) {
        this.image = new EmbedImage(url,height,width);
        return this;
    }

    public EmbedBuilder setImage(String url) {
        this.image = new EmbedImage(url);
        return this;
    }

    public EmbedBuilder setThumbnail(String url, int height, int width) {
        this.thumbnail = new EmbedImage(url,height,width);
        return this;
    }

    public EmbedBuilder setThumbnail(String url) {
        this.thumbnail = new EmbedImage(url);
        return this;
    }

    public EmbedBuilder setAuthor(String name, @Nullable String url, @Nullable String icon_url) {
        this.author = new EmbedAuthor(name,url,icon_url);
        return this;
    }

    public EmbedBuilder addField(String name, String value, boolean inline) {
        this.fields.add(new EmbedField(name,value,inline));
        return this;
    }

}
