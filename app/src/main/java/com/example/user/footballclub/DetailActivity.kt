package com.example.user.footballclub

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName: String = ""
    private var clubDetail: String = ""
    private var clubLogo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        val nameList = resources.getStringArray(R.array.clubname)
        val imageList = resources.obtainTypedArray(R.array.clublogo)
        val detailList = resources.getStringArray(R.array.clubdetail)

        val intent = getIntent()
        clubName = intent.getStringExtra("name")
        Log.e("DetailActivity", clubName)

        for(index in nameList.indices){
            if (nameList[index].toString() == clubName){
                clubLogo = imageList.getResourceId(index, 0)
                clubDetail = detailList[index].toString()
            }
        }

        DetailActivityUI().setContentView(this)
    }

    inner class DetailActivityUI: AnkoComponent<DetailActivity>{

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui){


            verticalLayout {
                padding = dip(16)

                imageView(clubLogo).lparams{
                    height = dip(70)
                    width = dip(70)
                    margin = dip(10)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView(clubName).lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
                textView(clubDetail).lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }
            }
        }
    }
}
