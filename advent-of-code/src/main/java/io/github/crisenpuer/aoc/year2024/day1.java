package io.github.crisenpuer.aoc.year2024;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {

    public static void part1() {

        try ( InputStream in = day1.class.getResourceAsStream("/2024/day1.txt") ) {

            if (in == null) {
                System.out.println("File hasn't been found!");
                return;
            }

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                String line;

                List<Long> left = new ArrayList<>();
                List<Long> right = new ArrayList<>();

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    String[] parts = line.split("   ");
                    left.add(Long.parseLong(parts[0])); 
                    right.add(Long.parseLong(parts[1])); 
                }

                List<Long> leftSorted = new ArrayList<>();
                leftSorted.addAll(left);
                Collections.sort(leftSorted);

                List<Long> rightSorted =  new ArrayList<>();
                rightSorted.addAll(right);
                Collections.sort(rightSorted);

                long dist = 0;
                for (int i = 0; i < leftSorted.size(); i++) {
                    long num1 = leftSorted.get(i);
                    long num2 = rightSorted.get(i);

                    dist += Math.abs(num1 - num2);
                }

                System.out.println("Part 1: " + dist);
            }
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public static void part2() {

        try (InputStream in = day1.class.getResourceAsStream("/2024/day1.txt")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            List<Long> linesLeft = new ArrayList<>();
            List<Long> linesRight = new ArrayList<>();

            while((line = br.readLine()) != null) {
                String[] parts = line.split("   ");
                
                linesLeft.add(Long.parseLong(parts[0]));
                linesRight.add(Long.parseLong(parts[1]));
            }

            long answer = 0;

            for (long num1 : linesLeft) {

                byte occur = 0;
                for (long num2 : linesRight) {
                    if (num2 == num1) {
                        occur++;
                    }
                }

                answer += num1*occur;
            }

            System.out.println(answer);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
