package com.andrewsotirov;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class FortuneFileReader implements FortuneService {

    @Value("${a}")
    private String fortune1;
    @Value("${b}")
    private String fortune2;
    @Value("${c}")
    private String fortune3;
    @Value("${d}")
    private String fortune4;


    @Override
    @PostConstruct
    public String getFortune() {
        String[] fortunes = {fortune1, fortune2, fortune3, fortune4};
        Random random = new Random();
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }

}
