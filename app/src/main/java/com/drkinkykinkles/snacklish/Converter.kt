package com.drkinkykinkles.snacklish

class Converter {
    companion object {
        fun convert(text: String): String {
            // Grab all individual words in the text and convert them
            val wordRegex = "[\\w']+".toRegex()
            return text.replace(wordRegex) { result -> preserveCasing(result.value, convertToken(result.value.toLowerCase())) }
        }

        /**
         * Converts individual words into snacklish
         */
        fun convertToken (token: String): String {
            // Some simple words we do not want to replace
            if (BlackList.contains(token)) {
                return token
            }

            // Some words we have specific replacements for
            if (FixedList.containsKey(token)) {
                return FixedList.getValue(token)
            }

            // Some words we can modify with special regulexes
            // Key order is randomized so we can get some waaacky results
            for (rule in RuleList.map { it.key to it.value }.shuffled().toMap()) {
                if (rule.key.toRegex().containsMatchIn(token)) {
                    return rule.key.toRegex().replace(token, rule.value)
                }
            }

            // If the word cannot be converted just return it
            return token
        }

        /**
         * Applies the original casing of a string to its new snacklish version
         */
        fun preserveCasing(original: String, result: String): String {
            if (original.toLowerCase() == original) {
                return result
            }

            if (original.toUpperCase() == original) {
                return result.toUpperCase()
            }

            if (original.capitalize() == original) {
                return result.capitalize()
            }

            return result
        }
    }
}