package me.dev1001.examples.moneta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.UnknownCurrencyException;
import org.junit.Test;

/**
 * Created by hongzong.li on 4/7/17.
 */
public class MonetaryTest {

  @Test
  public void testGetCurrency() {
    CurrencyUnit cny = Monetary.getCurrency("CNY");
    assertNotNull(cny);
    assertEquals("CNY", cny.getCurrencyCode());
    assertEquals(2, cny.getDefaultFractionDigits());
  }


  @Test(expected = UnknownCurrencyException.class)
  public void testGetCurrency_notExist() {
    Monetary.getCurrency("ufo");
  }


  @Test
  public void testGetCurrency_caseSensitive() {
    CurrencyUnit cny = Monetary.getCurrency("CNY");
    assertNotNull(cny);

    try {
      Monetary.getCurrency("cny");
      fail();
    } catch (UnknownCurrencyException e) {
      // expected
    }
  }

}
