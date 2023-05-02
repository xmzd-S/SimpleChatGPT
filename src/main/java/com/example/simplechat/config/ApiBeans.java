package com.example.simplechat.config;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApiBeans {
    @Value("${proxy.ip}")
    private String proxyIp;
    @Value("${proxy.port}")
    private String proxyPort;
    @Autowired
    private Interceptor interceptor;
    @Bean("okHttpClient")
    public OkHttpClient okHttpClient(){
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, Integer.valueOf(proxyPort)));
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .proxy(proxy)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
    @Bean
    public Api api(){
        Api api = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .client(okHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(Api.class);
        return api;
    }
}
