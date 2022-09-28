package com.veronika.interidtest.controller;

import com.veronika.interidtest.service.ServiceFile;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class ExcelController {

    private final ServiceFile serviceFile;

    @PostMapping()
    public void importFromExel(@RequestParam("file") MultipartFile file, HttpServletResponse httpServletResponse) throws IOException {
        serviceFile.addFileDate(file);
        httpServletResponse.sendRedirect("/api/animals/import/");
    }

    @GetMapping()
    public String getFirstPage() {
        return "index";
    }
}
