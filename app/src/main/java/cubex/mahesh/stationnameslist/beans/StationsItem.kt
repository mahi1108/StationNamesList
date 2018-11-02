package cubex.mahesh.stationnameslist.beans

import com.google.gson.annotations.SerializedName

data class StationsItem(@SerializedName("code")
                        val code: String = "",
                        @SerializedName("lng")
                        val lng: Double = 0.0,
                        @SerializedName("name")
                        val name: String = "",
                        @SerializedName("lat")
                        val lat: Double = 0.0)