package les8;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap<Integer , String> map = new ChainingHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i,""+i+"");
            map.put(i*2,""+(i+i)+"");
        }

        System.out.println(map.toString());
        for (int i = 0; i < 30; i++) {
            System.out.print("map.get("+i+"): " + map.get(i)+" ::: ");
            if(i % 5 == 3){
                System.out.println();
            }
        }
        System.out.println();



        System.out.println("map.delete(1): " + map.delete(1));
        System.out.println("map.delete(1) again: " + map.delete(1));
        System.out.println();
        System.out.println(map);
    }
}