package br.com.luizalabs.designrest.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

@Component
class Compo {

    static boolean done = false;

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void extracted() throws URISyntaxException {
        String file = "teste.csv";
        URL resource = getClass().getClassLoader().getResource(file);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            if (!done) {
                File f = new File(resource.toURI());
                System.out.print("1 => ");
                System.out.println(f);
                done = true;
            }
        }
    }

}