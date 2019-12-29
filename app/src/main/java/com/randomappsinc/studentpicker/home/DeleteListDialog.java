package com.randomappsinc.studentpicker.home;

import android.content.Context;

import androidx.annotation.NonNull;

import com.afollestad.materialdialogs.MaterialDialog;
import com.randomappsinc.studentpicker.R;

public class DeleteListDialog {

    public interface Listener {
        void onDeleteListConfirmed(int position);
    }

    private MaterialDialog dialog;
    private int position;

    DeleteListDialog(@NonNull Listener listener, Context context) {
        dialog = new MaterialDialog.Builder(context)
                .title(R.string.confirm_deletion_title)
                .positiveText(android.R.string.yes)
                .negativeText(android.R.string.cancel)
                .onPositive((dialog, which) ->
                        listener.onDeleteListConfirmed(position)
                ).build();
    }

    void presentForList(int position, String listName) {
        this.position = position;
        String dialogContent =
                dialog.getContext().getString(R.string.confirm_deletion_message, " \"" + listName + "\"");
        dialog.setContent(dialogContent);
        dialog.show();
    }
}
