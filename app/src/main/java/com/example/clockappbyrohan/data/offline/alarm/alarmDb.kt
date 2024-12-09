package com.example.clockappbyrohan.data.offline.alarm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Alarms::class] , version = 1, exportSchema = false)
abstract class alarmDb : RoomDatabase(){
    /**
     * alarmDbDAO() fun is used to get the dao of the database.
     * @return AlarmDbDAO : it is the dao of the database. Use it to transact with the database
     */
    abstract fun AlarmDbDAO(): AlarmDbDAO



}