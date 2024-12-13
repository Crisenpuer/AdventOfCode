package io.github.crisenpuer.aoc.year2024;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class day2 {
    
    public static void part1() {
        
        try (InputStream in = day2.class.getResourceAsStream("/2024/day2.txt")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            short safeLines = 0;

            while ((line = br.readLine()) != null) {
                
                if (isSafe(line)) {
                    safeLines++;
                }
            }

            System.out.println(safeLines);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void part2() {
        
        try (InputStream in = day2.class.getResourceAsStream("/2024/day2.txt")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            short safeLines = 0;

            while ((line = br.readLine()) != null) {
                
                if (problemDampenerCheck(line)) {
                    safeLines++;
                }
            }

            System.out.println(safeLines);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private static boolean isSafe(String report) {
        String[] levels = report.split(" ");

        String tendency = "";
        for (byte i = 0; i < levels.length; i++) {
            // Wartość n
            byte value = Byte.parseByte(levels[i]);

            // Wartość n+1
            byte value2 = 0;
            if (i + 1 < levels.length) {
                value2 = Byte.parseByte(levels[i+1]);
            } else { continue; }

            // Różnica
            if (Math.abs(value - value2) > 3 || Math.abs(value - value2) < 1) {
                return false;
            }

            // Tendencja
            if (value2 < value) { // Tendencja jest spadkowa
                if (tendency == "up") { // Ostatnia tendencja była rosnąca
                    return false; // więc raport jest groźny
                }
                tendency = "down";
                continue;
            }
            if (value2 > value) { // Tendencja jest rosnąca
                if (tendency == "down") { // Ostatnia tendencja była spadkowa, więc raport jest groźny
                    return false; // więc raport jest groźny
                }
                tendency = "up";
                continue;
            }
        }
        return true;
    }

    private static boolean problemDampenerCheck(String report) {
        String[] levels = report.split(" ");
        
        if (isSafe(report)) {
            return true;
        }

        for (int i = 0; i < levels.length; i++) {
            List<String> levelsList = arrayToArrayList(levels);
            levelsList.remove(i);
            String report2 = String.join(" ", arrayListToArray(levelsList));
            if (isSafe(report2)) {
                return true;
            }
        }
        return false;
    }


    private static List<String> arrayToArrayList(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String item : arr) {
            list.add(item);
        }
        return list;
    }
    private static String[] arrayListToArray(List<String> list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
