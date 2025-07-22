package danrusso.U5_W2_D2_Esercizio.controllers;

import danrusso.U5_W2_D2_Esercizio.entities.BlogPost;
import danrusso.U5_W2_D2_Esercizio.payloads.NewBlogPostPayload;
import danrusso.U5_W2_D2_Esercizio.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return this.blogPostService.findAll();
    }

    @GetMapping("/{blogPostId}")
    public BlogPost getBlogPost(@PathVariable long blogPostId) {
        return this.blogPostService.findById(blogPostId);
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody NewBlogPostPayload body) {
        return this.blogPostService.saveBlogPost(body);
    }

    @PutMapping("/{blogPostId}")
    public BlogPost findBlogPostByIdAndUpdate(@PathVariable long blogPostId, @RequestBody NewBlogPostPayload body) {
        return this.blogPostService.findByIdAndUpdate(blogPostId, body);
    }

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findBlogPostByIdAndDelete(@PathVariable long blogPostId) {
        this.blogPostService.findByIdAndDelete(blogPostId);
    }
}
