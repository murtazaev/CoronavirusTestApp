package ru.coronavirus.testapp.ui.utils

import android.content.Context
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import okio.IOException
import retrofit2.HttpException
import ru.coronavirus.testapp.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkErrorsHandler @Inject constructor(private val context: Context) {

    fun handleError(t: Throwable): Throwable {
        val errorMessage = when (t) {
            is SocketTimeoutException -> context.getString(R.string.timeout_error)
            is UnknownHostException -> context.getString(R.string.no_connection_error)
            is ConnectException -> context.getString(R.string.server_not_respond_error)
            is IOException -> t.message
            else -> context.getString(R.string.no_connection_error)
        }
        return Throwable(errorMessage)
    }
}