package br.com.fiap.rotaverde.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.rotaverde.R




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmissaoCarroScreen() {
    var distancia by remember { mutableStateOf("") }
    var porte by remember { mutableStateOf("Pequeno") }
    var combustivel by remember { mutableStateOf("Gasolina") }
    var showResult by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2AA3A1))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 16.dp, shape = RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.carro),
                    contentDescription = "Imagem de um carro verde",
                    modifier = Modifier.size(300.dp)
                )
                Text("Emissão do Carro", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = distancia,
                    onValueChange = { distancia = it },
                    label = { Text("Distância Percorrida em Km") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Ex: 160") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF175275),
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color(0xFF175275)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text("Porte:")
                Row {
                    listOf("Pequeno", "Medio", "Grande").forEach { size ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = porte == size,
                                onClick = { porte = size },
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF175275))
                            )
                            Text(size)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Combustível:")
                Row {
                    listOf("Gasolina", "Etanol", "Diesel").forEach { fuel ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = combustivel == fuel,
                                onClick = { combustivel = fuel },
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF175275))
                            )
                            Text(fuel)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val dist = distancia.toDoubleOrNull() ?: 0.0
                        showResult = calcularEmissaoDeCo2Carro(porte, combustivel, dist)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                    border = BorderStroke(2.dp, Color(0xFF175275))
                ) {
                    Text("Calcular!", color = Color.White, fontSize = 18.sp)
                }

                showResult?.let {
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 60.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC20E)),
                        border = BorderStroke(2.dp, Color.Black)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center, // Centraliza os itens na horizontal
                            verticalAlignment = Alignment.CenterVertically // Alinha os itens na vertical
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.co2),
                                contentDescription = "Ícone de CO2",
                                modifier = Modifier.size(100.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaço entre a imagem e o texto
                            Text(
                                "%.2f Kg".format(it),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }

        Spacer(modifier = Modifier.height(16.dp))

       /* AnimatedVisibility(
            visible = showResult,
            enter = expandVertically() + fadeIn()
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC20E)),
                border = BorderStroke(2.dp, Color.Black)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center, // Centraliza os itens na horizontal
                    verticalAlignment = Alignment.CenterVertically // Alinha os itens na vertical
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.co2),
                        contentDescription = "Ícone de CO2",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Espaço entre a imagem e o texto
                    Text(
                        text = "1600 Kg",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }*/
    }

//Função para calcular o Co2
fun calcularEmissaoDeCo2Carro(porte: String, combustivel: String, distancia: Double): Double {
    val fatorEmissao = mapOf(
        "Gasolina" to mapOf("Pequeno" to 0.12, "Medio" to 0.14, "Grande" to 0.18),
        "Etanol" to mapOf("Pequeno" to 0.08,"Medio" to 0.10, "Grande" to 0.12),
        "Diesel" to mapOf("Pequeno" to 0.15, "Medio" to 0.17, "Grande" to 0.22)
    )
    return fatorEmissao[combustivel]?.get(porte)?.times(distancia)?:0.0
}




@Preview
@Composable
private fun carropreview() {
    EmissaoCarroScreen()
}


