package co.id.egiwibowo.imovie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(

    @field:SerializedName("status_code")
    val statusCode: Int,

    @field:SerializedName("status_message")
    val statusMessage: String,

    @field:SerializedName("results")
    val movies: List<MovieResponse>
)