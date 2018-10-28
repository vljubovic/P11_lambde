package ba.unsa.etf.rpr.predavanje11;

import java.util.function.Function;

public class Main {

    static Function<Integer,Integer> Kompozicija(Function<Integer,Integer> f,
                                  Function<Integer,Integer> g) {
        return x -> { return g.apply(f.apply(x)); };
    }

    public static void main(String[] args) {
	    // write your code here
        Function<Integer, Integer> puta2 = x -> x * 2;
        Function<Integer, Integer> naKvadrat = x -> x * x;

        int a = puta2.compose(naKvadrat).apply(4); // bice: 32
        int b = puta2.andThen(naKvadrat).apply(4); // bice: 64

        System.out.println("a = " + a + " b = " + b);

        Function<Integer, Integer> komp = Kompozicija(puta2, naKvadrat);
        System.out.println("komp = " + komp.apply(4));

        // Porezi
        Porez p = new Porez(200000);
        p.test1();
        p.test2();
        p.ispisiPorez2(p::porezMafija);
    }
}
