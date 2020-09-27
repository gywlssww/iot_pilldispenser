package com.example.pillapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_setalarm.*
import java.text.SimpleDateFormat
import java.util.*

class SetalarmActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setalarm)

        var disnum  = 2
        if(intent.hasExtra("disablenum")) {
            val disablenum: Int = intent.getIntExtra("disablenum", 0)
            disnum = disablenum
        }
        pickTimeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                timeTv1.text = SimpleDateFormat("HH:mm").format(cal.time) + ("에 알람이")
                timeTv2.text = "울려요"
                val c = cal.get(Calendar.HOUR_OF_DAY)
                val d = cal.get(Calendar.MINUTE)
                createNotificationChannel("Lilly3238 18mg",1,c, d, disnum )
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        back.setOnClickListener {
            val intent = Intent(this, SelectActivity::class.java).apply {
                putExtra("disablenum",disnum)
            }
            startActivity(intent)
        }

    }

    private fun createNotificationChannel(a:String, b:Int, c:Int, d:Int, e:Int) { //알람 팝업
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "알림"
            val descriptionText = "알림 내용"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_1", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        var builder = NotificationCompat.Builder(this, "channel_1")
            .setSmallIcon(R.drawable.alarm)
            .setContentTitle("$a $b 개 복용")
            .setContentText("복용 예정 시각 : $c 시 $d 분 \n 알약 보관 위치 : $e 번 보관함")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }
    }
}
