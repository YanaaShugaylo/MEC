package pro.midev.mec.presentation.ui.general.cabinet

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen

class CabinetScreen : AndroidScreen(){

    @Composable
    override fun Content() {
        CabinetScreen(viewModel = CabinetViewModel())
    }
}

@Composable
private fun CabinetScreen(viewModel: CabinetViewModel){}
