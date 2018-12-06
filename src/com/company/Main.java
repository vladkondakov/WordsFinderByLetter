package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input your text in one line:");
        String text = sc.nextLine();
        String[] sentences = text.split("\\.");
        String[][] words = new String[sentences.length][];
        int maxLen = 0; //Максимальное количество слов с нужной буквой в предложении

        for (int i = 0; i < sentences.length; i++) {
            words[i] = sentences[i].split("\\s+|,|-|:|;");
        }

        ArrayList<String> s = new ArrayList<String>();
        String str = "";
        int k = 0;
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                if((words[i][j].indexOf("о") != -1) || (words[i][j].indexOf("О") != -1)){
                    k++;
                    str = str + words[i][j] + " ";
                }
            }
            if(maxLen < k) maxLen = k;
            k = 0;
            s.add(str);
            str = "";
        }

        String[] tmp;
        int[][] c = new int[sentences.length][maxLen];

        for (int i = 0; i < s.size(); i++) {
            tmp = s.get(i).split(" ");
            for (int j = 0; j < tmp.length; j++) {
                c[i][j] = tmp[j].length();
            }
        }

        int[] maxc = new int[maxLen];
        int max = 0;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < sentences.length; j++) {
                if(c[j][i] > max) max = c[j][i];
            }
            maxc[i] = max;
            max = 0;
        }

        System.out.println();
        for (int i = 0; i < s.size(); i++) {
            tmp = s.get(i).split(" ");
            for (int j = 0; j < tmp.length; j++) {
                System.out.print(tmp[j]);
                goPrint(tmp[j].length(), maxc[j]);
            }
            System.out.println();
        }
    }

    public static void goPrint(int length, int k){
        if(length != 0){
            for(int i = length; i <= k; i++) {
                System.out.print(" ");
            }
        }
    }
}
