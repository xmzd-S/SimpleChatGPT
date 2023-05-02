package com.example.simplechat.util;

import com.example.simplechat.config.Api;
import com.example.simplechat.domain.ChatCompletion;
import com.example.simplechat.domain.ChatCompletionResponse;
import com.example.simplechat.domain.ModelResponse;
import com.example.simplechat.domain.Subscription;
import io.reactivex.Single;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ChatGptClient implements Api{
    @Autowired
    private OkHttpClient okHttpClient;
    @Autowired
    private Api api;

    @Override
    public Single<ModelResponse> models() {
        return api.models();
    }

    @Override
    public Single<Subscription> subscription() {
        return api.subscription();
    }

    @Override
    public Single<ChatCompletionResponse> chatCompletion(ChatCompletion chatCompletion) {
        Single<ChatCompletionResponse> chatCompletionResponse = api.chatCompletion(chatCompletion);
        return chatCompletionResponse;
    }
}
