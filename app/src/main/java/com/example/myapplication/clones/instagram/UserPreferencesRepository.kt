package com.example.myapplication.clones.instagram

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.util.concurrent.Flow

//include dependency implementation("androidx.datastore:datastore-preferences:1.0.0")
class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {

    private companion object {
        const val TAG = "UserPreferencesRepo"
        val SELECTED_TAB = intPreferencesKey("selectedTab")
    }
//
//    val selectedTabIndex: Flow<Int> = dataStore.data
//        .catch {
//            if(it is IOException) {
//                Log.e(TAG, "Error reading preferences.", it)
//                emit(emptyPreferences())
//            } else {
//                throw it
//            }
//        }
//        .map { preferences ->
//            preferences[SELECTED_TAB] ?: 0
//        }

    suspend fun saveSelectedTab(selectedTabIndex: Int) {
        dataStore.edit { preferences ->
            preferences[SELECTED_TAB] = selectedTabIndex
        }
    }
}