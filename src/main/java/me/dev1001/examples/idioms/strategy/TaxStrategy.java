package me.dev1001.examples.idioms.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public interface TaxStrategy<P extends TaxPayer> {

  double extortCash(P p);

}
