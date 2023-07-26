package pro.midev.mec.data.remote.exceptions

import java.io.IOException

class MecRemoteException(val remoteMessage: String) : IOException(remoteMessage) {
}