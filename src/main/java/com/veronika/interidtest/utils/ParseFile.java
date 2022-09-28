package com.veronika.interidtest.utils;

import com.veronika.interidtest.model.Animal;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ParseFile {
     List<Animal> parse(MultipartFile file);
}
