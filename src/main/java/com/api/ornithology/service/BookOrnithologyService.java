package com.api.ornithology.service;

import com.api.ornithology.models.OrnithologyModel;
import com.api.ornithology.repositories.BookOrnithologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookOrnithologyService {
    final BookOrnithologyRepository bookOrnithologyRepository;

    public BookOrnithologyService(BookOrnithologyRepository bookOrnithologyRepository) {
        this.bookOrnithologyRepository = bookOrnithologyRepository;
    }

    @Transactional
    public OrnithologyModel save(OrnithologyModel ornithologyModel) {
        return bookOrnithologyRepository.save(ornithologyModel);
    }

    public Page<OrnithologyModel> findAll(Pageable pageable) {
        return bookOrnithologyRepository.findAll(pageable);
    }

    public Optional<OrnithologyModel> findById(Long id) {
        return bookOrnithologyRepository.findById(id);
    }

    @Transactional
    public void delete(OrnithologyModel ornithologyModel) {
        bookOrnithologyRepository.delete(ornithologyModel);
    }
}
