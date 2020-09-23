package co.id.egiwibowo.imovie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("vote_count")
    val voteCount: Int,

    @field:SerializedName("vote_average")
    val voteAverage: Float,

    @field:SerializedName("release_date")
    val releaseDate: String
)