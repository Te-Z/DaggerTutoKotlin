package app.tez.daggertutokotlin.utils

import java.util.*

class DateUtilsUnitTest: DateUtils(){

    override fun getCurrentDate(): Date = generateTestCurrentDate()

    private fun generateTestCurrentDate(): Date {
        val mCalendar = Calendar.getInstance()
        mCalendar.set(1991, 9, 19, 0, 0, 0)

        return mCalendar.time
    }
}