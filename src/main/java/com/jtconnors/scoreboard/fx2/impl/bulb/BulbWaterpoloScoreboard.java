/*
 * Copyright (c) 2019, Jim Connors
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following
 *     disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *   * Neither the name of this project nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jtconnors.scoreboard.fx2.impl.bulb;

import com.jtconnors.scoreboard.common.Constants;
import com.jtconnors.scoreboard.fx2.framework.FxConstants;
import com.jtconnors.scoreboard.fx2.framework.hockey.HockeyScoreboard;

/*
 * This class extends the abstract Scoreboard class and must be written in
 * the following way:
 *    1. The constructor must call super(digitColor, digitHeight) first.
 *    2. A Specific implementation for the following abstract classes
 *       must already be created: Digit, SingleDigit, TwoDigit,
 *       Clock, Penalty.
 *    3. Once done, the slew of variables (defined in the
 *       super class) must be assigned and allocated an object
 *       of type defined by one of the implemented classes above.
 *       This has to be placed inside the constructor immediately after
 *       the call to super(...).
 *    4. Follwing the Digit allocations, a call to init()
 *       (defined in the super class) must be made in the constructor.
 */
public class BulbWaterpoloScoreboard extends HockeyScoreboard {

    public BulbWaterpoloScoreboard() {
        this(Constants.instance().DEFAULT_SCOREBOARD_WIDTH,
                Constants.instance().DEFAULT_SCOREBOARD_HEIGHT, false);
    }

    public BulbWaterpoloScoreboard(double width, double height) {
        this(width, height, false);
    }

    public BulbWaterpoloScoreboard(double width, double height,
            boolean remoteDisplay) {
        super(width, height, remoteDisplay);
        /*
         * The following variables are implementation specific and must
         * be changed for each implementation of this class.
         */
        clock = new BulbClock("clock", this, clockTimer,
                FxConstants.instance().DEFAULT_DIGIT_COLOR, largeDigitSize);
        homeScore = new BulbTwoDigit("homeScore",
                FxConstants.instance().DEFAULT_SECONDARY_COLOR,
                mediumDigitSize);
        guestScore = new BulbTwoDigit("guestScore",
                FxConstants.instance().DEFAULT_SECONDARY_COLOR,
                mediumDigitSize);
        period = new BulbSingleDigit("period",
                FxConstants.instance().DEFAULT_SECONDARY_COLOR,
                smallDigitSize, 1, 1, 4);
        homeShotsOnGoal = new BulbTwoDigit("homeShotsOnGoal", 
                FxConstants.instance().DEFAULT_SECONDARY_COLOR, smallDigitSize);
        guestShotsOnGoal = new BulbTwoDigit("guestShotsOnGoal",
                FxConstants.instance().DEFAULT_SECONDARY_COLOR, smallDigitSize);
        homePenalty1 = new BulbPenalty("homePenalty1", homePenalty1Timer,
                FxConstants.instance().DEFAULT_DIGIT_COLOR, mediumDigitSize);
        guestPenalty1 = new BulbPenalty("guestPenalty1", guestPenalty1Timer,
                FxConstants.instance().DEFAULT_DIGIT_COLOR, mediumDigitSize);
        homePenalty2 = new BulbPenalty("homePenalty2", homePenalty2Timer,
                FxConstants.instance().DEFAULT_DIGIT_COLOR, mediumDigitSize);
        guestPenalty2 = new BulbPenalty("guestPenalty2", guestPenalty2Timer,
                FxConstants.instance().DEFAULT_DIGIT_COLOR, mediumDigitSize);
        /*
         * End implementation specific section.
         */
        init();
    }
}
