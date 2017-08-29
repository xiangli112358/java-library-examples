package me.dev1001.examples.httpclient;

import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by hongzong.li on 5/9/17.
 */
public class DisableRedirectTest {

  @Test
  public void testDisableRedirect() throws IOException, AuthenticationException {
    CloseableHttpClient httpClient = HttpClientBuilder.create()
        .disableRedirectHandling()
        .build();

    CloseableHttpResponse response = httpClient.execute(new HttpGet("https://www.jubi.com/coin/act/"));
    String result = response.toString();
    System.out.println("=======================================================");
    System.out.println(result);

  }

}
