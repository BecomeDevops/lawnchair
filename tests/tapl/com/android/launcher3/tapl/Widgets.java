/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3.tapl;

import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;

/**
 * All widgets container.
 */
public final class Widgets extends LauncherInstrumentation.VisibleContainer {
    private static final int FLING_SPEED = 12000;

    Widgets(LauncherInstrumentation launcher) {
        super(launcher);
        verifyActiveContainer();
    }

    /**
     * Flings forward (down) and waits the fling's end.
     */
    public void flingForward() {
        final UiObject2 widgetsContainer = verifyActiveContainer();
        widgetsContainer.setGestureMargin(100);
        widgetsContainer.fling(Direction.DOWN, FLING_SPEED);
        verifyActiveContainer();
    }

    /**
     * Flings backward (up) and waits the fling's end.
     */
    public void flingBackward() {
        final UiObject2 widgetsContainer = verifyActiveContainer();
        widgetsContainer.setGestureMargin(100);
        widgetsContainer.fling(Direction.UP, FLING_SPEED);
        mLauncher.waitForIdle();
        verifyActiveContainer();
    }

    @Override
    protected LauncherInstrumentation.ContainerType getContainerType() {
        return LauncherInstrumentation.ContainerType.WIDGETS;
    }
}
