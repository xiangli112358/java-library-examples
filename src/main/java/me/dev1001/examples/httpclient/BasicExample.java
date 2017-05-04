package me.dev1001.examples.httpclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by hongzong.li on 4/21/17.
 */
public class BasicExample {

  public static void main(String[] args) throws IOException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("http://clip.dev1001.me/qe9LJbpi");
      try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
        System.out.println(response.getStatusLine()); // status line
        System.out.println();
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println); // headers
        System.out.println();
        Locale locale = response.getLocale();  // locale
        System.out.println(locale);
        System.out.println();
        System.out.println(EntityUtils.toString(response.getEntity())); // entity
      }
    }
  }
}
