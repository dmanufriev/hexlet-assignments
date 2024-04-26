@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h1 class="text-body-emphasis">Текущий пользователь</h1>
    <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
    <p>${page.getUser().getEmail()}</p>
`
)