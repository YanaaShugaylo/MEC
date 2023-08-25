package pro.midev.mec.presentation.ui.general.profile

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen

class ProfileScreen : AndroidScreen(){

    @Composable
    override fun Content() {
        ProfileScreen(viewModel = ProfileViewModel())
    }
}

@Composable
private fun ProfileScreen(viewModel: ProfileViewModel){}
