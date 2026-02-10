package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.exceptions.ResourceNotFoundException;
import com.RollNo8.MyLibraryManagementPlatform.repo.AuthorsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorsService {

    private final AuthorsRepo authorsRepo;

    public List<Author> getAllAuthors(){
        log.debug("All Authors Are Returned");

        //Why log.debug() works here ?
        // Because Lombok can generates the below line automatically in the background due to annotation:@Slf4j -
        //private static final Logger log = LoggerFactory.getLogger(BooksService.class);

        return authorsRepo.findAll();
    }

    public Author getAuthorById(long authorId) {
        return authorsRepo.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("No Author found with the author id: "+authorId));
    }

    public void updateAuthor(long authorId, Author updatedAuthor) {

        if(updatedAuthor.getAuthorId()!=0){
            throw new IllegalArgumentException("Your author input consist of author_id which is not allowed");
        }

        Author existingAuthor = getAuthorById(authorId);

        existingAuthor.setAuthorName(updatedAuthor.getAuthorName());
        existingAuthor.setNationality(updatedAuthor.getNationality());
        existingAuthor.setModified(updatedAuthor.getModified());

        authorsRepo.save(existingAuthor);
    }


}
