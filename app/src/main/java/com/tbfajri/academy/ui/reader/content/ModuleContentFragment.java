package com.tbfajri.academy.ui.reader.content;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.tbfajri.academy.R;
import com.tbfajri.academy.data.ContentEntity;
import com.tbfajri.academy.data.ModuleEntity;
import com.tbfajri.academy.ui.reader.CourseReaderViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleContentFragment extends Fragment {

    public static final String TAG = ModuleContentFragment.class.getSimpleName();

    private WebView webView;
    private ProgressBar progressBar;
    private CourseReaderViewModel viewModel;

    public static ModuleContentFragment newInstance() {
        return new ModuleContentFragment();
    }


    public ModuleContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = view.findViewById(R.id.web_view);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(getActivity()).get(CourseReaderViewModel.class);
            ModuleEntity module = viewModel.getSelectedModule();
            populateWebView(module);
        }
    }

    private void populateWebView(ModuleEntity content) {
        webView.loadData(content.contentEntity.getContent(), "text/html", "UTF-8");
    }

}
