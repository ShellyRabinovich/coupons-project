package com.shelly.coupons.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class Initializer {
    private Timer timer;
    private TimerTask expiredCouponsTimerTask;

    @Autowired
    public Initializer(ExpiredCouponsTimerTask expiredCouponsTimerTask) {
        this.timer = new Timer();
        this.expiredCouponsTimerTask = expiredCouponsTimerTask;
        expiredCouponsTimerTaskInitializer();
    }

    private void expiredCouponsTimerTaskInitializer() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH) + 1);

        Date date = today.getTime();
        timer.schedule(expiredCouponsTimerTask, date, 86400000);
    }
}
