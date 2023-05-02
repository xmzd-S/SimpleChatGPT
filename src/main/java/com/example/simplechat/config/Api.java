package com.example.simplechat.config;

import com.example.simplechat.domain.ChatCompletion;
import com.example.simplechat.domain.ChatCompletionResponse;
import com.example.simplechat.domain.ModelResponse;
import com.example.simplechat.domain.Subscription;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    /**
     * 模型列表
     *
     * @return Single ModelResponse
     */
    @GET("v1/models")
    Single<ModelResponse> models();
    @GET("v1/dashboard/billing/subscription")
    Single<Subscription> subscription();
    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> chatCompletion(@Body ChatCompletion chatCompletion);
}
