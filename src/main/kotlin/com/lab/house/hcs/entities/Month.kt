package com.lab.house.hcs.entities

enum class Month(val value: Int) {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}
