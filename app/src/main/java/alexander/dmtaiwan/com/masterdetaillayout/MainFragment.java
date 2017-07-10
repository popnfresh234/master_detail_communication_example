package alexander.dmtaiwan.com.masterdetaillayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lenovo on 3/6/2016.
 */
public class MainFragment extends Fragment{
    private Boolean mTablet;
    private Button mButton;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private MyInterface listener;

    public static MainFragment newInstance(MyInterface listener) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.listener = listener;
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        MyAdapter myAdapter = new MyAdapter(listener);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(myAdapter);

        return rootView;
    }
}
