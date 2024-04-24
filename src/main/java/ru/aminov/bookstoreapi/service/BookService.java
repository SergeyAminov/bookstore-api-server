package ru.aminov.bookstoreapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.aminov.bookstoreapi.dto.BookDto;
import ru.aminov.bookstoreapi.mapper.BookMapper;
import ru.aminov.bookstoreapi.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Transactional
    public List<BookDto> findAll() {
        return this.bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    public BookDto getById(Integer id) throws Exception{
        if (!Objects.isNull(id))
            return this.bookMapper.toDto(this.bookRepository.findById(id).get());    
        throw new Exception("Wrong id");
        
    }

}
