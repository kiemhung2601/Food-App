package com.example.firstapp.api_services;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class CustomerInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Headers headers = new Headers.Builder()
                .add("accept", "*/*")
                .add("Content-Type", "application/json")
                .build();

        Request request = chain.request().newBuilder().headers(headers).build();

        //#region Log request
        long t1 = System.nanoTime();
        _printHeader(request.method(), request.url().toString());
        _printBody("Headers:");
        request.headers().forEach((element) -> {
            _printBody("\t" + element.getFirst() + ": " + element.getSecond());
        });
        if(request.body() != null){
            _printBody("Body:");
            _printBody("\t" + bodyToString(request.body()));
        }
        _printFooter(request.method());
        //#endregion

        Response response = chain.proceed(request);

        //#region Log Respone
        long t2 = System.nanoTime();
        _printHeader(request.method() + " ❱➤ " + response.code() + response.message(), request.url().toString());
        _printBody("Connect Time: " + TimeUnit.NANOSECONDS.toMillis(t2 - t1) + " ms");
        _printBody("Respone:");
        _printBody("\t" + bodyResponeToString(response));
        _printFooter(request.method());

        //#endregion

        return response;
    }

    void _printHeader(String title, String text) {
        Log.i("Services", "╔╣ " + title);
        Log.i("Services", "║ " + text);
    }

    void _printBody(String content) {
        Log.i("Services", "║ " + content);
    }

    void _printFooter(String title) {
        Log.i("Services", "╚═ END " + title);
    }

    public static String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }

    public static String bodyResponeToString(final Response response){
        try {
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.getBuffer();
            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            return buffer.clone().readString(charset);
        }
        catch (final IOException e) {
            return "did not work";
        }
    }
}
