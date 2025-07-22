package danrusso.U5_W2_D2_Esercizio.controllers;

import danrusso.U5_W2_D2_Esercizio.entities.Author;
import danrusso.U5_W2_D2_Esercizio.payloads.NewAuthorPayload;
import danrusso.U5_W2_D2_Esercizio.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{authorId}")
    public Author findById(@PathVariable long authorId) {
        return this.authorService.findById(authorId);
    }

    @PostMapping
    public Author createAuthor(@RequestBody NewAuthorPayload body) {
        return this.authorService.saveAuthor(body);
    }

    @PutMapping("/{authorId}")
    public Author findByIdAndUpdate(@PathVariable long authorId, @RequestBody NewAuthorPayload body) {
        return this.authorService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }
}
