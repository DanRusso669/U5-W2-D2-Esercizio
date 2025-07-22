package danrusso.U5_W2_D2_Esercizio.services;

import danrusso.U5_W2_D2_Esercizio.entities.Author;
import danrusso.U5_W2_D2_Esercizio.exceptions.NotFoundException;
import danrusso.U5_W2_D2_Esercizio.payloads.NewAuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private List<Author> authorsDB =new ArrayList<>();

    public List<Author> findAll(){
        return this.authorsDB;
    }

    public Author findById(long id){
        Author found = null;
        for (Author author : this.authorsDB){
            if (author.getId() == id) found = author;
        }

        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public Author saveAuthor(NewAuthorPayload payload){
        Author newAuthor = new Author(payload.getName(), payload.getSurname(), ,payload.getEmail(), payload.getDOB());
        this.authorsDB.add(newAuthor);
        System.out.println("New author added successfully.");
        return newAuthor;
    }

    public Author findByIdAndUpdate(long id, NewAuthorPayload payload){
        Author found = this.findById(id);
        found.setName(payload.getName());
        found.setSurname(payload.getSurname());
        found.setEmail(payload.getEmail());
        found.setDOB(payload.getDOB());

        return found;
    }

    public void findByIdAndDelete(long id){
        Author found = this.findById(id);
        this.authorsDB.remove(found);
        System.out.println("Author removed successfully.");
    }
}
