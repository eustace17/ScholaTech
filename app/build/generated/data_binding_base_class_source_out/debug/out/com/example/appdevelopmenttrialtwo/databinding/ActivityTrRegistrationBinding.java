// Generated by view binder compiler. Do not edit!
package com.example.appdevelopmenttrialtwo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appdevelopmenttrialtwo.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTrRegistrationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputLayout TrIdNo;

  @NonNull
  public final TextInputLayout TrName;

  @NonNull
  public final TextInputLayout TrPhone;

  @NonNull
  public final Button TrView;

  @NonNull
  public final TextInputLayout TscNo;

  @NonNull
  public final Button saveTr;

  @NonNull
  public final TextView textView2;

  private ActivityTrRegistrationBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputLayout TrIdNo, @NonNull TextInputLayout TrName,
      @NonNull TextInputLayout TrPhone, @NonNull Button TrView, @NonNull TextInputLayout TscNo,
      @NonNull Button saveTr, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.TrIdNo = TrIdNo;
    this.TrName = TrName;
    this.TrPhone = TrPhone;
    this.TrView = TrView;
    this.TscNo = TscNo;
    this.saveTr = saveTr;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTrRegistrationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTrRegistrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tr_registration, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTrRegistrationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TrIdNo;
      TextInputLayout TrIdNo = ViewBindings.findChildViewById(rootView, id);
      if (TrIdNo == null) {
        break missingId;
      }

      id = R.id.TrName;
      TextInputLayout TrName = ViewBindings.findChildViewById(rootView, id);
      if (TrName == null) {
        break missingId;
      }

      id = R.id.TrPhone;
      TextInputLayout TrPhone = ViewBindings.findChildViewById(rootView, id);
      if (TrPhone == null) {
        break missingId;
      }

      id = R.id.TrView;
      Button TrView = ViewBindings.findChildViewById(rootView, id);
      if (TrView == null) {
        break missingId;
      }

      id = R.id.TscNo;
      TextInputLayout TscNo = ViewBindings.findChildViewById(rootView, id);
      if (TscNo == null) {
        break missingId;
      }

      id = R.id.saveTr;
      Button saveTr = ViewBindings.findChildViewById(rootView, id);
      if (saveTr == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new ActivityTrRegistrationBinding((ConstraintLayout) rootView, TrIdNo, TrName, TrPhone,
          TrView, TscNo, saveTr, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
