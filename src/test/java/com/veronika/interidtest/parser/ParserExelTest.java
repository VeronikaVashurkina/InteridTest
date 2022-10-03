package com.veronika.interidtest.parser;

import com.veronika.interidtest.utils.ParseExcel;
import com.veronika.interidtest.utils.ParseFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParserExelTest {
    @Test
    public void getWorkbookTest(){
        ParseFile parseFile = new ParseExcel();
        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile("example.xlsx","example.xlsx","text/plain", new FileInputStream(new File("src/main/resources/files/example.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }

      //  Assertions.assertNotNull( parseFile.parse(multipartFile));
       // Assertions.assertEquals(25, parseFile.parse((MultipartFile) new File("example.xlsx")).size());
        //ReflectionUtilsTest.

    }
}
