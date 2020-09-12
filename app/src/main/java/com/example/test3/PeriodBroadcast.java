package com.example.test3;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;

public class PeriodBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator1=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator1.vibrate(2000);
        Notification noti1= new Notification.Builder(context)
                .setContentTitle("Period")
                .setContentText("Period Week")
                .setSmallIcon(R.mipmap.ic_launcher).build();
        NotificationManager manager1=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.flags=Notification.FLAG_AUTO_CANCEL;
        manager1.notify(0,noti1);
        Uri notification1= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r=RingtoneManager.getRingtone(context,notification1);
        r.play();

    }
}
