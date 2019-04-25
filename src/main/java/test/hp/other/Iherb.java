package test.hp.other;

import java.util.ArrayList;
import java.util.List;

public class Iherb {

    public static List<String> getAllNums(int n){
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        for(int i = 1; i <=9; i ++){
            result.add(String.valueOf(i));
        }
        int oldSize = 0;
        int newSize = result.size();
        for(int i = 1; i < n; i ++){
            List<String> tmpList = new ArrayList<>();
            for(int j = oldSize; j < newSize; j ++){
                String tmp = result.get(j);
                for(int k = 0; k <= 9; k++){
                    tmpList.add(tmp + String.valueOf(k));
                }
            }
            oldSize = result.size();
            result.addAll(tmpList);
            newSize = result.size();
        }
        return result;
    }

    public static void main(String[] args){
        List<String> list = getAllNums(4);
        System.out.println(list.size());
        for(String s : list){
            System.out.println(s);
        }
    }
}
