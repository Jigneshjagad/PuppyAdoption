package com.example.androiddevchallenge.ui.controller

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.controller.Screens.PuppyDetails


object Screens {
    const val Home = "home"
    const val PuppyDetails = "puppyDetails"

    object PuppyDetailArgs {
        const val PuppyId = "puppyId"
    }
}

class Action(navController: NavHostController){
    val openDetails : (Int) -> Unit = {
            puppyId->
        navController.navigate("$PuppyDetails/$puppyId")
    }

    val navigateBack : () -> Unit = {
        navController.popBackStack()
    }
}