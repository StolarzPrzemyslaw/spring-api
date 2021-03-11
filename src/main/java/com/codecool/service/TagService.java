package com.codecool.service;


import com.codecool.exception.EntityNotFoundException;
import com.codecool.model.Category;
import com.codecool.model.Tag;
import com.codecool.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> readAll() {
        return tagRepository.findAll();
    }

    public Tag create(Tag newTag) {
        return tagRepository.save(newTag);
    }

    public Tag read(Long id) {
        return tagRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public Tag update(Tag updatedTag, Long id) {
        return tagRepository.findById(id).
                map(entity -> {
                    entity.setName(updatedTag.getName());
                    return tagRepository.save(entity);
                }).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public void delete(Long id){
        tagRepository.deleteById(id);
    }
}
