package org.etu.java.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.MapInfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RefreshScope
public class LabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabsApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();

        Locale defLocale = new Locale.Builder()
            .setLanguage("ru")
            .setRegion("RU")
            .build();

        localeResolver.setDefaultLocale(defLocale);
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setBasenames("messages", "links");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    InfoContributor getInfoContributor() {
        Map<String, Object> details = new HashMap<>();

        details.put("nameApp", "Intelligent Parking System app");
        details.put("description", "Intelligent Parking System management service");
        details.put("developers", "Daniil 'UnDan' Zabaluev");
        details.put("emails", "undan@gmail.com");

        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("info", details);

        return new MapInfoContributor(wrapper);
    }

}
