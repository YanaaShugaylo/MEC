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



    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_PIN = "user_pin"
    }

}