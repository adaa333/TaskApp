package com.example.taskapp.data.entities

import android.content.res.Resources.Theme
import android.os.Parcelable
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.versionedparcelable.VersionedParcelize
import com.example.taskapp.data.entities.Task
import kotlinx.parcelize.Parcelize

@Entity (tableName = "Subjects")
@Parcelize
data class Subject(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "subject_id")
    val id: Long,
    val name: String,
    val theme: String,
): Parcelable