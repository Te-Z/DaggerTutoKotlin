package app.tez.daggertutokotlin

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import app.tez.daggertutokotlin.base.TestDaggerTutoApplication
import app.tez.daggertutokotlin.utils.DateUtils
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(application = TestDaggerTutoApplication::class)
class MainActivityTest {

    private lateinit var activity: MainActivity
    @Inject lateinit var dateUtils: DateUtils

    @Before
    fun setUp(){
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    @Throws(Exception::class)
    fun shouldShowProperDate() {
        val date = activity.findViewById(R.id.activity_main_date) as TextView
        assertEquals("Sat Oct 19 00:00:00 CET 1991", date.text)
    }

    @Test
    @Throws(Exception::class)
    fun shouldStoreProperEmail() {
        val prefsUtils = activity.prefs
        prefsUtils.saveCurrentEmail("elvis@hotmail.com")

        prefsUtils.saveCurrentEmail("test@hotmail.com")
        assertEquals("test@hotmail.com", prefsUtils.getCurrentEmail())
    }

    @Test
    @Throws(Exception::class)
    fun shouldDisplayProperEmail() {
        // Before test
        val editText = activity.findViewById(R.id.activity_main_edittext) as EditText
        editText.setText("elvis@hotmail.com")
        val button = activity.findViewById(R.id.activity_main_button) as Button
        button.performClick()

        // Actual test
        val textView = activity.findViewById(R.id.activity_main_saved_email) as TextView
        assertEquals("elvis@hotmail.com", textView.text)
    }
}