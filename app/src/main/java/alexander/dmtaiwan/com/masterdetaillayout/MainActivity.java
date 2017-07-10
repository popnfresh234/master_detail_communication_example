package alexander.dmtaiwan.com.masterdetaillayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MyInterface{
    private Boolean mTabletMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentContainer, mainFragment).commit();

        if(findViewById(R.id.detailContainer)!= null){
            mTabletMode = true;
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
        }
    }

    public boolean isTablet() {
        return mTabletMode;
    }

    private void replaceFragment(int position) {
        Log.i("tab", "replace");
        Bundle args = new Bundle();
        args.putInt("ARGUMENTS", position);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
    }

    private void launchDetailActivity(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("EXTRA", position);
        startActivity(detailIntent);
    }

    @Override
    public void handleClick(int position) {
        if (isTablet()) {
            replaceFragment(position);
        }else{
            launchDetailActivity(position);
        }


    }


}
