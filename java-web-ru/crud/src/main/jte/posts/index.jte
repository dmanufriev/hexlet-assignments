@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <p>No posts found</p>
    @else
        @for(var post : page.getPosts())
            <div class="mx-auto p-2">
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </div>
        @endfor
    @endif
    <form action="/posts" method="get">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                @if(page.getIsPreviousPagesExist())
                <li class="page-item">
                    <a class="page-link" href="posts?page=${page.getPageNum() - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                @endif
                <li class="page-item active">
                    <a class="page-link" href="posts?page=${page.getPageNum()}">${page.getPageNum()}</a>
                </li>
                @if(page.getIsNextPagesExist())
                <li class="page-item">
                    <a class="page-link" href="posts?page=${page.getPageNum() + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                @endif
            </ul>
        </nav>
    </form>
`
)
