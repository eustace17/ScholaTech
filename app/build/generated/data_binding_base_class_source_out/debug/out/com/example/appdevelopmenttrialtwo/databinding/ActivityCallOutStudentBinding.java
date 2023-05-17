// Generated by view binder compiler. Do not edit!
package com.example.appdevelopmenttrialtwo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appdevelopmenttrialtwo.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCallOutStudentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btncallout;

  @NonNull
  public final TextInputLayout calloutname;

  @NonNull
  public final TextInputLayout calloutupi;

  @NonNull
  public final TextInputEditText editTextName;

  @NonNull
  public final TextInputEditText editTextUpi;

  private ActivityCallOutStudentBinding(@NonNull LinearLayout rootView, @NonNull Button btncallout,
      @NonNull TextInputLayout calloutname, @NonNull TextInputLayout calloutupi,
      @NonNull TextInputEditText editTextName, @NonNull TextInputEditText editTextUpi) {
    this.rootView = rootView;
    this.btncallout = btncallout;
    this.calloutname = calloutname;
    this.calloutupi = calloutupi;
    this.editTextName = editTextName;
    this.editTextUpi = editTextUpi;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCallOutStudentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCallOutStudentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_call_out_student, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCallOutStudentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btncallout;
      Button btncallout = ViewBindings.findChildViewById(rootView, id);
      if (btncallout == null) {
        break missingId;
      }

      id = R.id.calloutname;
      TextInputLayout calloutname = ViewBindings.findChildViewById(rootView, id);
      if (calloutname == null) {
        break missingId;
      }

      id = R.id.calloutupi;
      TextInputLayout calloutupi = ViewBindings.findChildViewById(rootView, id);
      if (calloutupi == null) {
        break missingId;
      }

      id = R.id.edit_text_name;
      TextInputEditText editTextName = ViewBindings.findChildViewById(rootView, id);
      if (editTextName == null) {
        break missingId;
      }

      id = R.id.edit_text_upi;
      TextInputEditText editTextUpi = ViewBindings.findChildViewById(rootView, id);
      if (editTextUpi == null) {
        break missingId;
      }

      return new ActivityCallOutStudentBinding((LinearLayout) rootView, btncallout, calloutname,
          calloutupi, editTextName, editTextUpi);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
