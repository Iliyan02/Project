const moviesList = document.getElementById('moviesList')
const searchBar = document.getElementById('searchInput')

const allMovies = [];

fetch("http://localhost:8080/movies/api").
then(response => response.json()).
then(data => {
    for (let movie of data) {
        allMovies.push(movie);
    }
})

console.log(allMovies);

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    let filteredMovies = allMovies.filter(movie => {
        return movie.name.toLowerCase().includes(searchingCharacters)
            || movie.directorEntity.name.toLowerCase().includes(searchingCharacters);
    });
    displayMovies(filteredMovies);
})



const displayMovies = (movies) => {
    moviesList.innerHTML = movies
        .map((m) => {
            return ` <div class="row mt-3 mb-3">
                <div class="post">
                    <img class="movie-home-images" src="https://resizing.flixster.com/FQ9SS59M0qKg7f7U91ofk2UVy_s=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzg3NGEwM2NkLTI2N2QtNDk4ZS05OGY5LWU0MmQ5NzAyZGJmMC53ZWJw" alt="The Martian">
                    <a class="movie-name" href="/movies/movie-page-details/${m.id}">${m.name}</a>
                    <p class="post_info">${m.genre}} | ${m.duration}</p>
                </div>
            </div>`
        })
        .join('');

}