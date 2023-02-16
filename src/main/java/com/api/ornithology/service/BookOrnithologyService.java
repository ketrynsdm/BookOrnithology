package com.api.ornithology.service;

import com.api.ornithology.models.OrnithologyModel;
import com.api.ornithology.repositories.BookOrnithologyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    public OrnithologyModel update (OrnithologyModel ornithologyModel){
     //   Optional<OrnithologyModel> ornithologyModelOptional = bookOrnithologyService.findById(ornithologyModel.getId());
       return this.save(ornithologyModel);

    }

    @Transactional
    public void delete(OrnithologyModel ornithologyModel) {
        bookOrnithologyRepository.delete(ornithologyModel);
    }


}
