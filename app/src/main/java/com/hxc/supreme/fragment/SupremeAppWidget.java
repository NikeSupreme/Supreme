package com.hxc.supreme.fragment;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.hxc.supreme.MainApplication;
import com.hxc.supreme.R;
import com.hxc.supreme.activity.MainActivity;
import com.hxc.supreme.service.MainService;

/**
 * Implementation of App Widget functionality.
 */
public class SupremeAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.supreme_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        views.setImageViewResource(R.id.appwidget_img, R.drawable.ic_snow_1);
        // Create an Intent to launch ExampleActivity
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        views.setOnClickPendingIntent(R.id.appwidget_img, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

