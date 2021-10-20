package com.example.eleventhlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomDialogFragment extends BottomSheetDialogFragment {

    private Button buttonNo;
    private Button buttonYes;

    


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_dialog, container, false);

        buttonNo = view.findViewById(R.id.buttonNo);
        buttonYes = view.findViewById(R.id.buttonYes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ((MainActivity) requireActivity()).onResultDialogFragment("Yes");
                if (onDialogListener!= null)
                onDialogListener.pressYes();  // передача через интерфейс
                dismiss();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ((MainActivity) requireActivity()).onResultDialogFragment("No");   предача на прямую
                if (onDialogListener!=null)
                onDialogListener.pressNo();
                dismiss();
            }
        });
        setCancelable(false);
        return view;
    }
    private OnDialogListener onDialogListener;

    public void setOnDialogListener(OnDialogListener onDialogListener) {
        this.onDialogListener = onDialogListener;
    }

}
