package com.example.movieappandroid.util

import android.util.Log
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import okio.Buffer
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

internal object JSONObjectAdapter {

    const val TAG = "JSONObjectAdapter"

    @FromJson
    fun fromJson(reader: JsonReader): JSONObject? {
        return (reader.readJsonValue() as? Map<String, Any>)?.let { data ->
            try {
                JSONObject(data)
            } catch (e: JSONException) {
                Log.d(TAG, "Failed to deserialize the JSONObject: ${e.localizedMessage}")
                null
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: JSONObject?) {
        value?.let { writer.value(Buffer().writeUtf8(value.toString())) }
    }
}

internal object JSONArrayAdapter {

    @FromJson
    fun fromJson(reader: JsonReader): JSONArray? {
        return (reader.readJsonValue() as? List<Any>)?.let { data ->
            try {
                JSONArray(data)
            } catch (e: JSONException) {
                Log.d(JSONObjectAdapter.TAG,
                    "Failed to deserialize the JSONArray: ${e.localizedMessage}")
                null
            }
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: JSONArray?) {
        value?.let { writer.value(Buffer().writeUtf8(value.toString())) }
    }
}