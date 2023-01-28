package com.example.banneradd;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class Banner {
    AdView adView;
    Context context;
    View view;

    public Banner(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void fbpripor() {
        if (!Config.fb_banner.isEmpty()) {
            com.facebook.ads.AdView fbadView = new com.facebook.ads.AdView(context, Config.fb_banner, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            ((RelativeLayout) view).addView(fbadView);


            AdListener adListener = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e("TAG", "onError: fb banner" + adError);
                    loadbbanner1();

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Ad loaded callback
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };

            fbadView.loadAd(fbadView.buildLoadAdConfig().withAdListener(adListener).build());

        } else if (!Config.admob_banner.isEmpty()) {
            ((RelativeLayout) view).removeAllViews();
            adView = new AdView(context);
            adView.setAdSize(AdSize.BANNER);
            adView.setAdUnitId(Config.admob_banner);
            ((RelativeLayout) view).addView(adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }


    }

    private void loadbbanne2() {
        if (!Config.fb_banner2.isEmpty()) {
            com.facebook.ads.AdView fbadView2 = new com.facebook.ads.AdView(context, Config.fb_banner2, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            ((RelativeLayout) view).addView(fbadView2);

            AdListener adListener2 = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {

                    if (!Config.admob_banner.isEmpty()) {
                        ((RelativeLayout) view).removeAllViews();
                        adView = new AdView(context);
                        adView.setAdSize(AdSize.BANNER);
                        adView.setAdUnitId(Config.admob_banner);
                        ((RelativeLayout) view).addView(adView);
                        AdRequest adRequest = new AdRequest.Builder().build();
                        adView.loadAd(adRequest);
                    }
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Ad loaded callback
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };

            fbadView2.loadAd(fbadView2.buildLoadAdConfig().withAdListener(adListener2).build());


        }
    }

    private void loadbbanner1() {
        if (!Config.fb_banner1.isEmpty()) {
            com.facebook.ads.AdView fbadView1 = new com.facebook.ads.AdView(context, Config.fb_banner1, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            ((RelativeLayout) view).addView(fbadView1);

            AdListener adListener1 = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                    loadbbanne2();
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Ad loaded callback
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };

            fbadView1.loadAd(fbadView1.buildLoadAdConfig().withAdListener(adListener1).build());


        }


    }


}
