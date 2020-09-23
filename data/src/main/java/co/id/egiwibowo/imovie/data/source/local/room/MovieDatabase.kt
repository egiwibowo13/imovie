package co.id.egiwibowo.imovie.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import co.id.egiwibowo.imovie.data.source.local.model.DBMovie

@Database(entities = [DBMovie::class], version = 2, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}