import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/2/29 2:12 下午
 */
public class ReadCSV {
    public static void main(String[] args) {
        String outputCsv = "/Users/zhengtianze/out.csv";
        String inputCsv = "/Users/zhengtianze/tt1102_answers_refine.csv";
        String line = "";
        String cvsSplitBy = ",";

        Map<String, HashSet<String>> inPutMap = new HashMap<>();
        Map<String, HashSet<String>> outPutMap = new HashMap<>();
        boolean init = false;
        try (BufferedReader br = new BufferedReader(new FileReader(outputCsv))) {
            while ((line = br.readLine()) != null) {
                if (!init) {
                     init = true;
                     continue;
                }
                String[] data = line.split(cvsSplitBy);

                if (!outPutMap.containsKey(data[0])) {
                    HashSet<String> tmp = new HashSet<>();
                    tmp.add(data[2]);
                    outPutMap.put(data[0], tmp);
                } else {
                    outPutMap.get(data[0]).add(data[2]);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        init = false;
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsv))) {
            while ((line = br.readLine()) != null) {
                if (!init) {
                    init = true;
                    continue;
                }
                String[] data = line.split(cvsSplitBy);

                if (!inPutMap.containsKey(data[0])) {
                    HashSet<String> set = new HashSet<>();
                    set.add(data[1]);
                    inPutMap.put(data[0], set);
                } else {
                    inPutMap.get(data[0]).add(data[1]);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int matchNum = 0;
        int noMatchNum = 0;
        int errMatchNum = 0;

        for (Map.Entry<String, HashSet<String>> entry : outPutMap.entrySet()) {
            Set<String> set = entry.getValue();
            for (String str : set) {
                if (inPutMap.containsKey(entry.getKey()) && inPutMap.get(entry.getKey()).contains(str)) {
                    matchNum++;
                } else {
                    System.out.println("err match probe " + entry.getKey() + " target barcode " + str);
                    errMatchNum++;
                }
            }
        }
        for (Map.Entry<String, HashSet<String>> entry : inPutMap.entrySet()) {
            Set<String> set = entry.getValue();
            for (String str : set) {
                if (!outPutMap.containsKey(entry.getKey()) || !outPutMap.get(entry.getKey()).contains(str)) {
                    System.out.println("no match probe " + entry.getKey() + " target barcode " + str);
                    noMatchNum++;

                }
            }
        }


        System.out.println("match num is " + matchNum + " noMatch num is " + noMatchNum + " errMatch num is " + errMatchNum);


    }



}
