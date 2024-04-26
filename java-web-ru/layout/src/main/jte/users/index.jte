@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1 class="text-body-emphasis">Зарегистрированные пользователи</h1>
    @if(page.getUsers().isEmpty())
        <p>No users found</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <p><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></p>
            </div>
        @endfor
    @endif
`
)
