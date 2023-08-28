package pro.midev.mec.domain.usecase.account

import android.content.Context
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.DataStatus

class GetFingerInfoUseCase(
    private val context: Context
) {
    operator fun invoke(

    ): Flow<DataStatus<Boolean>> {
        return flow {
            val fingerPrintManager = FingerprintManagerCompat.from(context)
            emit(DataStatus.Success(fingerPrintManager.isHardwareDetected && fingerPrintManager.hasEnrolledFingerprints()))
        }
    }
}
