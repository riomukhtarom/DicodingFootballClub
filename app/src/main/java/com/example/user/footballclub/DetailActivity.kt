package com.example.user.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        DetailActivityUI().setContentView(this)
    }

    class DetailActivityUI: AnkoComponent<DetailActivity>{
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui){
            verticalLayout {
                padding = dip(16)

            }
        }

    }
}
