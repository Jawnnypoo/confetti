package com.github.jinatonic.confetti.sample;

import android.view.View;

import com.github.jinatonic.confetti.ConfettiManager;

public class ShoweringConfettiActivity extends AbstractActivity {
    @Override
    public void onClick(View view) {
        final ConfettiManager.ConfettiSource confettiSource = new ConfettiManager.ConfettiSource(
                0, -confettiSize, container.getWidth(), -confettiSize);
        new ConfettiManager(this, this, confettiSource, container)
                .setEmissionDuration(3000)
                .setEmissionRate(100)
                .setVelocityX(0, velocitySlow)
                .setVelocityY(velocityNormal, 0f)
                .setAccelerationY(0f, 0f)
                .setMaximumVelocityY(defaultMaximumVelocityY)
                .setInitialRotation(180, 180)
                .setRotationalAcceleration(360, 180)
                .setMaximumRotationalVelocity(360)
                .animate();
    }
}