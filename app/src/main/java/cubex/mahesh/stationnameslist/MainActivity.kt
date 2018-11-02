package cubex.mahesh.stationnameslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import cubex.mahesh.stationnameslist.beans.StationNamesBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStations.setOnClickListener {

            var r= Retrofit.Builder().
                     addConverterFactory(GsonConverterFactory.create()).
                     baseUrl("https://api.railwayapi.com/").
                     build()

            var api = r.create(StationNamesAPI::class.java)
            var call = api.getStationNames(et1.text.toString())

            call.enqueue(object : Callback<StationNamesBean> {
                override fun onFailure(call: Call<StationNamesBean>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<StationNamesBean>, response: Response<StationNamesBean>) {

                    var bean = response.body()
                    var list = bean!!.stations
                    var temp_list = mutableListOf<String>()
                    for(st in list!!)
                    {
                        temp_list.add(st.name)
                    }

        var adapter = ArrayAdapter<String>(this@MainActivity,
                           android.R.layout.simple_list_item_single_choice,
                            temp_list)
        lview.adapter = adapter
                }
            })

        }

    }
}
