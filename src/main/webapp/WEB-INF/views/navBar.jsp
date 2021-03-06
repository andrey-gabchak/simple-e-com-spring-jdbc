<nav class="navbar navbar-expand-md navbar-dark  fixed-top bg-dark">
    <a class="navbar-brand" href="#">Carousel</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/categories">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/admin/categories">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/admin/products">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/admin/users">Users</a>
            </li>
        </ul>
        <form class="form-inline mt-2 mt-md-0" action="/login">
            <button class="btn btn-outline-success my-2 my-sm-0">Sign in</button>
        </form>
        <form class="form-inline mt-2 mt-md-0" style="margin-left: 10px" action="/logout">
            <button class="btn btn-outline-secondary my-2 my-sm-0">Logout</button>
        </form>
    </div>
</nav>
