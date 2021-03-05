package com.drkinkykinkles.snacklish

class Converter {
    companion object {
        fun convert(text: String): String {
            // Load in the lists we will use to manipulate the text
            val blacklist = GetBlacklist();
            val fixedList = GetFixedList();
            val ruleList = GetRuleList();

            // Grab all individual words in the text and convert them
            val wordRegex = "[\\w']+".toRegex();
            return text.replace(wordRegex) { result -> preserveCasing(result.value, convertToken(result.value.toLowerCase(), blacklist, fixedList, ruleList)) }
        }

        /**
         * Converts individual words into snacklish
         */
        fun convertToken (token: String, blacklist: Set<String>, fixedList: Map<String, String>, ruleList: Map<String, String>): String {
            // Some simple words we do not want to replace
            if (blacklist.contains(token)) {
                return token;
            }

            // Some words we have specific replacements for
            if (fixedList.containsKey(token)) {
                return fixedList.getValue(token);
            }

            // Some words we can modify with special regulexes
            // Key order is randomized so we can get some waaacky results
            for (rule in ruleList.map { it.key to it.value }.shuffled().toMap()) {
                if (rule.key.toRegex().containsMatchIn(token)) {
                    return rule.key.toRegex().replace(token, rule.value);
                }
            }

            // If the word cannot be converted just return it
            return token;
        }

        /**
         * Applies the original casing of a string to its new snacklish version
         */
        fun preserveCasing(original: String, result: String): String {
            if (original.toLowerCase() == original) {
                return result;
            }

            if (original.toUpperCase() == original) {
                return result.toUpperCase();
            }

            if (original.capitalize() == original) {
                return result.capitalize();
            }

            return result;
        }
    }
}