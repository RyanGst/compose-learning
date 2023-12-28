package click.ryangst.composetodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import click.ryangst.composetodo.ui.theme.ComposeTodoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTodoTheme {
                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(listOf<String>()) }

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(value = name, onValueChange = { text ->
                            name = text
                        }, modifier = Modifier.weight(1f), label = { Text(text = "Name") })
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = {
                                if (name.isNotBlank()) {
                                    names = names + name
                                    name = ""
                                }
                            },
                            modifier= Modifier.size(60.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    }

                    LazyColumn() {
                        items(names) { name ->
                            Text(text = name, modifier = Modifier.padding(8.dp))
                            Divider()
                        }
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        ComposeTodoTheme {
            Column {
                Text(text = "Hello World!")
            }
        }
    }
}