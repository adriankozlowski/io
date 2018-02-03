package pl.sda2;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File file = new File("myFile.ext");
        System.out.println(file.getAbsolutePath());
        if (file.exists()) {
            System.out.println("istnieje");
            if (file.isDirectory()) {
                System.out.println("jest katalogiem");
            } else if( file.isFile()){
                System.out.println("jest plikiem");
            }
        } else {
            System.out.println("nie istnieje");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        writeLine(file);
//        readLines(file);
        try {
            read(file);
            write(new File("test1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeLine(File file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(LocalDateTime.now().toString()+"\n");
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public static void readLines(File file) throws FileNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[10];
        int readBytes;
        while((readBytes = fileInputStream.read(buffer, 0, 10)) != -1){
            for (byte b : buffer) {
                System.out.print((char)b);
            }
        }

    }

    public static void write(File file) throws Exception {
            FileOutputStream fileOutputStream = null;
        try {
            byte[] bytes = "Hello world from file".getBytes();

            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new Exception("Coś poszło nie tak");
        }finally {
            fileOutputStream.close();
        }
    }

    public static void copy(File source, File target){
        //i tutaj implementacja
    }

}

















