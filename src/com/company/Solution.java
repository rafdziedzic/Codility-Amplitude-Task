package com.company;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public String solution(int[] T) {

        String answer = "";

        if (T.length % 4 == 0) {
            int help = T.length / 4;
            int index = 0;

            List<String> listPeriot = new ArrayList<>();
            listPeriot.add("Winter");
            listPeriot.add("Spring");
            listPeriot.add("Summer");
            listPeriot.add("Autumn");

            List<Integer> winter = new ArrayList<>();
            List<Integer> spring = new ArrayList<>();
            List<Integer> summer = new ArrayList<>();
            List<Integer> autumn = new ArrayList<>();

            List<List<Integer>> period = new ArrayList();
            period.add(winter);
            period.add(spring);
            period.add(summer);
            period.add(autumn);

            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < help; i++) {
                    period.get(j).add(T[index]);
                    index++;
                }
            }

            List<Integer> map = new ArrayList<>();

            for (int k = 0; k < period.size() - 1; k++) {
                amplitude(period.get(k));
                map.add(amplitude(period.get(k)));
            }

            int maxAmp = -100;
            int pom = -1;
            for (int z = 0; z < 3; z++) {
                if (map.get(z) > maxAmp) {
                    maxAmp = map.get(z);
                    pom = z;
                }
            }
            answer = listPeriot.get(pom);
        }
        return answer;
    }

    public int amplitude(List<Integer> array) {
        int min = array.get(1);
        int max = array.get(1);

        for (int i = 0; i <= array.size() - 1; i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            } else if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return max - min;
    }
}