package com.example.pillapp
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        val a:String = "Lilly3238 18mg"
        val b:Int = 2
        val c:Int = 6
        val d:Int = 0
        val e:Int = 2

        tv1.text = "$a $b 개 복용"
        tv2.text = "복용 예정 시각 : $c 시 $d 분"
        tv3.text = "알약 보관 위치 : $e 번 보관함"
        button2.setOnClickListener {
            createNotificationChannel(a, b, c, d, e)
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
