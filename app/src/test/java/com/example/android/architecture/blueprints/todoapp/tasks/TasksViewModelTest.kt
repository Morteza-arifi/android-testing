package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Morteza Arifi on 1/27/23.
 */
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupViewModel(){
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun addNewTask_setNewTask(){

        // Given view model

        // When
        tasksViewModel.addNewTask()

        // Then new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled()).isNotNull()

    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given viewModel

        // When setAllFilters called
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        // Then tasks add view should be visible
        val value = tasksViewModel.tasksAddViewVisible.getOrAwaitValue()
        assertThat(value).isTrue()

    }


}