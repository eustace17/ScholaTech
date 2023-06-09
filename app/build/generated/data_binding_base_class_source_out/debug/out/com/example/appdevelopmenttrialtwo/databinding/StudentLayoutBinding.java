// Generated by view binder compiler. Do not edit!
package com.example.appdevelopmenttrialtwo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appdevelopmenttrialtwo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class StudentLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView UPI;

  @NonNull
  public final Button mBtnDelete;

  @NonNull
  public final Button mBtnUpdate;

  @NonNull
  public final TextView mEdFrName;

  @NonNull
  public final TextView mEdtAdmNo;

  @NonNull
  public final TextView mEdtDOA;

  @NonNull
  public final TextView mEdtDOB;

  @NonNull
  public final TextView mEdtFrCell;

  @NonNull
  public final TextView mEdtFrId;

  @NonNull
  public final TextView mEdtFrOccupation;

  @NonNull
  public final TextView mEdtGrade;

  @NonNull
  public final TextView mEdtMrCell;

  @NonNull
  public final TextView mEdtMrId;

  @NonNull
  public final TextView mEdtMrJob;

  @NonNull
  public final TextView mEdtMrName;

  @NonNull
  public final TextView mEdtStdName;

  private StudentLayoutBinding(@NonNull LinearLayout rootView, @NonNull TextView UPI,
      @NonNull Button mBtnDelete, @NonNull Button mBtnUpdate, @NonNull TextView mEdFrName,
      @NonNull TextView mEdtAdmNo, @NonNull TextView mEdtDOA, @NonNull TextView mEdtDOB,
      @NonNull TextView mEdtFrCell, @NonNull TextView mEdtFrId, @NonNull TextView mEdtFrOccupation,
      @NonNull TextView mEdtGrade, @NonNull TextView mEdtMrCell, @NonNull TextView mEdtMrId,
      @NonNull TextView mEdtMrJob, @NonNull TextView mEdtMrName, @NonNull TextView mEdtStdName) {
    this.rootView = rootView;
    this.UPI = UPI;
    this.mBtnDelete = mBtnDelete;
    this.mBtnUpdate = mBtnUpdate;
    this.mEdFrName = mEdFrName;
    this.mEdtAdmNo = mEdtAdmNo;
    this.mEdtDOA = mEdtDOA;
    this.mEdtDOB = mEdtDOB;
    this.mEdtFrCell = mEdtFrCell;
    this.mEdtFrId = mEdtFrId;
    this.mEdtFrOccupation = mEdtFrOccupation;
    this.mEdtGrade = mEdtGrade;
    this.mEdtMrCell = mEdtMrCell;
    this.mEdtMrId = mEdtMrId;
    this.mEdtMrJob = mEdtMrJob;
    this.mEdtMrName = mEdtMrName;
    this.mEdtStdName = mEdtStdName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static StudentLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static StudentLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.student_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static StudentLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.UPI;
      TextView UPI = ViewBindings.findChildViewById(rootView, id);
      if (UPI == null) {
        break missingId;
      }

      id = R.id.mBtnDelete;
      Button mBtnDelete = ViewBindings.findChildViewById(rootView, id);
      if (mBtnDelete == null) {
        break missingId;
      }

      id = R.id.mBtnUpdate;
      Button mBtnUpdate = ViewBindings.findChildViewById(rootView, id);
      if (mBtnUpdate == null) {
        break missingId;
      }

      id = R.id.mEdFrName;
      TextView mEdFrName = ViewBindings.findChildViewById(rootView, id);
      if (mEdFrName == null) {
        break missingId;
      }

      id = R.id.mEdtAdmNo;
      TextView mEdtAdmNo = ViewBindings.findChildViewById(rootView, id);
      if (mEdtAdmNo == null) {
        break missingId;
      }

      id = R.id.mEdtDOA;
      TextView mEdtDOA = ViewBindings.findChildViewById(rootView, id);
      if (mEdtDOA == null) {
        break missingId;
      }

      id = R.id.mEdtDOB;
      TextView mEdtDOB = ViewBindings.findChildViewById(rootView, id);
      if (mEdtDOB == null) {
        break missingId;
      }

      id = R.id.mEdtFrCell;
      TextView mEdtFrCell = ViewBindings.findChildViewById(rootView, id);
      if (mEdtFrCell == null) {
        break missingId;
      }

      id = R.id.mEdtFrId;
      TextView mEdtFrId = ViewBindings.findChildViewById(rootView, id);
      if (mEdtFrId == null) {
        break missingId;
      }

      id = R.id.mEdtFrOccupation;
      TextView mEdtFrOccupation = ViewBindings.findChildViewById(rootView, id);
      if (mEdtFrOccupation == null) {
        break missingId;
      }

      id = R.id.mEdtGrade;
      TextView mEdtGrade = ViewBindings.findChildViewById(rootView, id);
      if (mEdtGrade == null) {
        break missingId;
      }

      id = R.id.mEdtMrCell;
      TextView mEdtMrCell = ViewBindings.findChildViewById(rootView, id);
      if (mEdtMrCell == null) {
        break missingId;
      }

      id = R.id.mEdtMrId;
      TextView mEdtMrId = ViewBindings.findChildViewById(rootView, id);
      if (mEdtMrId == null) {
        break missingId;
      }

      id = R.id.mEdtMrJob;
      TextView mEdtMrJob = ViewBindings.findChildViewById(rootView, id);
      if (mEdtMrJob == null) {
        break missingId;
      }

      id = R.id.mEdtMrName;
      TextView mEdtMrName = ViewBindings.findChildViewById(rootView, id);
      if (mEdtMrName == null) {
        break missingId;
      }

      id = R.id.mEdtStdName;
      TextView mEdtStdName = ViewBindings.findChildViewById(rootView, id);
      if (mEdtStdName == null) {
        break missingId;
      }

      return new StudentLayoutBinding((LinearLayout) rootView, UPI, mBtnDelete, mBtnUpdate,
          mEdFrName, mEdtAdmNo, mEdtDOA, mEdtDOB, mEdtFrCell, mEdtFrId, mEdtFrOccupation, mEdtGrade,
          mEdtMrCell, mEdtMrId, mEdtMrJob, mEdtMrName, mEdtStdName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
