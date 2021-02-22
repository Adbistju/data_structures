package les5;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    final ThingForTheBag aa1 = new ThingForTheBag("m-416",3,20);
    final ThingForTheBag aa2 = new ThingForTheBag("ак-74",4,15);
    final ThingForTheBag aa3 = new ThingForTheBag("desert eagle",1,7);
    final ThingForTheBag aa4 = new ThingForTheBag("awm", 7,50);
    final ThingForTheBag aa5 = new ThingForTheBag("explosion package", 2,30);

    final ThingForTheBag[] thing = {aa1, aa2, aa3, aa4, aa5};
    final int w = 11;

    public static void main(String[] args) {
        System.out.println(exponentiation(5 , 5));
        Main m = new Main();
        //m.thing();
        m.searh();

    }

    public void searh(){
        SearchMaxCount searchMaxCount = new SearchMaxCount(thing, w);
    }

    public void thing() {
        //сортировка O(N * log(N))
        Arrays.sort(thing, Comparator.comparingDouble(ThingForTheBag::valuePerUNitofWeigth).reversed());
        System.out.println(Arrays.toString(thing));
        int weihtSoFar = 0;
        double valueSofar = 0;
        int currentItem = 0;
        while (currentItem < thing.length && weihtSoFar != w ){
            if (weihtSoFar + thing[currentItem].getWeight() < w){
                //берем объект целиком

                valueSofar += thing[currentItem].getPrice();
                weihtSoFar += thing[currentItem].getWeight();
            } else {
                //берем только часть объекта
                valueSofar += (w - weihtSoFar) / (double) thing[currentItem].getWeight()
                        * thing[currentItem].getPrice();
                weihtSoFar = w; // полный рюкзак
            }
            currentItem++;
        }
        System.out.println("ценность наилучшего набора:" + valueSofar);
    }

    public static double exponentiation(double digit, int rank) {
        if(digit == 0){
            if(rank > 0){
                return 0;
            } else {
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if(rank < 0 ){
            return 1 / (digit * exponentiation(digit, -rank-1));
        } else if (rank > 0) {
            return digit * exponentiation(digit, rank-1);
        } else {
            return 1;
        }
    }


}
