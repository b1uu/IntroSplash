package com.material.bluu.material;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/*
   *Intro Splash Activity
   * with three screens contained within a ViewPager
   * static implementation, can be implemented for more number of pages
   * fragment contains an image with a short description
 */

public class IntroActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private Button start, skip;

    // ImageView to capture the ViewPager indicators
    private ImageView one;
    private ImageView two;
    private ImageView three;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        start = (Button) findViewById(R.id.start);
        skip = (Button) findViewById(R.id.skip);

        start.setVisibility(View.INVISIBLE);


        one = (ImageView) findViewById(R.id.one);
        two = (ImageView) findViewById(R.id.two);
        three = (ImageView) findViewById(R.id.three);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        //indicator implementation
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    // highlighting indicator with respect to the page
                    case 0:
                        one.setBackgroundResource(R.drawable.indicator_dot_white);
                        two.setBackgroundResource(R.drawable.indicator_dot_grey);
                        three.setBackgroundResource(R.drawable.indicator_dot_grey);
                        skip.setVisibility(View.VISIBLE);
                        start.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        one.setBackgroundResource(R.drawable.indicator_dot_grey);
                        two.setBackgroundResource(R.drawable.indicator_dot_white);
                        three.setBackgroundResource(R.drawable.indicator_dot_grey);
                        skip.setVisibility(View.VISIBLE);
                        start.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        one.setBackgroundResource(R.drawable.indicator_dot_grey);
                        two.setBackgroundResource(R.drawable.indicator_dot_grey);
                        three.setBackgroundResource(R.drawable.indicator_dot_white);
                        skip.setVisibility(View.INVISIBLE);
                        start.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(mSectionsPagerAdapter);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_DRAWABLE = "drawable";
        private static final String ARG_TITLE = "title";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            /*
                * arguments initialization for the image and text
             */

            if (sectionNumber == 1) {
                args.putInt(ARG_DRAWABLE, R.drawable.firewatch);
                args.putString(ARG_TITLE, "Good Morning");
            } else if (sectionNumber == 2) {
                args.putInt(ARG_DRAWABLE, R.drawable.nightrain);
                args.putString(ARG_TITLE, "Good Night");
            } else if (sectionNumber == 3) {
                args.putInt(ARG_DRAWABLE, R.drawable.nature);
                args.putString(ARG_TITLE, "Good Evening");
            }
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_one, container, false);
            ImageView image = (ImageView) rootView.findViewById(R.id.image);

            // setting background image
            image.setBackgroundResource(getArguments().getInt(ARG_DRAWABLE));
            TextView header = (TextView) rootView.findViewById(R.id.header);
            TextView body = (TextView) rootView.findViewById(R.id.body);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), getArguments().getInt(ARG_DRAWABLE));

            // Synchronous Palette implementation
            Palette var = Palette.generate(bitmap);
            Palette.Swatch pal = var.getDarkVibrantSwatch();


            RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.layout);
            layout.setBackgroundColor(pal.getRgb());

            Typeface type = Typeface.createFromAsset(getContext().getAssets(), "segoeuil.ttf");
            header.setTypeface(type);
            body.setTypeface(type);

            // setting text description
            header.setText(getArguments().getString(ARG_TITLE));
            header.setTextColor(pal.getTitleTextColor());
            body.setTextColor(pal.getBodyTextColor());
            return rootView;
        }

    }
}
