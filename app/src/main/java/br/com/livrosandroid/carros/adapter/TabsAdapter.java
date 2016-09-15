package br.com.livrosandroid.carros.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.livrosandroid.carros.Fragments.CarrosFragment;
import br.com.livrosandroid.carros.R;
/**
 * Created by gabriel on 07/09/16.
 */
public class TabsAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private Context context;

    public TabsAdapter(Context context, android.support.v4.app.FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.classicos);
        } else if (position == 1) {
            return context.getString(R.string.esportivos);
        }
        return context.getString(R.string.luxo);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        if (position == 0) {
            args.putString("tipo", "classicos");
        } else if (position == 1) {
            args.putString("tipo", "esportivos");
        } else {
            args.putString("tipo", "luxo");
        }
        Fragment f = new CarrosFragment();
        f.setArguments(args);
        return f;
    }
}