package cubex.mahesh.stationnameslist

import cubex.mahesh.stationnameslist.beans.StationNamesBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StationNamesAPI {

    @GET("v2/suggest-station/name/{sname}/apikey/3us4nq7cyl/")
    fun getStationNames(@Path("sname") name:String ) : Call<StationNamesBean>
}