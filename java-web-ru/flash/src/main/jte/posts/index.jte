@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <a href="${NamedRoutes.buildPostPath()}">Добавить новый пост</a>
    @if(page.getPosts().isEmpty())
        <p>No posts found</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif
`
)