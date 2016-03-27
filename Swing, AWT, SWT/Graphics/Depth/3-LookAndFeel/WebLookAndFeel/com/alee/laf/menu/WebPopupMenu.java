/*
* This file is part of WebLookAndFeel library.
*
* WebLookAndFeel library is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* WebLookAndFeel library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.menu;

import javax.swing.*;

/**
 * User: mgarin Date: 15.08.11 Time: 16:37
 */

public class WebPopupMenu extends JPopupMenu
{
    private boolean ignoreBorderOnShow = false;

    public WebPopupMenu ()
    {
        super ();
    }

    public WebPopupMenu ( String label )
    {
        super ( label );
    }

    //    public boolean isIgnoreBorderOnShow ()
    //    {
    //        return ignoreBorderOnShow;
    //    }
    //
    //    public void setIgnoreBorderOnShow ( boolean ignoreBorderOnShow )
    //    {
    //        this.ignoreBorderOnShow = ignoreBorderOnShow;
    //    }
    //
    //    public void show ( Component invoker, int x, int y )
    //    {
    //        super.show ( invoker, x + ( ignoreBorderOnShow ? 0 : StyleConstants.shadeWidth ), y
    //                /*+ ( ignoreBorderOnShow ? 0 : StyleConstants.shadeWidth )*/ );
    //    }

    public void updateUI ()
    {
        setUI ( new WebPopupMenuUI () );
    }
}
