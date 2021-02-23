package br.com.luizalabs.designrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class DesignRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesignRestApplication.class, args);
    }

    // jar -tf target/design-rest-0.0.12-SNAPSHOT.jar

    @Override
    public void run(String... args) throws Exception {

        String file = "teste.csv";

        URL resource = getClass().getClassLoader().getResource(file);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            File f = new File(resource.toURI());
            System.out.print("1 => ");
            System.out.println(f);
        }

        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        //InputStream is2 = JavaClassName.class.getClassLoader().getResourceAsStream(file);
        System.out.print("2 => ");
        System.out.println(is);


        System.out.print("3 => ");
        DesignRestApplication app = new DesignRestApplication();
        System.out.println("getResourceAsStream : " + file);
        InputStream is2 = app.getFileFromResourceAsStream(file);
        printInputStream(is2);
        System.out.println("\ngetResource : " + file);
        File file2 = app.getFileFromResource(file);
        printFile(file2);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private static void printInputStream(InputStream is) {
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }

    private static void printFile(File file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        2021-02-23 14:31:31.359  INFO 3193437 --- [           main] b.c.l.designrest.DesignRestApplication   : Started DesignRestApplication in 4.654 seconds (JVM running for 5.284)
        1 => /home/diegolirio/Workspace/pocs/design-rest/target/classes/teste.csv
        2 => java.io.BufferedInputStream@15f861ee
        3 => getResourceAsStream : teste.csv
        firstname;lastname
        diego;lirio

        getResource : teste.csv
        firstname;lastname
        diego;lirio
     */

}
