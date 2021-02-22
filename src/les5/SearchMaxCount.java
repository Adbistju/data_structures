package les5;

public class SearchMaxCount {
    ThingForTheBag[] rr;
    int maxWeig;
    int size;

    ThingForTheBag[][] arr;


    ThingForTheBag[] maxCombo;
    int maxComboWeig;

    public SearchMaxCount(ThingForTheBag[] rr, int maxWeig) {
        this.rr = rr;
        this.maxWeig = maxWeig;
        arr = new ThingForTheBag [rr.length][toFactorial(rr.length)];
        maxCombo = new ThingForTheBag[rr.length];
        getAnagramm(rr.length);
    }


    public void getAnagramm(int newSize){
        if (newSize == 1)
            return;
        for (int i=0;i<newSize;i++){
            getAnagramm(newSize-1);
            if (newSize == 2)
                toSaveArray(newSize);
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

    public void toSaveArray(int index){
        for(int i=0; i<size; i++){
            arr[index][i] = rr[i];
        }
        display();
    }

    public void display(){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }


    public int toFactorial(int value){
        if(value < 0){
            return 0;
        } else if (value < 0){
            return 0;
        }
        return value * toFactorial(value-1);
    }
}
