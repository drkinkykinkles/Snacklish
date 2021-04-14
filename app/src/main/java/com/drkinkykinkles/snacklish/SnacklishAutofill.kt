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

import android.app.PendingIntent
import android.app.assist.AssistStructure
import android.content.Intent
import android.os.Build
import android.os.CancellationSignal
import android.service.autofill.*
import android.view.inputmethod.InlineSuggestion
import androidx.annotation.RequiresApi
import androidx.autofill.inline.v1
import androidx.autofill.inline.v1.InlineSuggestionUi
import org.xml.sax.Parser


class SnacklishAutofill : AutofillService() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onFillRequest(request: FillRequest, cancellationSignal: CancellationSignal, callback: FillCallback) {
        val structure: AssistStructure? = request.fillContexts.lastOrNull()?.structure ?: return;
        val parser = Parser(structure, applicationContext)

        var parser = new Parser(structure, ApplicationContext);
        parser.Parse();



        val responseBuilder = FillResponse.Builder()
        var inlineRequest = request.inlineSuggestionsRequest

        var contentBuilder = InlineSuggestionUi.newContentBuilder(intent)
    }

    override fun onSaveRequest(request: SaveRequest, callback: SaveCallback) {
        TODO("Not yet implemented")
    }

    private fun createSlice () {

    }

    private Slice createSlice(
    InlinePresentationSpec imeSpec,
    CharSequence title,
    CharSequence subtitle,
    Icon startIcon,
    Icon endIcon,
    CharSequence contentDescription,
    PendingIntent attribution) {
        // Make sure that the IME spec claims support for v1 UI template.
        Bundle imeStyle = imeSpec.getStyle();
        if (!UiVersions.getVersions(imeStyle).contains(UiVersions.INLINE_UI_VERSION_1)) {
            return null;
        }

        // Build the content for the v1 UI.
        Content.Builder builder =
        InlineSuggestionUi.newContentBuilder(attribution)
                .setContentDescription(contentDescription);
        if(!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (!TextUtils.isEmpty(subtitle)) {
            builder.setSubtitle(subtitle);
        }
        if (startIcon != null) {
            startIcon.setTintBlendMode(BlendMode.DST)
            builder.setStartIcon(startIcon);
        }
        if (endIcon != null) {
            builder.setEndIcon(endIcon);
        }
        return builder.build().getSlice();
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
//
//        if (text != null) {
//            val converted = Converter.convert(text.toString())
//
//            // Is the user selecting text from a readonly text area?
//            val isReadonly = intent.getBooleanExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, false)
//
//            // If yes, the conversion will be dumped to their clipboard
//            // If no, the highlighted text will get replaced with the snacklish version
//            if (isReadonly) {
//                // Inject the converted text into the user's clipboard
//                val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                val item = ClipData.newPlainText(LABEL, converted)
//                clipboard.setPrimaryClip(item)
//
//                Toast.makeText(applicationContext, "Copiedelectible to choclipboard",  Toast.LENGTH_SHORT).show()
//            }
//            else {
//                // Replace the selected text with the new converted version
//                intent.putExtra(Intent.EXTRA_PROCESS_TEXT, converted)
//                setResult(RESULT_OK, intent)
//
//                Toast.makeText(applicationContext, "Choconverted successfullylicious",  Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        // Done!
//        finishAndRemoveTask()
//    }
}