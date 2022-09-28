package com.veronika.interidtest.configuration;

import com.veronika.interidtest.utils.ParseExcel;
import com.veronika.interidtest.utils.ParseFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public ParseFile getParseInstance() {
        return new ParseExcel();
    }
}
