package uz.bdm.podcast

import android.app.Application
import com.orhanobut.hawk.Hawk

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()
    }
}