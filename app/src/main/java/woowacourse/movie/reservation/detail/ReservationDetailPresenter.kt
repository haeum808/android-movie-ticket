package woowacourse.movie.reservation.detail

import woowacourse.movie.db.Movies
import woowacourse.movie.model.ChangeTicketCountResult
import woowacourse.movie.model.InRange
import woowacourse.movie.model.OutOfRange
import woowacourse.movie.model.Ticket
import java.time.LocalDate

class ReservationDetailPresenter(
    private val view: ReservationDetailContract.View,
    private val movieId: Int,
    private val ticket: Ticket = Ticket(),
) : ReservationDetailContract.Presenter {
    override fun loadMovie() {
        view.showMovieInformation(Movies.obtainMovie(movieId))
    }

    override fun loadScreeningTimes(date: LocalDate) {
        view.showScreeningTimes(Movies.obtainScreeningTimes(date))
    }

    override fun loadScreeningDates() {
        view.showScreeningDates(Movies.obtainScreeningDates(movieId))
    }

    override fun increaseCount() {
        val result = ticket.increaseCount()
        handleNumberOfTicketsBounds(result)
    }

    override fun decreaseCount() {
        val result = ticket.decreaseCount()
        handleNumberOfTicketsBounds(result)
    }

    override fun deliverReservationInformation() {
        view.moveToReservationFinished(movieId, ticket.count)
    }

    private fun handleNumberOfTicketsBounds(result: ChangeTicketCountResult) {
        when (result) {
            is InRange -> {
                view.updateCount(ticket.count)
            }
            is OutOfRange -> view.showErrorToast()
        }
    }
}
