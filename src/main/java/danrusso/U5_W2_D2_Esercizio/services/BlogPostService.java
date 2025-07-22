package danrusso.U5_W2_D2_Esercizio.services;

import danrusso.U5_W2_D2_Esercizio.entities.BlogPost;
import danrusso.U5_W2_D2_Esercizio.exceptions.NotFoundException;
import danrusso.U5_W2_D2_Esercizio.payloads.NewBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService {
    private List<BlogPost> blogpostsDB = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogpostsDB;
    }

    public BlogPost findById(long id) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogpostsDB) {
            if (blogPost.getId() == id) found = blogPost;
        }

        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public BlogPost saveBlogPost(NewBlogPostPayload payload) {
        BlogPost newBlogPost = new BlogPost(payload.getCategory(), payload.getTitle(), payload.getContent(), payload.getReadingTime());
        this.blogpostsDB.add(newBlogPost);
        System.out.println("New blog post added successfully.");
        return newBlogPost;
    }

    public BlogPost findByIdAndUpdate(long id, NewBlogPostPayload payload) {
        BlogPost found = this.findById(id);
        found.setCategory(payload.getCategory());
        found.setTitle(payload.getTitle());
        found.setContent(payload.getContent());
        found.setReadingTime(payload.getReadingTime());

        return found;
    }

    public void findByIdAndDelete(long id) {
        BlogPost found = this.findById(id);
        this.blogpostsDB.remove(found);
        System.out.println("Blog post removed successfully.");
    }
}
