package com.example.fortune;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FortuneService {
    public static String[] loadFortunes(){
        List<String> fortuneSet = new ArrayList<String>();
        Resource resource       = new ClassPathResource("fortunes.txt");

        try{
            String line;

            File file         = resource.getFile();
            BufferedReader br = new BufferedReader(new FileReader((file)));

            while ((line = br.readLine()) != null){
                fortuneSet.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fortuneSet.toArray(new String[fortuneSet.size()]);
    }

    public static String randomFortune(String[] fortunes){
        Random random = new Random();

        int position = random.nextInt(fortunes.length);

        return  fortunes[position];
    }
}
