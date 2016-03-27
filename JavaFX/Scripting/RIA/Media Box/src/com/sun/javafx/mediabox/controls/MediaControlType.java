/* 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms. 
 * 
 * This file is available and licensed under the following license:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 *
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *   * Neither the name of Sun Microsystems nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.sun.javafx.mediabox.controls;

/**
 *
 * @author baechul
 */

/**
 * This enum defines the possible types for a media control.
 *
 * @profile common
 */
public enum MediaControlType {

    /**
     * Defines a type with a {@code PlayControl}.
     */
    PLAY_CONTROL,

    /**
     * Defines a type with a {@code StopControl}.
     */
    STOP_CONTROL,

    /**
     * Defines a type with a {@code FastForward}.
     */
    FAST_FORWARD,

    /**
     * Defines a type with a {@code FastBackward}.
     */
    FAST_BACKWARD,

    /**
     * Defines a type with a {@code MediaSlider}.
     */
    MEDIA_SLIDER,

    /**
     * Defines a current time type with a {@code MediaTime}.
     */
    CURRENT_TIME,

    /**
     * Defines a remaining time type with a {@code MediaTime}.
     */
    REMAINING_TIME,

    /**
     * Defines a type with a {@code SpeakerControl}.
     */
    SPEAKER,

    /**
     * Defines a type with a {@code VolumeControl}.
     */
    VOLUME,

    /**
     * Defines a type with a {@code FullScreen}.
     */
    FULL_SCREEN,

    /**
     * Defines a type with a {@code BufferIndicator}.
     */
    BUFFER_INDICATOR,
}

