package net.minesplash.banbot;

import com.google.gson.Gson;
import net.minesplash.banbot.embed.DiscordEmbed;
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
    private ArrayList<DiscordEmbed> embeds;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client;

    public WebhookMessage() {
        this.embeds = new ArrayList<>();
        this.client = new OkHttpClient();
    }

    public void send(String uri) throws IOException {
        String jsonString = new Gson().toJson(this);

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
