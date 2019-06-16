package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows < 1) {
            return result;
        }
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        result.add(row);
        if(numRows >= 2){
            row = new ArrayList<>(2);
            row.add(1);
            row.add(1);
            result.add(row);
        }
        List<Integer> lastRow = row;
        for(int i = 2; i < numRows; i ++){
            List<Integer> tmp = new ArrayList<>(i);
            tmp.add(1);
            for(int j = 1; j < i-1; j ++){
                tmp.add(lastRow.get(j-1) + lastRow.get(j));
            }
            tmp.add(1);
            result.add(tmp);
            lastRow = tmp;
        }
        return result;
    }
}
