import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorter {



    public void arrayListSorting(ArrayList aList, int numberUsed,int option){
        int i, indexOfNextSmallest;
        for(i =0; i<numberUsed-1 ; i++){
            indexOfNextSmallest =smallestIndex(i,aList,numberUsed,option );
            sorting(i,indexOfNextSmallest,aList);
        }
    }

    private void sorting(int i, int j, ArrayList aList){
        IComparable temp;
        temp =(IComparable)aList.get(i);
        aList.set(i,aList.get(j));
        aList.set(j,temp); }

    private int smallestIndex(int start, ArrayList aList, int numberUsed, int option){
        IComparable min =(IComparable) aList.get(start);
        int minIndex =start;
        int i;
        for(i =start+1; i <numberUsed; i++){
            if(((IComparable) aList.get(i)).compareTo(min , option)<0){
                min=(IComparable) aList.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }



}
