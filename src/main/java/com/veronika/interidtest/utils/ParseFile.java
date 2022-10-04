package com.veronika.interidtest.utils;

import com.veronika.interidtest.model.Animal;
import com.veronika.interidtest.model.Bird;
import com.veronika.interidtest.model.Dog;
import com.veronika.interidtest.service.ServiceExcel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ParseFile {
     void parse(MultipartFile file);

     List<Dog> getDogs();
     List<Bird> getBirds();

}
