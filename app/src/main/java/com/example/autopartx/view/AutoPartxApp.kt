package com.example.autopartx.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.autopartx.R
import com.example.autopartx.model.AutoPart
import com.example.autopartx.model.getListAutoParts


@Composable
fun AutoPartItem(autoPart: AutoPart, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick), // Make the item clickable
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            autoPart.image?.let { painterResource(id = it) }?.let { painter ->
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp)
                        .clip(RectangleShape)
                )
            }
            Column {
                Text(
                    text = "Name: ${autoPart.name}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Price: ${autoPart.price}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoPartScaffold(autoParts: List<AutoPart> , onAutoPartClick: (AutoPart) -> Unit) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(250.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.autopartxlogo), // Replace with your image resource
                        contentDescription = "Top Bar Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp) // Set the size of the image as needed
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Welcome",
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    ) // You can customize the style as needed
                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        }
    ) {
        // Screen content
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.autopartxlogo), // Replace with your image resource
                                contentDescription = "Top Bar Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp) // Set the size of the image as needed
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(30.dp))
                            Text("AutoPartX") // Title with copyright
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "AutoPartX © 2024 ",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f), // Push text to the start of the bar
                        color = MaterialTheme.colorScheme.onPrimary // Use appropriate text color
                    )
                }
            }
        ) { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.fillMaxSize()
            ) {
                items(autoParts) { autoPart ->
                    AutoPartItem(autoPart = autoPart, onClick = { onAutoPartClick(autoPart) })
                }
            }
        }
    }
}


@Composable
fun AutoPartItemDetails(autoPart: AutoPart, onBackClick: () -> Unit) {
    // Use a Box to fill the entire screen
    Box(
        modifier = Modifier
            .fillMaxSize() // Fill the entire screen
            .padding(16.dp)
            ,contentAlignment = Alignment.Center // Optional padding around the content
    ) {
        // Card to display the details
        Card(
            modifier = Modifier
                .fillMaxSize() // Fill the entire Box
                .padding(16.dp), // Padding inside the card
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Display the image if available
                autoPart.image?.let { imageId ->
                    Image(
                        painter = painterResource(id = imageId),
                        contentDescription = null, // Provide a content description for accessibility
                        modifier = Modifier
                            .size(100.dp) // Set a size for the image
                            .align(Alignment.CenterHorizontally) // Center the image
                    )
                }

                // Display the name
                Text(
                    text = "Name: ${autoPart.name ?: "N/A"}",
                    style = MaterialTheme.typography.titleLarge // Use MaterialTheme for consistent styling
                )

                // Display the price
                Text(
                    text = "Price: ${autoPart.price?.toString() ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )

                // Display the part number
                Text(
                    text = "Part Number: ${autoPart.partNumber ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )

                // Display the category
                Text(
                    text = "Category: ${autoPart.category ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )

                // Display the brand
                Text(
                    text = "Brand: ${autoPart.brand ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )

                // Back button to return to the list
                Button(onClick = onBackClick) {
                    Text("Back to List")
                }
            }
        }
    }
}


@Composable
fun AutoPartApp() {
    val autoParts = getListAutoParts()
    var selectedAutoPart by remember { mutableStateOf<AutoPart?>(null) }

    MaterialTheme {
        Surface {
            if (selectedAutoPart == null) {
                AutoPartScaffold(autoParts = autoParts) { autoPart ->
                    selectedAutoPart = autoPart // Set the selected part for details
                }
            } else {
                AutoPartItemDetails(autoPart = selectedAutoPart!!) {
                    selectedAutoPart = null // Reset to show the list again
                }
            }
        }
    }
}
