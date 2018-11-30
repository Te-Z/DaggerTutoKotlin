package app.tez.daggertutokotlin.utils

import java.util.*

class DateUtilsTest: DateUtils() {

    override fun getCurrentDate(): Date {
        val cal = Calendar.getInstance()
        cal.set(1991, 9, 19, 0, 0, 0)

        return cal.time
    }
}