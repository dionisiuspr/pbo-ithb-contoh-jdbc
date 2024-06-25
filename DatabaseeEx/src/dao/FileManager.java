package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class FileManager {

    public static void writeToText(String url, String lines) {
        try {
            File file = new File(url);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(lines);
            bw.newLine();
            bw.write("Kincup");
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static List<String> readFile(String url) {
        List<String> listString = new ArrayList<>();
        try {
            File f = new File(url);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                listString.add(line);
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listString;
    }

    public static void main(String[] args) {
        writeToText("test.txt", "bokir");
        readFile("test.txt");
    }

}