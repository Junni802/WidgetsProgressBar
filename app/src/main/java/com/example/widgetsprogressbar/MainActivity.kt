package com.example.widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.widgetsprogressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
	val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		thread (start=true) {
			Thread.sleep(3000)
			runOnUiThread {
				showProgress(false)
			}
			// 메인 쓰레드 : 화면에 디자인을 해주는 역할
		}
	}
	fun showProgress(show : Boolean){
		if(show){
			binding.progressLayout.visibility = View.VISIBLE
		}else{
			binding.progressLayout.visibility = View.GONE
		}
		/*
		visibility 속성값
		VISIBLE : 보이는 상태
		INVISIBLE : 안보이는 상태 - 안보여도 공간을 차지하는 상태
		GONE : 안보이는 상태 - 안보이고 공간도 차지하지 않는 상태
		 */
	}
}