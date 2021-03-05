/*
Snacklish
Converts selected text to Snacklish

Credits:
 - original Snacklish code
    AnnoyedGrunt - https://github.com/AnnoyedGrunt/snacklishreborn
 - special thanks:
    Harrison Lambeth - https://github.com/monodop
    Nathan Healea - https://github.com/NathanHealea
 */

package com.drkinkykinkles.snacklish

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

const val LABEL: String = "SnacklishConverter";

class SnacklishMain : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);

        if (text != null) {
            val converted = Converter.convert(text.toString());

            // Is the user selecting text from a readonly text area?
            val isReadonly = intent.getBooleanExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false);

            // If yes, the conversion will be dumped to their clipboard
            // If no, the highlighted text will get replaced with the snacklish version
            if (isReadonly) {
                // Inject the converted text into the user's clipboard
                val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;
                val item = ClipData.newPlainText(LABEL, converted);
                clipboard.setPrimaryClip(item);

                // TODO: if errors, toast to failure
                Toast.makeText(applicationContext, "Copiedelectible to choclipboard",  Toast.LENGTH_SHORT).show();
            }
            else {
                // Replace the selected text with the new converted version
                val intenty = Intent();
                intenty.putExtra(Intent.EXTRA_PROCESS_TEXT, converted);
                setResult(RESULT_OK, intenty);

                // TODO: if errors, toast to failure
                Toast.makeText(applicationContext, "Choconverted successfullylicious",  Toast.LENGTH_SHORT).show();
            }
        }

        // Kill the app when it's done
        finishAndRemoveTask();
    }
}