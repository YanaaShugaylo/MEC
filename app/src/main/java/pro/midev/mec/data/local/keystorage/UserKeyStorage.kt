package pro.midev.mec.data.local.keystorage

import com.tencent.mmkv.MMKV

class UserKeyStorage(private val storage: MMKV) {

    fun saveToken(token: String) {
        storage.encode(USER_TOKEN, token)
    }

    fun getToken(): String? {
        return storage.decodeString(USER_TOKEN)
    }

    fun removeToken() {
        return storage.removeValueForKey(USER_TOKEN)
    }

    fun savePin(pin: String) {
        storage.encode(USER_PIN, pin)
    }

    fun getPin(): String? {
        return storage.decodeString(USER_PIN)
    }

    fun removePin() {
        storage.removeValueForKey(USER_PIN)
    }

    fun saveIsTouchMode(isTouchMode: Boolean) { // функции для отпечатка
        storage.encode(USE_FINGER_PRINT, isTouchMode)
    }

    fun deleteIsTouchMode() {
        storage.removeValueForKey(USE_FINGER_PRINT)
    }

    fun getIsTouchMode(): Boolean? {
        return storage.decodeBool(USE_FINGER_PRINT)
    }


    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_PIN = "user_pin"
        const val USE_FINGER_PRINT = "use_finger_print"
    }

}