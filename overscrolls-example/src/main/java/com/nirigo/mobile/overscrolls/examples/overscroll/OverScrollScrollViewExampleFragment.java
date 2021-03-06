package com.nirigo.mobile.overscrolls.examples.overscroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nirigo.mobile.overscrolls.R;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.view.overscrolls.OverScrollScrollView;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class OverScrollScrollViewExampleFragment extends BaseFragment {

    private OverScrollScrollView scrollView;
    private ImageView imageView;
    private int originalHeight;
    private int originalMeasuredHeight;
    private int originalTop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflateFragmentLayout(inflater, container, R.layout.fragment_overscroll_scrollview);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.scrollView = (OverScrollScrollView) this.view;
        this.imageView = (ImageView) this.scrollView.findViewById(R.id.image);
    }

    private boolean unpeek;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        scrollView.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {
                // On normal scroll
                showScrollInfo("onScroll: " + scrollY); // Just show on screen
            }

            public void onOverScrollStart(ViewGroup parent) {
                // On over scroll start
                originalHeight = imageView.getLayoutParams().height;        // wrap_content, ...
                originalMeasuredHeight = imageView.getMeasuredHeight();
                originalTop = scrollView.getTop();
            }

            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                // On over scroll in progress
                setImageViewHeight(originalMeasuredHeight + overscrollY);

                // scrollView.getOverScroll().setOnOverScrollListener(null);   // less gap
                // scrollView.setTop(originalTop + overscrollY);
                // scrollView.getOverScroll().setOnOverScrollListener(this);

                showScrollInfo("onOverScroll: " + overscrollY); // Just show on screen
            }

            public void onOverScrollCancel(ViewGroup parent) {
                // On over scroll ended: release or scroll back to normal
                setImageViewHeight(ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                showScrollInfo("Cancel");
            }
        });

    }

    private void setImageViewHeight(int newHeight) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        params.height = newHeight;
        imageView.setLayoutParams(params);
    }



}
