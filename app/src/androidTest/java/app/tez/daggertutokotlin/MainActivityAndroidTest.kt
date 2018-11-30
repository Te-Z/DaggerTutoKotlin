package app.tez.daggertutokotlin

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import app.tez.daggertutokotlin.di.*

@RunWith(AndroidJUnit4::class)
class MainActivityAndroidTest {

    @get:Rule
    val activityTestRule: ActivityTestRule<MainActivity> = object : ActivityTestRule<MainActivity>(MainActivity::class.java){
        override fun beforeActivityLaunched() {
            val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as DaggerTutoApplication

            val testComponent: AndroidTestComponent = DaggerAndroidTestComponent.builder()
                    .appModule(AppModule(app))
                    .storageModule(StorageModule())
                    .utilsTestModule(UtilsTestModule())
                    .build()
            app.tutoComponent = testComponent
            Log.d("", "-----testComponent injection")
        }
    }

    @Test
    fun isTheRightDateDisplaying() {
        onView(withId(R.id.activity_main_date)).check(matches(withText("Sat Oct 19 00:00:00 GMT+01:00 1991")))
    }

    @Test
    fun isTheRightEmailSaving() {
        // Before test
        val prefsUtils = activityTestRule.activity.prefs
        prefsUtils.saveCurrentEmail("elvis@hotmail.com")

        // Actual test
        onView(withId(R.id.activity_main_edittext)).perform(typeText("hello@world.fr"))
        onView(withId(R.id.activity_main_button)).perform(click())
        onView(withId(R.id.activity_main_saved_email)).check(matches(withText("hello@world.fr")))
    }
}