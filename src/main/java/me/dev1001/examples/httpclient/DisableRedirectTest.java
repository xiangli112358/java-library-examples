package me.dev1001.examples.httpclient;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongzong.li on 5/9/17.
 */
public class DisableRedirectTest {

  @Test
  public void testDisableRedirect() throws IOException, AuthenticationException {
    CloseableHttpClient httpClient = HttpClientBuilder.create()
        .disableRedirectHandling()
        .build();

    CloseableHttpResponse response = httpClient.execute(new HttpGet("https://tinyurl.com/nyzp5j4"));
    Assert.assertEquals(301, response.getStatusLine().getStatusCode());

    httpClient.close();

    HttpGet httpGet = new HttpGet("https://tinyurl.com/nyzp5j4");
    Header authenticate = new BasicScheme()
        .authenticate(new UsernamePasswordCredentials("think", "password"), httpGet,
            new HttpClientContext());
    System.out.println(authenticate);

  }

}
