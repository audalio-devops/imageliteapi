package com.ajrdevops.imageliteapi.domain.service;

import java.util.List;
import java.util.Optional;

import com.ajrdevops.imageliteapi.domain.entity.Image;
import com.ajrdevops.imageliteapi.domain.enums.ImageExtension;

public interface ImageService {
    Image save(Image image);

    Optional<Image> getById(String id);

    List<Image> search(ImageExtension extension, String query);
} 
