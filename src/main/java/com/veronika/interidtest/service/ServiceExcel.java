package com.veronika.interidtest.service;


import com.veronika.interidtest.repository.BirdRepo;
import com.veronika.interidtest.repository.DogRepo;
import com.veronika.interidtest.repository.entity.BirdEntity;
import com.veronika.interidtest.repository.entity.DogEntity;
import com.veronika.interidtest.utils.ParseExcel;
import com.veronika.interidtest.utils.ParseFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ServiceExcel implements ServiceFile {
    private final DogRepo dogRepo;
    private final BirdRepo birdRepo;
//    private final ParseFile parseFile;

    @Override
    public void addFileDate(MultipartFile file) {
        ParseFile parseFile = new ParseExcel();
        parseFile.parse(file);
        ((ParseExcel) parseFile).getDogs().forEach(dog -> {
            DogEntity dogEntity = new DogEntity();
            dogEntity.setName(dog.getName());
            dogEntity.setRunSpeed((dog).getRunSpeed());
            dogRepo.save(dogEntity);
        });
        ((ParseExcel) parseFile).getBirds().forEach(bird -> {
            BirdEntity birdEntity = new BirdEntity();
            birdEntity.setName(bird.getName());
            birdEntity.setFlightSpeed((bird).getFlightSpeed());
            birdRepo.save(birdEntity);
        });

    }
}
