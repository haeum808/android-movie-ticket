package woowacourse.movie.home

import woowacourse.movie.db.Movies

class HomePresenter(
    private val view: HomeContract.View,
) : HomeContract.Presenter {

    init {
        loadMovies()
    }

    override fun loadMovies() {
        val movies = Movies.obtainMovies().toList()
        view.showMovies(movies)
    }

    override fun deliverMovieId(movieId: Int) {
        view.moveToReservationDetail(movieId)
    }
}
