package com.ajrdevops.imageliteapi.infra.repository;

import static com.ajrdevops.imageliteapi.infra.repository.specs.GenericSpecs.conjunction;
import static com.ajrdevops.imageliteapi.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import com.ajrdevops.imageliteapi.domain.entity.Image;
import com.ajrdevops.imageliteapi.domain.enums.ImageExtension;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image>{

    /**
     * 
     * @param extension
     * @param query
     * @return
     * 
     * select * from  image 
     * where 1 = 1 and extension = 'PNG' and (name like 'QUERY' or tags like 'QUERY')
     * 
     */


    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
        // select * from  image where 1 = 1
        Specification<Image> spec = where(conjunction());
        
        if (extension != null) {
            //and extension = 'PNG'
            spec = spec.and(extensionEqual(extension));
        }

        if (StringUtils.hasText(query)) {
            // and (name like 'QUERY' or tags like 'QUERY')
            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));            
        }
        return findAll(spec);
    }

}
