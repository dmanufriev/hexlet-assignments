package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;

// BEGIN
@RestController
@RequestMapping("/api/users")
public class PostsController {
    private List<Post> posts = new ArrayList<>();

    @GetMapping("/{id}/posts")
    public List<Post> index(@PathVariable int id) {
        return posts.stream().toList();
    }

    @PostMapping(path = "/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable int id,
                       @RequestBody Post newPost) {
        Post post = new Post();
        post.setUserId(id);
        post.setSlug(newPost.getSlug());
        post.setTitle(newPost.getTitle());
        post.setBody(newPost.getBody());
        posts.add(post);
        return post;
    }
}
// END
