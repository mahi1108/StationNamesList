package cubex.mahesh.stationnameslist.beans

import com.google.gson.annotations.SerializedName

data class StationNamesBean(@SerializedName("response_code")
                            val responseCode: Int = 0,
                            @SerializedName("stations")
                            val stations: List<StationsItem>?,
                            @SerializedName("debit")
                            val debit: Int = 0)