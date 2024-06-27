package dev.divyanshgemini.reciipiie.utils

import android.text.Html

class Formatters {
    companion object {
        // Get first name from full name
        fun getFirstName(fullName: String): String {
            // Split the full name by spaces
            val nameParts = fullName.split(" ")

            // Return the first part of the split result
            return if (nameParts.isNotEmpty()) nameParts[0] else ""
        }

        // Convert HTML to plain text
        fun getHtml(htmlBody: String): String {
            return Html.fromHtml(htmlBody, Html.FROM_HTML_MODE_LEGACY).toString()
        }
    }
}