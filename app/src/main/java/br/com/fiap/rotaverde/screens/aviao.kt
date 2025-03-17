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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.rotaverde.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmissaoAviaoScreen() {
    var distancia by remember { mutableStateOf("") }
    var combustivel by remember { mutableStateOf("Turbina") }
    var showResult by remember { mutableStateOf<Double?>(null) }
    var showError by remember { mutableStateOf(false) }

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
                    painter = painterResource(id = R.drawable.aviao),
                    contentDescription = "Imagem de um avião verde",
                    modifier = Modifier.size(300.dp)
                )
                Text("Emissão do avião", fontSize = 20.sp, fontWeight = FontWeight.Bold)
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


                Text("Avião:")
                Row {
                    listOf("Turbina", "TurboHélice").forEach { fuel ->
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
                        val dist = distancia.toDoubleOrNull() ?: -1.0
                        if (dist <= 0) {
                            showError = true
                            showResult = null
                        } else {
                            showError = false
                            showResult = calcularCo2Aviao(dist, combustivel)
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF38A3A3)),
                    border = BorderStroke(2.dp, Color(0xFF175275))
                ) {
                    Text("Calcular!", color = Color.White, fontSize = 18.sp)
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        if (showError) {
            Text(
                text = "!Coloque um valor válido de distância",
                color = Color.Red,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        AnimatedVisibility(
            visible = showResult != null,
            enter = expandVertically() + fadeIn(),
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 30.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC20E)),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.co2),
                        contentDescription = "Ícone de CO2",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "%.2f Kg".format(showResult),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

fun calcularCo2Aviao(distancia: Double, tipoAviao: String): Double {
    val fatorEmissao = when(tipoAviao){
        "Turbina" -> 3.15
        "TurboHélice" -> 2.5
        else ->0.0
    }

    val consumoPorKm = when(tipoAviao){
        "Turbina" -> 4.0
        "TurboHélice" -> 2.5
        else ->0.0
    }

    return distancia * consumoPorKm * fatorEmissao
}




@Preview
@Composable
private fun aviaopreview() {
    EmissaoAviaoScreen()
}


