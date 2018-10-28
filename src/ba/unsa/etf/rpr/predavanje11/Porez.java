package ba.unsa.etf.rpr.predavanje11;

import java.util.function.Function;

public class Porez {
    private double ukupanPrihod;

    Porez(double p) { ukupanPrihod = p; }

    @FunctionalInterface
    public interface PorezFunkcija {
        double izracunajPdv(double prihod);
    }

    public void ispisiPorez(PorezFunkcija func) {
        double porez = func.izracunajPdv( ukupanPrihod );
        System.out.println("Porez iznosi: " + porez);
    }

    public void ispisiPorez2(Function<Double,Double> func) {
        double porez = func.apply( ukupanPrihod );
        System.out.println("Porez iznosi: " + porez);
    }

    public void test1() {
        PorezFunkcija pdvFunc = (double prihod) -> {
            double pdv = 0;
            if (prihod > 100000)
                pdv = prihod * 0.17;
            return pdv;
        };
        ispisiPorez(pdvFunc);
    }

    public double porezMafija(double prihod) {
        double porez = 0;
        if (prihod > 10000)
            porez = prihod * 0.66;
        return porez;
    }

    public void test2() {
        ispisiPorez2( prihod -> {
            double pdv = 0;
            if (prihod > 50000)
                pdv = prihod * 0.21;
            return pdv;
        } );
    }
}
