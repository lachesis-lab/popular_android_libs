package ru.gb.gb_popular_libs.lession1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.gb.gb_popular_libs.lession1.R.layout.activity_main

class MainActivity : AppCompatActivity(activity_main), Presenter.IView {

    private val presenter by lazy { Presenter(view = this, model = Model) }

    private val counter1: Button by lazy { findViewById(R.id.btn_counter1) }
    private val counter2: Button by lazy { findViewById(R.id.btn_counter2) }
    private val counter3: Button by lazy { findViewById(R.id.btn_counter3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counter1.setOnClickListener {
            showCounter(0)
        }

        counter2.setOnClickListener {
            showCounter(1)
        }

        counter3.setOnClickListener {
            showCounter(2)
        }
        presenter.initViews()
    }

    override fun showCounter(id: Int) {
        val counter = presenter.counterNext(id).toString()
        when (id) {
            0 -> counter1.text = counter
            1 -> counter2.text = counter
            2 -> counter3.text = counter
            else -> throw Throwable("incorrect index")
        }

    }

}
