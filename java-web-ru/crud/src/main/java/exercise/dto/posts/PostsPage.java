package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
// BEGIN
public class PostsPage {
    List<Post> posts;
    @Setter
    Integer pageNum;
    Boolean isPreviousPagesExist;
    Boolean isNextPagesExist;
}

// END


