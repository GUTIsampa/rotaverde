package br.com.fiap.rotaverde.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.rotaverde.R
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.rotaverde.Inicial




@Composable
fun Menu(navController: NavController) {
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
                        .fillMaxWidth()
                        .shadow(elevation = 16.dp, shape = RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color(0xFF175275)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Escolha o Meio de Transporte",
                                fontSize = 32.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 50.dp, vertical = 24.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = { navController.navigate("emissao_carro") },
                                    modifier = Modifier.size(100.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                                    border = BorderStroke(2.dp, Color(0xFF175275)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.car),
                                        contentDescription = "Imagem do Carro",
                                        modifier = Modifier.size(48.dp)
                                    )
                                }

                                Button(
                                    onClick = { navController.navigate("emissao_aviao") },
                                    modifier = Modifier.size(100.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                                    border = BorderStroke(2.dp, Color(0xFF175275)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.plane),
                                        contentDescription = "Imagem do Avião",
                                        modifier = Modifier.size(48.dp)
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = { navController.navigate("emissao_moto") },
                                    modifier = Modifier.size(100.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                                    border = BorderStroke(2.dp, Color(0xFF175275)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.motorbike),
                                        contentDescription = "Imagem de Moto",
                                        modifier = Modifier.size(48.dp)
                                    )
                                }

                                Button(
                                    onClick = { navController.navigate("emissao_trem") },
                                    modifier = Modifier.size(100.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                                    border = BorderStroke(2.dp, Color(0xFF175275)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.train),
                                        contentDescription = "Imagem de Trem",
                                        modifier = Modifier.size(48.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun menupreview() {
    Menu(
        navController = TODO()
    )
}

