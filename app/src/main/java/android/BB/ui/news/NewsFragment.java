package android.BB.ui.news;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.BB.R;

/**
 * Created by KalinaRain on 2015/7/17.
 */
public class NewsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ll_news, container, false);
    }
}
