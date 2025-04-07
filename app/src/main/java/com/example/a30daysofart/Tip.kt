package com.example.a30daysofart

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

data class Tip(
    val day: String,
    val title: String,
    val imageResId: Int,
    val adviceShort: String,
    val adviceLong: String
)

fun loadTipsFromCSV(context: Context): List<Tip> {
    val tips = mutableListOf<Tip>()
    try {
        val inputStream = context.assets.open("tips.csv") // Убедитесь, что файл находится в папке assets
        val reader = BufferedReader(InputStreamReader(inputStream))

        reader.forEachLine { line ->
            val parts = line.split(";")
            if (parts.size == 4) {
                val day = "День "
                val title = parts[0].trim()
                val adviceShort = parts[1].trim()
                val adviceLong = parts[2].trim()
                val imageName = parts[3].trim()
                val imageResId = context.resources.getIdentifier(imageName, "drawable", context.packageName) // Получаем идентификатор ресурса изображения из имени

                tips.add(Tip(day, title, imageResId, adviceShort, adviceLong))
            }
        }
        reader.close()
    } catch (e: Exception) {
        Log.e("CSVError", "Error reading CSV file", e)
    }
    return tips
}
