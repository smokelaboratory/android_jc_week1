package com.smokelaboratory.jc_challenge_week_1.screens

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import com.smokelaboratory.jc_challenge_week_1.R
import com.smokelaboratory.jc_challenge_week_1.dogData

@Composable
fun PuppyListScreen() {

    val context = LocalContext.current

    val selectedDogBreedIndex = remember { mutableStateOf(0) }
    val dogBreedList = remember {
        listOf(
            R.drawable.ic_dog_1,
            R.drawable.ic_dog_2,
            R.drawable.ic_dog_3,
            R.drawable.ic_dog_4,
            R.drawable.ic_dog_5,
            R.drawable.ic_dog_6
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.padding(
                top = 40.dp,
                start = 30.dp,
                end = 30.dp,
                bottom = 30.dp
            )
        ) {
            Text("Search Puppy", fontSize = 30.sp, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color(0xFFF3F3F3))
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Image(imageVector = Icons.Filled.Search, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Search",
                )
            }
        }
        LazyRow(content = {
            item {
                Spacer(modifier = Modifier.size(30.dp))
            }
            itemsIndexed(
                dogBreedList
            ) { index, item ->
                Image(
                    painterResource(id = item),
                    "",
                    modifier = Modifier
                        .padding(start = if (index != 0) 20.dp else 0.dp)
                        .clip(CircleShape)
                        .clickable {
                            selectedDogBreedIndex.value = index
                        }
                        .background(if (selectedDogBreedIndex.value == index) Color.LightGray else Color.Transparent)
                        .size(70.dp)
                        .border(
                            BorderStroke(1.dp, Color.LightGray),
                            CircleShape
                        )
                        .padding(10.dp))
            }
            item {
                Spacer(modifier = Modifier.size(30.dp))
            }
        })
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "Adopt Me",
            fontSize = 25.sp,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(content = {
            item {
                Spacer(modifier = Modifier.size(30.dp))
            }
            itemsIndexed(
                dogData
            ) { index, item ->
                Image(
                    painterResource(id = item.image),
                    "",
                    modifier = Modifier
                        .padding(start = if (index != 0) 20.dp else 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            Brush.radialGradient(
                                listOf(Color.White, item.color),
                                Offset(200f, 325f),
                                500f
                            )
                        )
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    PuppyDetailsAct::class.java
                                ).apply {
                                    putExtras(bundleOf(Pair("dog", item)))
                                }
                            )
                        }
                        .width(150.dp)
                        .height(250.dp)
                        .padding(20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.size(30.dp))
            }
        })
    }
}