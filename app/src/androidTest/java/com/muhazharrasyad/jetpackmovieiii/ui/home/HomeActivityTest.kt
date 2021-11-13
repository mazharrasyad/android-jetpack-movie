package com.muhazharrasyad.jetpackmovieiii.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.muhazharrasyad.jetpackmovieiii.R
import com.muhazharrasyad.jetpackmovieiii.utils.DataDummy
import com.muhazharrasyad.jetpackmovieiii.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateMovies()
    private val dummyTv = DataDummy.generateTvs()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(withText(dummyMovie[0].judul)))
        onView(withId(R.id.tv_tanggal)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tanggal)).check(matches(withText(dummyMovie[0].tanggal)))
        onView(withId(R.id.tv_skor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_skor)).check(matches(withText(dummyMovie[0].skor)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadTvs() {
        onView(withText("TV")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTv() {
        onView(withText("TV")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(withText(dummyTv[0].judul)))
        onView(withId(R.id.tv_tanggal)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tanggal)).check(matches(withText(dummyTv[0].tanggal)))
        onView(withId(R.id.tv_skor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_skor)).check(matches(withText(dummyTv[0].skor)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTv[0].overview)))
    }

    @Test
    fun loadMovieFavorites() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Favorite")).perform(click())
        onView(withId(R.id.rv_movie_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tanggal)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_skor)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadTvFavorites() {
        onView(withText("TV")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Favorite")).perform(click())
        onView(withText("TV Fav")).perform(click())
        onView(withId(R.id.rv_tv_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tanggal)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_skor)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}