package com.geekbrains.tests

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.search.MainActivity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])

class MainActivityTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun buttonToDetails_IsWorking() {
        scenario.onActivity {
            val intent = DetailsActivity.getIntent(context, 0)
            assertEquals(intent.getIntExtra(DetailsActivity.TOTAL_COUNT_EXTRA, 0), 0)
        }
    }

    @Test
    fun activity_IsResumed() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun editText_isVisible() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            assertEquals(View.VISIBLE, editText.visibility)
        }
    }

    @Test
    fun toDetailsButton_isVisible() {
        scenario.onActivity {
            val button = it.findViewById<Button>(R.id.toDetailsActivityButton)
            assertEquals(View.VISIBLE, button.visibility)
        }
    }

    @Test
    fun recyclerView_isVisible() {
        scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recyclerView)
            assertEquals(View.VISIBLE, recyclerView.visibility)
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}