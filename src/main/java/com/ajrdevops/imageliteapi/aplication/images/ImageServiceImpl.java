package com.ajrdevops.imageliteapi.aplication.images;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajrdevops.imageliteapi.domain.entity.Image;
import com.ajrdevops.imageliteapi.domain.enums.ImageExtension;
import com.ajrdevops.imageliteapi.domain.service.ImageService;
import com.ajrdevops.imageliteapi.infra.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        
        return repository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        
        return repository.findById(id);
    }

    @Override
    public List<Image> search(ImageExtension extension, String query) {

        return repository.findByExtensionAndNameOrTagsLike(extension, query);
    }

}
