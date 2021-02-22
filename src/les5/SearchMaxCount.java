package les5;

public class SearchMaxCount {
    ThingForTheBag[] rr;
    int maxWeig;
    int size;
    int index = 0;
    ThingForTheBag[][] arr;
    ThingForTheBag[] maxCombo;
    int maxComboWeig;

    public SearchMaxCount(ThingForTheBag[] rr, int maxWeig) {
        this.rr = rr;
        this.maxWeig = maxWeig;
        maxCombo = new ThingForTheBag[rr.length];
        size = rr.length;
        this.arr = new ThingForTheBag [toFactorial(this.rr.length)][this.rr.length];
        getAnagramm(rr.length);
        searchCombo(0,0);
    }

    private void searchCombo(int newSize1, int newSize) {
        int weigth = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length-newSize; j++) {
                weigth += arr[i][j].getWeight();
                count += arr[i][j].getPrice();
                System.out.println(arr[i][j].toString());
            }
            System.out.println("------------------------------------------------------------");
            System.out.print(weigth+" - ");
            System.out.println(count);
            if(weigth > maxWeig) {
                System.out.println("tutututututu");
                searchCombo(newSize1 + 1,newSize + 1);
                break;
            }
            weigth = 0;
            count = 0;
        }
    }


    public void getAnagramm(int newSize){
        if (newSize == 1)
            return;
        for (int i=0; i<newSize; i++){
            getAnagramm(newSize-1);
            if (newSize == 2){
                toSaveArray();
                display();
            }
            rotate(newSize);
        }
    }

    public void rotate(int newSize){
        int i;
        int pos = size - newSize;
        ThingForTheBag temp = rr[pos];
        for (i=pos+1; i<size; i++){
            rr[i-1] = rr[i];
        }
        rr[i-1] = temp;
    }

    public void toSaveArray(){
        for(int i=0; i<size; i++){
            arr[index][i] = rr[i];
        }
        index++;
    }

    public void display(){
        for(int i=0; i<size; i++){
            //System.out.print(rr[i].toString());
        }
        //System.out.println("");
    }


    public int toFactorial(int value){
        if(value < 0){
            return 0;
        } else if (value == 0){
            return 1;
        }
        return value * toFactorial(value-1);
    }
}
