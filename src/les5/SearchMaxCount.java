package les5;

public class SearchMaxCount {
    ThingForTheBag[] rr;
    int maxWeig;
    int size;
    int index = 0;
    ThingForTheBag[][] arr;
    ThingForTheBag[] maxCombo;
    int maxComboWeig;
    int maxComboCount;

    public SearchMaxCount(ThingForTheBag[] rr, int maxWeig) {
        this.rr = rr;
        this.maxWeig = maxWeig;
        maxCombo = new ThingForTheBag[rr.length];
        size = rr.length;
        this.arr = new ThingForTheBag [toFactorial(this.rr.length)][this.rr.length];
        getAnagramm(rr.length);
        searchCombo(0,0);
    }

    private void searchCombo(int i, int newSize) {
        int weigth = 0;
        int count = 0;
        if (i >= arr.length){
            return;
        }
        for (int j = 0; j < arr[i].length-newSize; j++) {
            weigth += arr[i][j].getWeight();
            count += arr[i][j].getPrice();
            System.out.println(arr[i][j].toString());
                /*if(count >= maxComboWeig && weigth <= maxWeig){
                    System.out.println(arr[i][j].toString());
                }*/
        }
        if(count < maxComboCount) {
            maxComboCount = count;
        }
        System.out.println("-------------------------------------------------------");
        if (weigth > maxWeig){
            searchCombo(i,newSize + 1);
        } else if (count < maxComboCount) {
            searchCombo(i + 1,newSize);
        }
        /*System.out.println(weigth+" - "+ count);
        System.out.println("------------------------------------------------------------");
        if(weigth > maxWeig) {
            searchCombo(i + 1,newSize + 1);
        }
        if (count >= maxComboWeig){
            maxComboWeig = count;
            System.out.println("----");
            System.out.println(maxComboWeig);
            System.out.println("----");
        }*/
        /*weigth = 0;
        count = 0;*/
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
