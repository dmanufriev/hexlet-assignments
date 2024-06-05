@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if (page.getName() != null)
        <p>Текущий пользователь: ${page.getName().toString()}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти"/>
        </form>
    @else
        <h2><a href="${NamedRoutes.buildSessionPath()}">Войти</a></h2>
    @endif
`
)