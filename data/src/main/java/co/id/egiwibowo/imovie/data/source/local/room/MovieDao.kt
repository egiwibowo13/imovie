package co.id.egiwibowo.imovie.data.source.local.room

import androidx.room.*
import co.id.egiwibowo.imovie.data.source.local.model.DBMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getPopularMovies(): Flow<List<DBMovie>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoritMovies(): Flow<List<DBMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<DBMovie>)

    @Update
    fun updateFavoriteMovie(movie: DBMovie)
}