package les5;

public class ThingForTheBag {
    private String name;
    private int weight;
    private int price;

    public ThingForTheBag(String name, int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public double valuePerUNitofWeigth(){
        return price / (double) weight;
    }

    @Override
    public String toString() {
        return "T{" +
                "n:'" + name + '\'' +
                ", w:" + weight +
                ", p:" + price +
                '}';
    }
}
