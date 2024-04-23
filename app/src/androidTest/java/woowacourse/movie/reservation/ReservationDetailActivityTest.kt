package woowacourse.movie.reservation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import woowacourse.movie.R
import woowacourse.movie.TestFixture.moviesFirstItem
import woowacourse.movie.home.HomeActivity
import woowacourse.movie.reservation.detail.ReservationDetailActivity

@RunWith(AndroidJUnit4::class)
class ReservationDetailActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(ReservationDetailActivity::class.java)

    @Test
    fun `빼기_버튼을_누르면_값이_감소한다`() {
        onView(withId(R.id.button_reservation_detail_minus))
            .perform(click())

        onView(withId(R.id.text_view_reservation_detail_number_of_tickets))
            .check(matches(withText("1")))
    }

    @Test
    fun `더하기_버튼을_누르면_값이_증가한다`() {
        onView(withId(R.id.button_reservation_detail_plus))
            .perform(click())

        onView(withId(R.id.text_view_reservation_detail_number_of_tickets))
            .check(matches(withText("2")))
    }
}
