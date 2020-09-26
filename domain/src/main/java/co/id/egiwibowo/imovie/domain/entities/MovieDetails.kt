package co.id.egiwibowo.imovie.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetails(
    val movieId: Int,
    val title: String,
    val posterPath: String,
    val overview: String,
    val backdropPath: String,
    val voteCount: Int,
    val voteAverage: Float,
    val releaseDate: String,
    val runtime: String,
    val genres: List<Genre>
) : Parcelable {

    @Parcelize
    data class Genre(
        val id: Int,
        val name: String
    ): Parcelable
}