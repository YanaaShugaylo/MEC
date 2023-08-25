package pro.midev.mec.presentation.ui.general.cabinet

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.model.human.AccountHuman
import pro.midev.mec.presentation.model.human.RequestHuman

@Immutable
data class CabinetState(
    val state: String,
    val requestHumanList: List<RequestHuman>,
    val accountHuman: AccountHuman,
    )
