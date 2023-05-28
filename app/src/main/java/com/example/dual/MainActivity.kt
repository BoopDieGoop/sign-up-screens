@file:OptIn(ExperimentalMaterial3Api::class)
@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection"
)

package com.example.dual

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dual.ui.theme.DualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DualTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaff()
                }
            }
        }
    }
}

enum class SignUps {
    Google,
    Instagram
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Scaff() {
    val navController = rememberNavController()
    Scaffold(topBar = { Navbar(navController) }) { paddings ->

        NavHost(navController = navController, startDestination = SignUps.Google.name) {
            composable(route = SignUps.Google.name) {
                GBody(context = LocalContext.current, pads = paddings)
            }
            composable(route = SignUps.Instagram.name) {
                IBody(context = LocalContext.current, pads = paddings)
            }
        }
    }
}

@Composable
fun Navbar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Sign Up") },
        modifier = Modifier.statusBarsPadding(),
        actions = {
            IconButton(onClick = {
                navController.popBackStack(SignUps.Google.name, inclusive = false)
            }) {
                Icon(painter = painterResource(id = R.drawable.arrow_back), contentDescription = "")
            }
            IconButton(onClick = {
                navController.navigate(route = SignUps.Instagram.name)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.switch_account),
                    contentDescription = ""
                )
            }
        })
}

@Composable
fun GBody(context: Context, pads: PaddingValues) {
    var fng by remember {
        mutableStateOf("")
    }
    var lng by remember {
        mutableStateOf("")
    }
    var usng by remember {
        mutableStateOf("")
    }
    var pasg by remember {
        mutableStateOf("")
    }
    var pscg by remember {
        mutableStateOf("")
    }
    var vis by remember {
        mutableStateOf(false)
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), modifier = Modifier
            .padding(pads)
            .fillMaxSize()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (im, tx1, fn, ln, usr, usb, alt, pss, pcn, psb, shw, sig, nex) = createRefs()

            Image(painter = painterResource(id = R.drawable.gg_logo),
                contentDescription = "Google logo",
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(im) {
                        start.linkTo(parent.start, margin = 25.dp)
                        top.linkTo(parent.top)
                    }
            )

            Text(text = "Create your Google Account",
                fontSize = 25.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(tx1) {
                    start.linkTo(parent.start, margin = 25.dp)
                    top.linkTo(im.bottom, margin = 5.dp)
                })

            OutlinedTextField(value = fng, onValueChange = { fng = it },
                placeholder = { Text("First name") },
                singleLine = true,
                modifier = Modifier
                    .width(145.dp)
                    .constrainAs(fn) {
                        top.linkTo(tx1.bottom, margin = 35.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    })

            OutlinedTextField(value = lng, onValueChange = { lng = it },
                placeholder = { Text("Last name") },
                singleLine = true,
                modifier = Modifier
                    .width(145.dp)
                    .constrainAs(ln) {
                        top.linkTo(tx1.bottom, margin = 35.dp)
                        start.linkTo(fn.end, margin = 10.dp)
                    })

            OutlinedTextField(value = usng, onValueChange = { usng = it },
                placeholder = { Text("Username") },
                trailingIcon = { Text(text = "@gmail.com   ") },
                singleLine = true,
                modifier = Modifier
                    .width(300.dp)
                    .constrainAs(usr) {
                        top.linkTo(fn.bottom, margin = 30.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    })

            Text(text = "You can use letter, numbers & periods",
                color = colorResource(id = R.color.help_grey),
                fontSize = 13.sp,
                modifier = Modifier
                    .constrainAs(usb) {
                        start.linkTo(parent.start, margin = 35.dp)
                        top.linkTo(usr.bottom, margin = 2.dp)
                    }
            )

            TextButton(onClick = {
                Toast.makeText(context, "Using current Email", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .constrainAs(alt) {
                    top.linkTo(usb.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 15.dp)
                }) {
                Text(
                    text = "Use my current email address instead",
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.link_blue)
                )
            }

            OutlinedTextField(value = pasg, onValueChange = { pasg = it },
                placeholder = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (vis) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .width(145.dp)
                    .constrainAs(pss) {
                        top.linkTo(alt.bottom, margin = 25.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    })

            OutlinedTextField(value = pscg, onValueChange = { pscg = it },
                placeholder = { Text("Confirm") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (vis) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .width(145.dp)
                    .constrainAs(pcn) {
                        top.linkTo(alt.bottom, margin = 25.dp)
                        start.linkTo(fn.end, margin = 10.dp)
                    })

            Text(text = "Use 8 or more characters with a mix of letters,\nnumbers & symbols",
                color = colorResource(id = R.color.help_grey),
                fontSize = 13.sp,
                modifier = Modifier
                    .constrainAs(psb) {
                        start.linkTo(parent.start, margin = 35.dp)
                        top.linkTo(pss.bottom, margin = 2.dp)
                    }
            )

            Row(modifier = Modifier
                .constrainAs(shw) {
                    top.linkTo(psb.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 25.dp)
                }) {
                Checkbox(checked = vis, onCheckedChange = { vis = it })
                Text(text = "Show password", modifier = Modifier.padding(15.dp))
            }

            TextButton(onClick = { /*TODO*/ }, modifier = Modifier
                .constrainAs(sig) {
                    top.linkTo(shw.bottom, margin = 50.dp)
                    start.linkTo(parent.start, margin = 15.dp)
                }) {
                Text(
                    text = "Sign in instead", fontSize = 15.sp,
                    color = colorResource(id = R.color.link_blue)
                )
            }

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.link_blue)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .constrainAs(nex) {
                        top.linkTo(shw.bottom, margin = 50.dp)
                        start.linkTo(sig.end, margin = 120.dp)
                    }) {
                Text(text = "Next", color = Color.White)
            }
        }
    }
}

@Composable
fun IBody(context: Context, pads: PaddingValues) {
    var fng by remember {
        mutableStateOf("")
    }
    var lng by remember {
        mutableStateOf("")
    }
    var usng by remember {
        mutableStateOf("")
    }
    var pasg by remember {
        mutableStateOf("")
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), modifier = Modifier
            .padding(pads)
            .fillMaxSize()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (im, tx1, fb, tx2, mbml, ln, usr, pss, psb, sig, nex) = createRefs()

            Image(painter = painterResource(id = R.drawable.ig_text),
                contentDescription = "Instagram logo",
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(im) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )

            Text(text = "Sign up to see photos and videos from your friends",
                fontSize = 15.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .constrainAs(tx1) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(im.bottom, margin = 5.dp)
                    })

            Button(onClick = {
                Toast.makeText(context, "Logging in via facebook", Toast.LENGTH_SHORT).show()
            },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.fb_blue)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .constrainAs(fb) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(tx1.bottom, margin = 15.dp)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.fb_logo),
                    contentDescription = "",
                    Modifier.size(20.dp)
                )
                Text(text = "   Log in with facebook")
            }

            Text(text = "OR",
                fontSize = 10.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .constrainAs(tx2) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(fb.bottom)
                    })

            OutlinedTextField(value = fng, onValueChange = { fng = it },
                placeholder = { Text("Mobile number or email address") },
                singleLine = true,
                modifier = Modifier
                    .constrainAs(mbml) {
                        top.linkTo(tx2.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            OutlinedTextField(value = lng, onValueChange = { lng = it },
                placeholder = { Text("Full name") },
                singleLine = true,
                modifier = Modifier
                    .constrainAs(ln) {
                        top.linkTo(mbml.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            OutlinedTextField(value = usng, onValueChange = { usng = it },
                placeholder = { Text("Username") },
                singleLine = true,
                modifier = Modifier
                    .constrainAs(usr) {
                        top.linkTo(ln.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            OutlinedTextField(value = pasg, onValueChange = { pasg = it },
                placeholder = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .constrainAs(pss) {
                        top.linkTo(usr.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Text(text = "People who use pour service may have uploaded your contact information to instagram. Learn more\n\nBy signing up you agree to our Terms, Privacy Policy and Cookies Policy.",
                color = Color.Gray,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(psb) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(pss.bottom)
                    }
            )

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.fb_blue)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .width(300.dp)
                    .constrainAs(nex) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(psb.bottom)
                    }) {
                Text(text = "Sign Up", color = Color.White)
            }

            TextButton(onClick = { /*TODO*/ }, modifier = Modifier
                .constrainAs(sig) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(nex.bottom, margin = 30.dp)
                }) {
                Text(
                    text = "Have an account? Log in", fontSize = 15.sp,
                    color = colorResource(id = R.color.fb_blue)
                )
            }
        }
    }
}