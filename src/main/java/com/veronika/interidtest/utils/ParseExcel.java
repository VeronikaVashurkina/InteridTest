package com.veronika.interidtest.utils;

import com.veronika.interidtest.model.Animal;
import com.veronika.interidtest.model.Bird;
import com.veronika.interidtest.model.Dog;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseExcel implements ParseFile {
    public static final String SRC_TO_RESOURCE_FILE_FOLDER = "src/main/resources/files";
    public static final String DOG = "Собака";
    public static final String BIRG = "Птица";

    private List<Dog> dogs;
    private List<Bird> birds;

    public List<Dog> getDogs() {
        return dogs;
    }

    public List<Bird> getBirds() {
        return birds;
    }


    public void parse(MultipartFile file) {
        dogs = new ArrayList<>();
        birds = new ArrayList<>();
        Workbook workbook = getWorkbook(file);
        getAnimals(workbook);
    }

    private Workbook getWorkbook(MultipartFile file) {
        Workbook workbook = null;
        try {
            InputStream in = file.getInputStream();
            File currDir = new File(SRC_TO_RESOURCE_FILE_FOLDER);
            String path = currDir.getAbsolutePath();
            String fileLocation = path + "\\" + file.getOriginalFilename();
            FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
            int ch;
            while ((ch = in.read()) != -1) {
                fileOutputStream.write(ch);
            }
            fileOutputStream.flush();
            fileOutputStream.close();

            File uploadedFile = new File(fileLocation);
            workbook = WorkbookFactory.create(uploadedFile);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    private void getAnimals( Workbook workbook) {
        Animal animal = null;
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        it.next();

        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();

                switch (cell.getStringCellValue()) {
                    case DOG -> {
                        animal = getDog(animal, cells);
                        this.dogs.add((Dog) animal);
                    }
                    case BIRG -> {
                        animal = getBird(animal, cells);
                        this.birds.add((Bird) animal);

                    }
                }

            }
        }

    }

    private Dog getDog(Animal animal, Iterator<Cell> cells) {
        animal = new Dog();
        Cell cell = cells.next();
        animal.setName(cell.getStringCellValue());
        cell = cells.next();
        ((Dog) animal).setRunSpeed(cell.getStringCellValue());
        return (Dog) animal;
    }

    private Bird getBird(Animal animal, Iterator<Cell> cells) {
        animal = new Bird();
        Cell cell = cells.next();
        animal.setName(cell.getStringCellValue());
        cell = cells.next();
        ((Bird) animal).setFlightSpeed(BigDecimal.valueOf(cell.getNumericCellValue()));
        return (Bird) animal;
    }

}
