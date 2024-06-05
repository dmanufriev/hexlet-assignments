@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

<!-- sessions/build.jte -->
<!-- Нужно не забыть добавить маршрут в NamedRoutes -->
<form action="${NamedRoutes.loginPath()}" method="post">
    @if (page.getError() != null)
        <p>${page.getError()}</p>
    @endif
    <input type="text" value="${page.getName()}" name="name" required />
    <input type="password" name="password" />
    <input type="submit" />
</form>