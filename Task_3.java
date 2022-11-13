// 1614. Maximum Nesting Depth of the Parentheses

package HW_Java_4;

import java.util.HashMap;
import java.util.Map;

public class Task_3 {
    public static void main(String[] args) {
        String s = "(+1(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));

        s = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        Character serchItem = '(';
        for (Character item : s.toCharArray()) {
            if (item == serchItem) {
                map.putIfAbsent(item, 0);
                map.put(item, map.get(item) + 1);
            } else if (item == ')') {
                if (maxCount < map.get(serchItem)) {
                    maxCount = map.get(serchItem);
                }
                map.put(serchItem, map.get(serchItem) - 1);
            }
        }
        return maxCount;
    }
}
