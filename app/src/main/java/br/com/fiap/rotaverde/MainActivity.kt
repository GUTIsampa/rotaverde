package br.com.fiap.rotaverde

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.rotaverde.screens.EmissaoAviaoScreen
import br.com.fiap.rotaverde.screens.EmissaoCarroScreen
import br.com.fiap.rotaverde.screens.EmissaoMotoScreen
import br.com.fiap.rotaverde.screens.EmissaotremScreen
import br.com.fiap.rotaverde.screens.Menu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}

// Configuração da navegação
@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "Inicial") {
        composable("inicial") { Inicial(navController) }
        composable("Menu") { Menu (navController) }
        composable("emissao_carro") { EmissaoCarroScreen() }
        composable("emissao_moto") { EmissaoMotoScreen() }
        composable("emissao_aviao") { EmissaoAviaoScreen() }
        composable("emissao_trem") { EmissaotremScreen() }
        // Adicione outras telas conforme necessário*/
    }
}

@Composable
fun Inicial(navController: NavController) {
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
                        .fillMaxSize()
                        .shadow(elevation = 16.dp, shape = RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color(0xFF175275)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))

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
                                onClick = { navController.navigate("Menu") }, // Navegação para a próxima tela
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color(0xFF38A3A3)
                                ),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(2.dp, Color(0xFF175275))
                            ) {
                                Text(
                                    text = "Começar!",
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

@Preview
@Composable
fun InicialPreview() {
    Inicial(navController = rememberNavController())
}
