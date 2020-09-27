package com.example.pillapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        val a: String = "Lilly3238 18mg"
        tv1.text = "$a"

        if(intent.hasExtra("disablenum")){
            if(intent.getIntExtra("disablenum",0)==1){
                button1.isEnabled = false
                button1.text = "1번 보관함(가득참)"
            }
            if(intent.getIntExtra("disablenum",0)==2){
                button2.isEnabled = false
                button2.text = "2번 보관함(가득참)"
            }
            if(intent.getIntExtra("disablenum",0)==4){
                button4.isEnabled = false
                button4.text = "4번 보관함(가득참)"
            }
            tv1.text = "알약 추가 보관을 위하여"
            tv2.text = "기기에서 촬영 버튼을 눌러"
            tv3.text = "알약을 인식해 주세요"
        }
        if (intent.hasExtra("a")) {
            tv1.text = intent.getStringExtra("a")
        }
        button3.isEnabled = false
        button3.text = "3번 보관함(가득참)"

        button1.setOnClickListener {
            val extra = 1
            val intent = Intent(this, SetalarmActivity::class.java).apply {
                putExtra("disablenum", extra)
            }
            startActivity(intent)
        }
        button2.setOnClickListener {
            val extra = 2
            val intent = Intent(this, SetalarmActivity::class.java).apply {
                putExtra("disablenum", extra)
            }
            startActivity(intent)
        }
        button4.setOnClickListener {
            val extra = 4
            val intent = Intent(this, SetalarmActivity::class.java).apply {
                putExtra("disablenum", extra)
            }
            startActivity(intent)
        }

    }
}
