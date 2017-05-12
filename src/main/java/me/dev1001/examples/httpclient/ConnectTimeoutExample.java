package me.dev1001.examples.httpclient;

import com.google.common.base.Stopwatch;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by hongzong.li on 5/9/17.
 */
public class ConnectTimeoutExample {

  public static void main(String[] args) throws IOException {
    int timeout = 5;
    RequestConfig config = RequestConfig.custom()
        .setConnectTimeout(timeout * 1000)
        .setConnectionRequestTimeout(timeout * 1000)
        .setSocketTimeout(timeout * 1000)
        .build();

    CloseableHttpClient client = HttpClientBuilder.create()
        .setDefaultRequestConfig(config)
        .build();

    Stopwatch stopwatch = Stopwatch.createStarted();
    try {
      HttpGet request = new HttpGet("http://baidu.com:81");
      client.execute(request);
    } finally {
      System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
    }

  }

}
