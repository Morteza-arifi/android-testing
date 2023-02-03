package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * @author Morteza Arifi on 1/26/23.
 */
internal class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_notCompleted_returnHundredZero() {

        val tasks = listOf<Task>(
            Task("title", "description", false)
        )

        val statsResult = getActiveAndCompletedStats(tasks)

        assertThat(statsResult.activeTasksPercent).isEqualTo(100f)
        assertThat(statsResult.completedTasksPercent).isEqualTo(0f)
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnZeroHundred() {

        val tasks = listOf<Task>(
            Task("title", "description", true)
        )

        val statsResult = getActiveAndCompletedStats(tasks)

        assertThat(statsResult.activeTasksPercent).isEqualTo(0f)
        assertThat(statsResult.completedTasksPercent).isEqualTo(100f)
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnSixtyForty() {

        val tasks = listOf<Task>(
            Task("title1", "description1", true),
            Task("title2", "description2", true),
            Task("title3", "description3", false),
            Task("title4", "description4", false),
            Task("title5", "description5", false),
        )

        val statsResult = getActiveAndCompletedStats(tasks)

        assertThat(statsResult.activeTasksPercent).isEqualTo(60f)
        assertThat(statsResult.completedTasksPercent).isEqualTo(40f)
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnZeros() {

        val tasks = listOf<Task>()

        val statsResult = getActiveAndCompletedStats(tasks)

        assertThat(statsResult.activeTasksPercent).isEqualTo(0f)
        assertThat(statsResult.completedTasksPercent).isEqualTo(0f)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnZeros() {

        val statsResult = getActiveAndCompletedStats(null)

        assertThat(statsResult.activeTasksPercent).isEqualTo(0f)
        assertThat(statsResult.completedTasksPercent).isEqualTo(0f)
    }
}