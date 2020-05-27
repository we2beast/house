package com.lab.house.core

import com.lab.house.hcs.entities.Month

class Utils {

    companion object {

        fun getPreviousDate(currentMonth: Int, currentYear: Int): Pair<Month, Int> {
            val previousMonth = if (currentMonth == 0) {
                Month.fromInt(11)
            } else {
                Month.fromInt(currentMonth - 1)
            }

            val previousYear = if (previousMonth.ordinal != 0) {
                currentYear
            } else {
                currentYear - 1
            }

            return Pair(previousMonth, previousYear)
        }

    }

}
