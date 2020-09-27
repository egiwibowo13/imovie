package co.id.egiwibowo.imovie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
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
    val releaseDate: String,

    @field:SerializedName("runtime")
    val runtime: Int,

    @field:SerializedName("genres")
    val genres: List<Genre>,

    @field:SerializedName("credits")
    val credits: Credits,

    @field:SerializedName("original_title")
    val originalTitle: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("budget")
    val budget: Int,

    @field:SerializedName("revenue")
    val revenue: Int,

    @field:SerializedName("recommendations")
    val recommendations: RecommendationListMovie

) {
    data class Genre(
        @field:SerializedName("id")
        val genreId: Int,

        @field:SerializedName("name")
        val name: String
    )

    data class Credits(
        @field:SerializedName("cast")
        val cast: List<Cast>
    )

    data class Cast(
        @field:SerializedName("cast_id")
        val castId: Int,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("character")
        val character: String,

        @field:SerializedName("profile_path")
        val profilePath: String?
    )

    data class RecommendationListMovie(
        @field:SerializedName("results")
        val results: List<RecommendationMovie>
    )

    data class RecommendationMovie(
        @field:SerializedName("id")
        val movieId: Int,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("vote_average")
        val voteAverage: Float,

        @field:SerializedName("poster_path")
        val posterPath: String
    )
}