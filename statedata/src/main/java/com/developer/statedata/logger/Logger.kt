package com.developer.statedata.logger

import android.Manifest.permission
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

class Logger {

    lateinit var activity: Activity

    fun init(activity: Activity) {
        this.activity = activity;
    }

    fun write(tag: String, s: String) {
        try {
            CheckingPermissionIsEnabledOrNot(activity)
            var backupPath = Environment.getExternalStorageDirectory()
            backupPath = File(backupPath.path + "/TipLog")
            if (!backupPath.exists()) {
                backupPath.mkdirs()
            }
            val fos: FileOutputStream
            val file = File(backupPath.path + "/Log.txt")
            fos = FileOutputStream(file, true)
            fos.write("$tag == $s\n".toByteArray())
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun CheckingPermissionIsEnabledOrNot(activity: Activity) {
        activity.let {
            val first =
                ContextCompat.checkSelfPermission(activity, permission.WRITE_EXTERNAL_STORAGE)
            val second =
                ContextCompat.checkSelfPermission(activity, permission.READ_EXTERNAL_STORAGE)
            if (!(first == PackageManager.PERMISSION_GRANTED && second == PackageManager.PERMISSION_GRANTED)) {
                ActivityCompat.requestPermissions(activity, arrayOf(
                    permission.READ_EXTERNAL_STORAGE,
                    permission.WRITE_EXTERNAL_STORAGE), 100)
            }
        }

    }


}