package me.dev1001.examples.idiom.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public interface TaxStrategy<P extends TaxPayer> {

  double extortCash(P p);

}
