package sree.ddukk.voicetotext.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import sree.ddukk.voicetotext.ui.AddDiaryScreen
import sree.ddukk.voicetotext.ui.HomeScreen
import sree.ddukk.voicetotext.data.DiaryViewModel
import sree.ddukk.voicetotext.ui.FavoritesScreen
import sree.ddukk.voicetotext.ui.SettingsScreen
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: DiaryViewModel = viewModel()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Diary,
        BottomNavItem.Favorite,
        BottomNavItem.Settings
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFFBEFEF),
                tonalElevation = 0.dp // Removes shadow
            ) {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        alwaysShowLabel = true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF4B2E2E),
                            selectedTextColor = Color(0xFF4B2E2E),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(navController)
            }

            composable(BottomNavItem.Diary.route) {
                AddDiaryScreen(
                    onNavigateToFavorites = {
                        navController.navigate(BottomNavItem.Favorite.route)
                    },
                    viewModel = viewModel
                )
            }

            composable(BottomNavItem.Favorite.route) {
                FavoritesScreen(viewModel = viewModel)
            }

             composable(BottomNavItem.Settings.route) {
                 SettingsScreen()
             }
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Journal")
    data object Diary : BottomNavItem("diary", Icons.Default.Edit, "Write")
    data object Favorite : BottomNavItem("favorite", Icons.Default.Favorite, "Memories")
    data object Settings : BottomNavItem("settings", Icons.Default.Settings, "More")
}
