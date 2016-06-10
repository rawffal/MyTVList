package com.example.nahson.mytvlist.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.nahson.mytvlist.Fragments.PersonalTvListFragment;
import com.example.nahson.mytvlist.Fragments.SearchFragment;
import com.example.nahson.mytvlist.R;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class HomeActivity extends AppCompatActivity /*AddFragment*/{
  /*@Override
    public Fragment createFragment() {
        return new SearchFragment();
    }*/

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_container);
      FragmentManager fm = getSupportFragmentManager();
      Fragment fragment = fm.findFragmentById(R.id.fragment_holder);

      if(fragment == null){
          fragment = new PersonalTvListFragment();
          fm.beginTransaction()
                  .add(R.id.fragment_holder, fragment)
                  .commit();
      }
  }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


}
