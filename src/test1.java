import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/2/29 2:56 下午
 */
public class test1 {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("1", new ArrayList<>());
        map.get("1").add(1);
        map.get("1").add(2);
        System.out.println(map.get("1").size());
    }
}
