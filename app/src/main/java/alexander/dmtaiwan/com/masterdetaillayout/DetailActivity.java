package alexander.dmtaiwan.com.masterdetaillayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 3/9/2016.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null) {
            //Get EXTRA from intent and attach to Fragment as Argument
            int position = getIntent().getIntExtra("EXTRA", -1);
            Bundle args = new Bundle();
            args.putInt("ARGUMENTS", position);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
        }
    }
}
