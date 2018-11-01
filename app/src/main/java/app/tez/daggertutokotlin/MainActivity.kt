package app.tez.daggertutokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import app.tez.daggertutokotlin.utils.DateUtils
import app.tez.daggertutokotlin.utils.SharedPrefsUtils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var dateTv: TextView
    private lateinit var emailTv: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    @Inject
    lateinit var prefs: SharedPrefsUtils
    @Inject
    lateinit var dateUtils: DateUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.configureDI()
        this.setCurrentDate()
        this.setEmailForm()
    }

    private fun configureDI() = (application as DaggerTutoApplication).getTutoComponent().inject(this)

    private fun setCurrentDate(){
        dateTv = activity_main_date
        dateTv.text = dateUtils.getCurrentDate().toString()
    }

    private fun setEmailForm(){
        emailTv = activity_main_saved_email
        editText = activity_main_edittext
        button = activity_main_button

        button.setOnClickListener {
            val savedEmail = emailTv.text.toString()
            prefs.saveCurrentEmail(savedEmail)
            emailTv.text = prefs.getCurrentEmail()
        }
    }
}
