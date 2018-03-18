package uz.wiut.lineup.lineup.ui.sign_up_in

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import uz.wiut.lineup.lineup.R
import android.hardware.usb.UsbDevice.getDeviceId
import android.support.v4.app.ActivityCompat
import android.hardware.usb.UsbDevice.getDeviceId
import android.telephony.TelephonyManager
import android.util.Log
import uz.wiut.lineup.lineup.utils.Constants


class SplashScreen : AppCompatActivity(){
    var wantPermission = Manifest.permission.READ_PHONE_STATE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}
