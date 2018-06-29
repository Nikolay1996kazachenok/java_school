package T_system2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequence {
    public boolean find(List x, List y) {
        // TODO: Implement the logic here
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }
        if (!y.containsAll(x)) {
            return false;
        }
        else{
            int count=0;
            int index=0;
            for(int i=0; i<x.size(); i++){
                for(int j=index; j<y.size(); j++){
                    if(x.get(i).equals(y.get(j))){
                        count++;
                        index=j+1;
                        break;
                    }
                }
            }
            if(x.size()==count){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Subsequence s = new Subsequence();
        boolean b = s.find(Arrays.asList("A", "B", "C", "D"),
                Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D"));
        System.out.println(b); // Result: true
    }
}
