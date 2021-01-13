package com.example.malakdianadewi.moneymanager;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context){
        this.context = context;
    }


//menyimpan url untuk picaso untuk ditampilkan pada slide view
    public int[] slide_image={
        R.drawable.samen

    };

    //menyimpan text untuk ditampilkan pada slide view
    public String[] slide_headings={
            "SALES MANAGEMENT "
    };

    //menyimpan text untuk ditampilkan pada slide view
    public  String[] slide_descs = {
            "Merupakan aplikasi pengelolaan keungan usaha mikro kecil yang memiliki beberapa fitur penunjang seperti menyimpan dan menampilkan data pemasukan dan pengeluaran, Ubah dan hapus data, serta menyajika data kedalam bentuk diagram Pie chart"

    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return  view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription= (TextView) view.findViewById(R.id.slide_desc);
        //untuk menampilkan image dari url sesuai posisi
        Picasso.with(context).load(slide_image[position]).placeholder(R.drawable.profil).error(R.drawable.warning).into(slideImageView);
        //untuk mengatur isi teksview dari array yang telah disimpan
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
