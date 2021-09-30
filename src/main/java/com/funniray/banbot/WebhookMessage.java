package com.funniray.banbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.funniray.banbot.embed.DiscordEmbed;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.ArrayList;

public class WebhookMessage {

    private String content;
    private String username;
    private String avatar_url;
    private ArrayList<DiscordEmbed> embeds = new ArrayList<>();

    public void send(String uri) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(this);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, jsonString);
        Request request = new Request.Builder()
                .url(uri)
                .post(body)
                .build();

        client.newCall(request).execute();
    }

    public WebhookMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public WebhookMessage setUsername(String username) {
        this.username = username;
        return this;
    }

    public WebhookMessage setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
        return this;
    }

    public WebhookMessage addEmbed(DiscordEmbed embed) {
        this.embeds.add(embed);
        return this;
    }
}
