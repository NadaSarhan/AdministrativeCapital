package com.nada.administrativecapital.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.nada.administrativecapital.R;
import com.nada.administrativecapital.adapter.SliderAdapter;
import com.nada.administrativecapital.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class AlbumFragment extends Fragment {

    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_album, container, false);

        viewPager2 = (ViewPager2) view.findViewById(R.id.viewPagerImageSlider);

        // prepare list of images from drawable
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.vitalplaces01, "الصالة المغطاة\nتضم الصالة مقصورة كبار الزوار وقاعة للإقامة المؤتمرات الصحفية."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces02, "مولات العاصمة\nتمتاز بفخامة تصميماتها، بالإضافة أي انها مزوده بالتجهيزات الأساسية."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces03, "فندق الماسة\nيتم انشاءه تحت اشراف الهيئة الهندسية للقوات المسلحة."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces04, "كاتدرائية ميلاد المسيح\nتعد الأكبر حجما وسعه في الشرق الأوسط."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces05, "حي البنوك\nيقع بمنطقة وسط البلد بجوار الحي الحكومي ويضم ٣٠ بنك، تبلغ مساحته حوالي ٣٠٠ الف فدان، وسيتم تنفيذ البنوك بطراز معماري يناسب طراز وسط المدينة."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces06, "مقر البرلمان\nيضم مبنى البرلمان قاعات تواكب التكنولوجيا بما يليق بنواب الشعب المصري."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces07, "مسجد الفتاح العليم\nأحد مساجد القاهرة ذات الطراز المعماري الإسلامي."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces08, "محطة قطار (المونوريل)\nمحطة القطار الكهربائي السريع الاول في مصر والذي يعتبر احد وسائل النقل الجماعي الأمنة والغير ملوثة للبيئة."));
        sliderItems.add(new SliderItem(R.drawable.vitalplaces09, "البرج الأيقوني\nيعد البرج الأيقوني اعلى برج في افريقيا حيث يصل ارتفاعه 400 متر."));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        return view;
    }

}
