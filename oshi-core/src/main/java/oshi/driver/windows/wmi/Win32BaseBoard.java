/*
 * MIT License
 *
 * Copyright (c) 2020-2022 The OSHI Project Contributors: https://github.com/oshi/oshi/graphs/contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package oshi.driver.windows.wmi;

import java.util.Objects;

import com.sun.jna.platform.win32.COM.WbemcliUtil.WmiQuery;
import com.sun.jna.platform.win32.COM.WbemcliUtil.WmiResult;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

/**
 * Utility to query WMI class {@code Win32_BaseBoard}
 */
@ThreadSafe
public final class Win32BaseBoard {

    private static final String WIN32_BASEBOARD = "Win32_BaseBoard";

    /**
     * Baseboard description properties.
     */
    public enum BaseBoardProperty {
        MANUFACTURER, MODEL, VERSION, SERIALNUMBER;
    }

    private Win32BaseBoard() {
    }

    /**
     * Queries the Baseboard description.
     *
     * @return Baseboard manufacturer, model, and related fields.
     */
    public static WmiResult<BaseBoardProperty> queryBaseboardInfo() {
        WmiQuery<BaseBoardProperty> baseboardQuery = new WmiQuery<>(WIN32_BASEBOARD, BaseBoardProperty.class);
        return Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(baseboardQuery);
    }
}
