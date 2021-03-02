package com.smokelaboratory.jc_challenge_week_1.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smokelaboratory.jc_challenge_week_1.DogData
import com.smokelaboratory.jc_challenge_week_1.R

@Composable
fun PuppyDetailsScreen(dogData: DogData) {

    val selectedDogDetailIndex = remember { mutableStateOf(0) }
    val dogDetails = remember {
        listOf(
            Pair(
                R.drawable.ic_food,
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
            ),
            Pair(
                R.drawable.ic_house,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries"
            ),
            Pair(
                R.drawable.ic_paw,
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia."
            ),
            Pair(
                R.drawable.ic_walking,
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum."
            ),
            Pair(
                R.drawable.ic_health,
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form."
            ),
            Pair(
                R.drawable.ic_love,
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing."
            ),
            Pair(
                R.drawable.ic_bone,
                "All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet."
            )
        )
    }

    Box {
        Image(
            painter = painterResource(id = dogData.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.radialGradient(
                        listOf(Color.White, dogData.color),
                        Offset(500f, 325f),
                        700f
                    )
                )
                .padding(20.dp)
        )
        Column {
            Spacer(modifier = Modifier.height(180.dp))
            Card(
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Column {
                    Row(
                        modifier = Modifier.padding(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            dogData.name, modifier = Modifier
                                .weight(1f), fontSize = 30.sp,
                            style = MaterialTheme.typography.body2
                        )
                        Image(
                            painterResource(id = dogData.logo),
                            contentDescription = "",
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                    LazyRow(content = {
                        item {
                            Spacer(modifier = Modifier.size(30.dp))
                        }
                        itemsIndexed(
                            dogDetails
                        ) { index, item ->
                            Image(
                                painter = painterResource(id = item.first),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(start = if (index != 0) 20.dp else 0.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        selectedDogDetailIndex.value = index
                                    }
                                    .background(if (selectedDogDetailIndex.value == index) Color.LightGray else Color.Transparent)
                                    .size(70.dp)
                                    .border(
                                        BorderStroke(1.dp, Color.LightGray),
                                        CircleShape
                                    )
                                    .padding(20.dp)
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.size(30.dp))
                        }
                    })
                    Column(modifier = Modifier.padding(30.dp)) {
                        Text(
                            dogDetails[selectedDogDetailIndex.value].second,
                            modifier = Modifier
                                .weight(1f),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.body2,
                            color = Color.Gray
                        )
                        Box(
                            modifier = Modifier
                                .height(45.dp)
                                .fillMaxWidth()
                                .padding(end = 40.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .border(
                                        BorderStroke(1.dp, Color.LightGray),
                                        CircleShape
                                    )
                                    .fillMaxHeight()
                                    .padding(end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(Icons.Filled.ArrowForward, "")
                            }
                            Text(
                                "Meet with Pet", color = Color.White,
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.Black)
                                    .padding(horizontal = 50.dp, vertical = 10.dp)
                                    .fillMaxHeight()
                            )
                        }
                    }
                }
            }
        }
    }
}