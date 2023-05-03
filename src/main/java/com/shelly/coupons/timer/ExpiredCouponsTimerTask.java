package com.shelly.coupons.timer;

import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

@Component
public class ExpiredCouponsTimerTask extends TimerTask {
    private CouponsLogic couponsLogic;

    @Autowired
    public ExpiredCouponsTimerTask(CouponsLogic couponsLogic) {
        this.couponsLogic = (couponsLogic);
    }

    @Override
    public void run() {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) - 1);
        Date date = now.getTime();
        try {
            couponsLogic.removeExpiredCoupons(date);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        }
    }
}
