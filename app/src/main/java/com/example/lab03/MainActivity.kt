package com.example.lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample()
        }
    }
}

@Composable
fun ScaffoldExample() {
    // Composable principal que muestra algunos ejemplos
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Comenzando con Jetpack Compose")
        Button(onClick = { /* Acción del botón */ }) {
            Text("Botón de Prueba")
        }
        BottomNavigationExample() // Incluye la barra de navegación corregida
    }
}

@Composable
fun LazyRowExample() {
    LazyRow {
        items(10) {
            Text("Item #$it", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(10) {
            Text("Item #$it", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun AlertDialogExample() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Título del Diálogo") },
            text = { Text("Este es el mensaje del diálogo.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
fun BottomNavigationExample() {
    var selectedIndex by remember { mutableStateOf(0) }
    // Se utilizan NavigationBar y NavigationBarItem de Material 3.
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Inicio"
                )
            },
            selected = selectedIndex == 0,
            onClick = { selectedIndex = 0 }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = android.R.drawable.ic_menu_search),
                    contentDescription = "Buscar"
                )
            },
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 }
        )
    }
}

@Composable
fun CardExample() {
    Card(modifier = Modifier.padding(16.dp)) {
        Text("Card Example", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Composable
fun DividerExample() {
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 8.dp),
        thickness = 1.dp,
        color = Color.Gray
    )
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = { /* Acción del botón */ }) {
        Text("+")
    }
}

@Composable
fun IconExample() {
    Icon(painterResource(id = android.R.drawable.ic_menu_camera), contentDescription = "Icono")
}

@Composable
fun ImageExample() {
    Image(painterResource(id = android.R.drawable.ic_menu_camera), contentDescription = "Imagen")
}

@Composable
fun ProgressBarExample() {
    CircularProgressIndicator()
}

@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") }
    )
}

@Composable
fun RadioButtonExample() {
    var selected by remember { mutableStateOf(false) }
    RadioButton(
        selected = selected,
        onClick = { selected = !selected }
    )
}

@Composable
fun SliderExample() {
    var value by remember { mutableStateOf(0.5f) }
    Slider(
        value = value,
        onValueChange = { value = it }
    )
}

@Composable
fun SnackbarExample() {
    Snackbar {
        Text("Este es un Snackbar")
    }
}

@Composable
fun SpacerExample() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun TabRowExample() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = selectedTabIndex) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = { selectedTabIndex = 0 },
            text = { Text("Tab 1") }
        )
        Tab(
            selected = selectedTabIndex == 1,
            onClick = { selectedTabIndex = 1 },
            text = { Text("Tab 2") }
        )
    }
}

@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(false) }
    Switch(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(title = { Text("TopAppBar Example") })
}

@Composable
fun NavigationRailExample() {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationRail {
        NavigationRailItem(
            icon = {
                Icon(
                    painterResource(id = android.R.drawable.ic_menu_info_details),
                    contentDescription = "Información"
                )
            },
            selected = selectedItem == 0,
            onClick = { selectedItem = 0 }
        )
        NavigationRailItem(
            icon = {
                Icon(
                    painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "Galería"
                )
            },
            selected = selectedItem == 1,
            onClick = { selectedItem = 1 }
        )
    }
}

@Composable
fun SurfaceExample() {
    Surface(modifier = Modifier.padding(16.dp), color = Color.LightGray) {
        Text("Surface Example", modifier = Modifier.padding(16.dp))
    }
}
