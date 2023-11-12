package com.thp.tunisianhiddenplaces.ui.transport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.thp.tunisianhiddenplaces.databinding.FragmentTransportBinding;


public class TransportFragment extends Fragment {

    private FragmentTransportBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TransportViewModel transportViewModel =
                new ViewModelProvider(this).get(TransportViewModel.class);

        binding = FragmentTransportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTransport;
        transportViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
