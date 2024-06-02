package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

public class PostsController {

    // BEGIN
    private static final int POSTS_PER_PAGE = 5;
    private static final int MIN_PAGE_NUM = 1;
    private static final int MAX_PAGE_NUM = getMaxPageNum();

    // Список постов
    public static void index (Context ctx) {
        var pageNum = ctx.queryParamAsClass("page", Integer.class).getOrDefault(MIN_PAGE_NUM);
        var postsList = PostRepository.findAll(pageNum, POSTS_PER_PAGE);
        var page = new PostsPage(postsList, pageNum, (pageNum > MIN_PAGE_NUM), (pageNum < MAX_PAGE_NUM));
        ctx.render("posts/index.jte", model("page", page));
    }

    // Страница поста
    public static void show (Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    // Форма создания нового поста
    public static void buildForm (Context ctx) {
    }

    // Создание нового поста
    public static void create (Context ctx) {
    }

    // Форма редактирования поста
    public static void editForm (Context ctx) {
    }

    // Обновление страницы поста
    public static void update (Context ctx) {
    }

    // Удаление поста
    public static void destroy (Context ctx) {
    }

    private static int getMaxPageNum () {
        int maxPageNum = PostRepository.getEntities().size() / POSTS_PER_PAGE;
        if (PostRepository.getEntities().size() % POSTS_PER_PAGE > 0)   maxPageNum++;
        return maxPageNum;
    }
    // END
}
