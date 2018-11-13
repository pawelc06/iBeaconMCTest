package com.pwc.pawel.ibeaconmctest;

import android.app.Application;
import android.support.annotation.NonNull;

import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;

public class MyApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();

        MarketingCloudSdk.init(this, MarketingCloudConfig.builder()
                .setApplicationId("{mc_application_id}")
                .setAccessToken("{mc_access_token}")
                .setSenderId("488449775416")
                .setMarketingCloudServerUrl("{marketing_cloud_url}")
                .setMid("{mid}")
                .setProximityEnabled(true) //Enable Beacon messaging, default = false
                .setNotificationCustomizationOptions(
                        NotificationCustomizationOptions.create(R.drawable.ic_notification_icon)
                )
                // Other configuration options
                .build(this), new MarketingCloudSdk.InitializationListener() {
            @Override public void complete(@NonNull InitializationStatus status) {
                // TODO handle initialization status
            }
        });


    }
}
