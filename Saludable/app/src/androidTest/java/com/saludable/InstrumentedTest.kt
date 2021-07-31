package com.saludable

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.saludable.view.Login
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule



@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    @get:Rule
    var activityRule: ActivityTestRule<Login> = ActivityTestRule(Login::class.java)

    @Test
    fun completeText() {
        onView(
            ViewMatchers.withId(R.id.login_et_usuario))
            .perform(ViewActions.typeText("1"), ViewActions.closeSoftKeyboard())
        onView(
            ViewMatchers.withId(R.id.login_et_pass))
            .perform(ViewActions.typeText("1"), ViewActions.closeSoftKeyboard())
        onView(
            ViewMatchers.withId(R.id.login_btn_login))
            .perform(ViewActions.click())
        onView(
            ViewMatchers.withId(R.id.tv_login_resultado))
            //.check(ViewAssertions.matches(withText("Validado")))
    }

}