package alexander.dmtaiwan.com.masterdetaillayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 3/6/2016.
 */
public class DetailFragment extends Fragment {

    private TextView mTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textView);
        if (getArguments() != null) {
            int position = getArguments().getInt("ARGUMENTS", -1);
            String text = "This Fragment was created by clicking on position: " + position + "";
            mTextView.setText(text);
        }
        return rootView;
    }
}
