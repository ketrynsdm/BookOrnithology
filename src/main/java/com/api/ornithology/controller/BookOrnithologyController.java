package com.api.ornithology.controller;

import com.api.ornithology.domain.researcher.DateListResearcher;
import com.api.ornithology.domain.researcher.ResearcherRepository;
import com.api.ornithology.dtos.BookOrnithologyDto;
import com.api.ornithology.models.OrnithologyModel;
import com.api.ornithology.service.BookOrnithologyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/book-ornithology")
public class BookOrnithologyController {

    private ResearcherRepository repository;
    private BookOrnithologyService bookOrnithologyService;

    public BookOrnithologyController(BookOrnithologyService bookOrnithologyService, ResearcherRepository repository) {
        this.bookOrnithologyService = bookOrnithologyService;
        this.repository = repository;
    }

//    @PostMapping
//    public ResponseEntity<Object> saveBookOrnithologyDto(@RequestBody @Valid BookOrnithologyDto bookOrnithologyDto) {
//        OrnithologyModel ornithologyModel = new OrnithologyModel();
//        BeanUtils.copyProperties(bookOrnithologyDto, ornithologyModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(bookOrnithologyService.save(ornithologyModel));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<OrnithologyModel>> getAllListResponseEntity(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
//        return ResponseEntity.status(HttpStatus.OK).body(bookOrnithologyService.findAll(pageable));
//    }

    @GetMapping
    public ResponseEntity<Page<DateListResearcher>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        var pag = repository.findAllByAtivoTrue(page).map(DateListResearcher::new);
        return ResponseEntity.ok(pag);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOneResponseEntity(@PathVariable(value = "id") Long id) {
//        Optional<OrnithologyModel> ornithologyModelOptional = bookOrnithologyService.findById(id);
//        if(!ornithologyModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ornithology not found");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(ornithologyModelOptional.get());
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteResponseEntity(@PathVariable(value = "id") Long id) {
//        Optional<OrnithologyModel> ornithologyModelOptional = bookOrnithologyService.findById(id);
//        if(!ornithologyModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ornithology not found");
//        }
//        bookOrnithologyService.delete(ornithologyModelOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("ornithology deleted successfully");
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateResponseEntity(@PathVariable(value = "id") Long id, @RequestBody @Valid BookOrnithologyDto bookOrnithologyDto) {
//        Optional<OrnithologyModel> ornithologyModelOptional = bookOrnithologyService.findById(id);
//        OrnithologyModel ornithologyModel = new OrnithologyModel();
//        BeanUtils.copyProperties(bookOrnithologyDto, ornithologyModel);
//
//        ornithologyModel.setId(ornithologyModelOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(bookOrnithologyService.update(ornithologyModel));
//
//    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
    var researcher = repository.getReferenceById(id);
    researcher.delete();

    return ResponseEntity.noContent().build();
    }
}
