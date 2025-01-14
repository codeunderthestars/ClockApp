package com.clocxy.clocxyone.presentation.ComposableScreens

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.clocxy.clocxyone.R
import com.clocxy.clocxyone.domain.Functions.formatString
import  com.clocxy.clocxyone.presentation.ViewModels.MainScreenViewModel


@Composable
fun HomePage(
    modifier: Modifier ,
    context: Context ,
    navController: NavHostController ,
    viewModel: MainScreenViewModel,
    cardContainerColor: Color ,
    backgroundColor: Color ,
    fontColor: Color ,
    secondaryFontColor: Color
) {


    // Defining text variables
    val dateText =
        viewModel.date.collectAsState().value.toString()                        //"09 November 2024"
    val dayText = viewModel.day.collectAsState().value.toString()                         //"Sunday"
    val timeHourText = formatString( viewModel.hour.collectAsState().value.toString() )                   //"55"
    val timeMinuteText = formatString( viewModel.minute.collectAsState().value.toString()  )               //"55"
    val timeSecondText = formatString( viewModel.second.collectAsState().value.toString()      )           //"55"

    val temperatureText =
        viewModel.temperature.collectAsState().value.toString()           //"55` C"
    val feelsLikeText =
        "${viewModel.temperatureFeelsLike.collectAsState().value.toString()}"
    val rainText = viewModel.rainChance.collectAsState().value.toString()                   //"90 %"
    val weatherConditionText =
        viewModel.weatherType.collectAsState().value.toString()      //"Chilly"
    val zenModeText = "Go Zen Mode"


    // saving the initial screen in shared preferences
    val sharedPreferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("page", "home").apply()


    val configuration = LocalConfiguration.current
    val isPortrait =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(.4f))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.9f), colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor,
                        disabledContainerColor = backgroundColor,
                        disabledContentColor = backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = dateText, fontSize = 31.sp, color = fontColor
                            )
                            Text(
                                text = dayText, fontSize = 22.sp, color = fontColor
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(.4f))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.6f), colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor,
                        disabledContainerColor = backgroundColor,
                        disabledContentColor = backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.weight(.2f))
                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeHourText,
                                fontSize = 31.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(.3f))
                            Text(
                                modifier = Modifier.weight(.5f), text = ":", fontSize = 31.sp, color = fontColor
                            )

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeMinuteText,
                                fontSize = 31.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(.3f))
                            Text(
                                modifier = Modifier.weight(.5f), text = ":", fontSize = 31.sp, color = fontColor
                            )

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeSecondText,
                                fontSize = 31.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(.2f))
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(.4f))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(1f), colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor,
                        disabledContainerColor = backgroundColor,
                        disabledContentColor =backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = temperatureText, fontSize = 31.sp, color = fontColor
                                    )
                                }

                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = feelsLikeText,
                                    fontSize = 20.sp, color = fontColor
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_water_drop_24),
                                        contentDescription = "water",
                                        tint = fontColor
                                    )
                                    Spacer(modifier = Modifier.size(10.dp))
                                    Text(
                                        text = rainText, fontSize = 24.sp, color = fontColor
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Spacer(modifier = Modifier.size(15.dp))
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        text = weatherConditionText,
                                        fontSize = 20.sp, color = fontColor
                                    )

                                }

                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(.3f))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.5f)
                        .clickable {
                            // go to zen mode
                            navController.navigate("zenMode")
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = zenModeText, fontSize = 24.sp, color = fontColor
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(.3f))
            }
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(.2f))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.6f), colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = dateText, fontSize = 36.sp, color = fontColor
                            )
                            Text(
                                text = dayText, fontSize = 34.sp, color = fontColor
                            )
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.6f), colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.weight(1.2f))
                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeHourText,
                                fontSize = 36.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(.3f))
                            Text(
                                modifier = Modifier.weight(.5f), text = ":", fontSize = 34.sp, color = fontColor
                            )

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeMinuteText,
                                fontSize = 36.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(.3f))
                            Text(
                                modifier = Modifier.weight(.5f), text = ":", fontSize = 34.sp, color = fontColor
                            )

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = timeSecondText,
                                fontSize = 36.sp, color = fontColor
                            )
                            Spacer(modifier = Modifier.weight(1.2f))
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.9f), colors = CardDefaults.cardColors(
                        containerColor =cardContainerColor,
                        contentColor = backgroundColor
                    ), shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = temperatureText, fontSize = 33.sp, color = fontColor
                                    )
                                }

                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = feelsLikeText,
                                    fontSize = 28.sp, color = fontColor
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        modifier=Modifier.padding(top = 2.dp),
                                        painter = painterResource(R.drawable.baseline_water_drop_24),
                                        contentDescription = "water",
                                        tint = fontColor
                                    )
                                    Spacer(modifier = Modifier.size(10.dp))
                                    Text(
                                        text = rainText, fontSize = 30.sp, color = fontColor
                                    )
                                }

                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = weatherConditionText,
                                    fontSize = 30.sp, color = fontColor
                                )
                            }
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .weight(.5f)
                        .clickable {
                            // go to zen mode
                            navController.navigate("zenMode")
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = cardContainerColor,
                        contentColor = backgroundColor
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = zenModeText, fontSize = 24.sp, color = fontColor
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(.2f))
            }
        }
    }
}
