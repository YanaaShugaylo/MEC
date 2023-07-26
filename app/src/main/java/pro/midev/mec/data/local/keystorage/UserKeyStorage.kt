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


    companion object {
        const val USER_TOKEN = "user_token"
    }

}