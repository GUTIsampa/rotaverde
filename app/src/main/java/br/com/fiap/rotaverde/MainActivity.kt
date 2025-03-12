package br.com.fiap.rotaverde

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inicial()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicial() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF38A3A3) // Cor de fundo
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo SOS Amazonia",
                    modifier = Modifier.size(300.dp)
                )
            }


            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 50.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),

                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color(0xFF175275)),

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp) // Espaçamento entre as Rows
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Calcule a quantidade de CO2 emitido de acordo com a distância percorrida e com o meio de transporte usado.",
                                fontSize = 26.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Button(
                                onClick = { /* Ação do botão */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color(0xFF38A3A3)
                                ),
                                border = BorderStroke(2.dp, Color(0xFF175275))
                            ) {
                                Text(
                                    text = "Calcular!",
                                    fontSize = 28.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    color = Color.White
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.medidor),
                                contentDescription = "medidor",
                                modifier = Modifier.size(200.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

