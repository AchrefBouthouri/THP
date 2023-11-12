package com.thp.tunisianhiddenplaces.ui.apartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.thp.tunisianhiddenplaces.databinding.FragmentApartmentBinding;

public class ApartmentFragment extends Fragment {
    private FragmentApartmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ApartmentViewModel apartmentViewModel =
                new ViewModelProvider(this).get(ApartmentViewModel.class);

        binding = FragmentApartmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textApartment;
        apartmentViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
