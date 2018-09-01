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

        val intent = getIntent()
        clubName = intent.getStringExtra("name")
        Log.e("DetailActivity", clubName)

        when (clubName) {
            "Manchester United" -> {
                clubLogo = R.drawable.img_mu
                clubDetail = "Manchester United Football Club, " +
                        "commonly known as Man. United or simply United," +
                        " is a professional football club based in Old Trafford," +
                        " Greater Manchester, England, that competes in the Premier League," +
                        " the top flight of English football. Nicknamed \"the Red Devils\"," +
                        " the club was founded as Newton Heath LYR Football Club in 1878, " +
                        "changed its name to Manchester United in 1902 and moved to " +
                        "its current stadium, Old Trafford, in 1910."
            }

            "Manchester City" -> {
                clubLogo = R.drawable.img_city
                clubDetail = "Manchester City Football Club, " +
                        "also known simply as City or the Cityzens, " +
                        "is a football club based in east Manchester, England. " +
                        "Founded in 1880 as St. Mark's (West Gorton), " +
                        "it became Ardwick Association Football Club in 1887 " +
                        "and Manchester City in 1894. " +
                        "The club's home ground is the City of Manchester Stadium " +
                        "in east Manchester, to which it moved in 2003, " +
                        "having played at Maine Road since 1923."
            }
            "Arsenal" -> {
                clubLogo = R.drawable.img_arsenal
                clubDetail = "Arsenal Football Club is a professional football club " +
                        "based in Islington, London, England, " +
                        "that plays in the Premier League, " +
                        "the top flight of English football. " +
                        "The club has won 13 League titles, a record 13 FA Cups, " +
                        "two League Cups, the League Centenary Trophy, " +
                        "15 FA Community Shields, one UEFA Cup Winners' " +
                        "Cup and one Inter-Cities Fairs Cup. "
            }
            "Barcelona" -> {
                clubLogo = R.drawable.img_barca
                clubDetail = "Futbol Club Barcelona known simply as Barça, " +
                        "is a professional football club based in Barcelona, Catalonia, Spain."
            }
            "Real Madrid" -> {
                clubLogo = R.drawable.img_madrid
                clubDetail = "Real Madrid Club de Fútbol commonly known as Real Madrid, " +
                        "is a professional football club based in Madrid, Spain." +
                        "Founded on 6 March 1902 as the Madrid Football Club, " +
                        "the club has traditionally worn a white home kit since inception."
            }
            "AC Milan" -> {
                clubLogo = R.drawable.img_acm
                clubDetail = "Associazione Calcio Milan, commonly referred to as A.C. Milan " +
                        "or simply Milan, is a professional football club in Milan, Italy, " +
                        "founded in 1899.[5][6] The club has spent its entire history, " +
                        "with the exception of the 1980–81 and 1982–83 seasons, " +
                        "in the top flight of Italian football, known as Serie A since 1929–30."
            }
            "Bayern Munich" -> {
                clubLogo = R.drawable.img_bayern
                clubDetail = "Bayern München FCB, Bayern Munich, or FC Bayern, " +
                        "is a German sports club based in Munich, Bavaria (Bayern). " +
                        "It is best known for its professional football team, " +
                        "which plays in the Bundesliga, the top tier of the " +
                        "German football league system, and is the most successful " +
                        "club in German football history, having won a record 28 national titles " +
                        "and 18 national cups."
            }
            "Chelsea" -> {
                clubLogo = R.drawable.img_chelsea
                clubDetail = "Chelsea Football Club is a professional football club in London, England, " +
                        "that competes in the Premier League. Founded in 1905, the club's " +
                        "home ground since then has been Stamford Bridge." +
                        "Chelsea won the First Division title in 1955, " +
                        "followed by various cup competitions between 1965 and 1971."
            }
        }

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

        //DetailActivityUI().setContentView(this)


    }

    class DetailActivityUI: AnkoComponent<DetailActivity>{

        private var clubName: String = ""

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui){
            val intent = Intent()
            clubName = intent.getStringExtra("name")

            verticalLayout {
                padding = dip(16)

                imageView(R.drawable.img_mu).lparams{
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
                textView().lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }
            }



        }

    }
}
