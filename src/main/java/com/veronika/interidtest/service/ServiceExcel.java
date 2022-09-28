package com.veronika.interidtest.service;

import com.veronika.interidtest.model.Bird;
import com.veronika.interidtest.model.Dog;
import com.veronika.interidtest.repository.BirdRepo;
import com.veronika.interidtest.repository.DogRepo;
import com.veronika.interidtest.repository.entity.BirdEntity;
import com.veronika.interidtest.repository.entity.DogEntity;
import com.veronika.interidtest.utils.ParseFile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Data
@NoArgsConstructor
public class ServiceExcel implements ServiceFile {
    private DogRepo dogRepo;
    private BirdRepo birdRepo;
    private ParseFile parseFile;

    @Autowired
    public void setParseFile(ParseFile parseFile) {
        this.parseFile = parseFile;
    }

    @Autowired
    public void setDogRepo(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    @Autowired
    public void setBirdRepo(BirdRepo birdRepo) {
        this.birdRepo = birdRepo;
    }

    @Override
    public void addFileDate(MultipartFile file) {
        parseFile.parse(file).forEach(animal -> {
            if (animal instanceof Dog) {
                DogEntity dog = new DogEntity();
                dog.setName(animal.getName());
                dog.setRunSpeed(((Dog) animal).getRunSpeed());
                dogRepo.save(dog);
            } else {
                BirdEntity bird = new BirdEntity();
                bird.setName(animal.getName());
                bird.setFlightSpeed(((Bird) animal).getFlightSpeed());
                birdRepo.save(bird);
            }
        });
    }
}
