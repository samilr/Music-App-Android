package com.example.tareatabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.tareatabs.tabs.contacto;
import com.example.tareatabs.tabs.inicio;
import com.example.tareatabs.tabs.musica;
import com.example.tareatabs.tabs.registro;

class PagerAdapter  extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new inicio();
            case 1:
                return new registro();
            case 2:
                return new contacto();
            case 3:
                return new musica();
            default:
                return new inicio();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
