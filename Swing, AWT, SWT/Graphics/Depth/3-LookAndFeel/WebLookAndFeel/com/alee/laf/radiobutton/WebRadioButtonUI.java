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

package com.alee.laf.radiobutton;

import com.alee.laf.list.WebListElement;
import com.alee.laf.tree.WebTreeCellRenderer;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mgarin Date: 28.04.11 Time: 14:55
 */

public class WebRadioButtonUI extends BasicRadioButtonUI
{
    public static List<ImageIcon> BG_STATES = new ArrayList<ImageIcon> ();
    public static List<ImageIcon> CHECK_STATES = new ArrayList<ImageIcon> ();

    static
    {
        for ( int i = 1; i <= 4; i++ )
        {
            BG_STATES.add ( new ImageIcon (
                    WebRadioButtonUI.class.getResource ( "icons/" + i + ".png" ) ) );
        }

        CHECK_STATES.add ( new ImageIcon (
                new BufferedImage ( 16, 16, BufferedImage.TYPE_INT_ARGB ) ) );
        for ( int i = 1; i <= 3; i++ )
        {
            CHECK_STATES.add ( new ImageIcon (
                    WebRadioButtonUI.class.getResource ( "icons/c" + i + ".png" ) ) );
        }
    }

    private int bgIcon = 0;
    private boolean in;
    private Timer bgTimer;

    private int checkIcon = 0;
    private boolean checking;
    private Timer checkTimer;

    private boolean animated = true;

    private JRadioButton radioButton;

    private MouseAdapter mouseAdapter;
    private ItemListener itemListener;

    public static ComponentUI createUI ( JComponent c )
    {
        return new WebRadioButtonUI ();
    }

    public void installUI ( JComponent c )
    {
        super.installUI ( c );

        radioButton = ( JRadioButton ) c;
        radioButton.setOpaque ( false );
        radioButton.setBorder ( BorderFactory.createEmptyBorder ( 0, 0, 0, 0 ) );
        radioButton.setMargin ( new Insets ( 0, 0, 0, 0 ) );

        updateIcon ( radioButton );

        bgTimer = new Timer ( 40, new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                if ( in && bgIcon < BG_STATES.size () - 1 )
                {
                    bgIcon++;
                    updateIcon ( radioButton );
                }
                else if ( !in && bgIcon > 0 )
                {
                    bgIcon--;
                    updateIcon ( radioButton );
                }
                else
                {
                    bgTimer.stop ();
                }
            }
        } );
        mouseAdapter = new MouseAdapter ()
        {
            public void mouseEntered ( MouseEvent e )
            {
                in = true;
                bgTimer.start ();
            }

            public void mouseExited ( MouseEvent e )
            {
                in = false;
                bgTimer.start ();
            }
        };
        radioButton.addMouseListener ( mouseAdapter );

        checkTimer = new Timer ( 40, new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                if ( checking && checkIcon < CHECK_STATES.size () - 1 )
                {
                    checkIcon++;
                    updateIcon ( radioButton );
                }
                else if ( !checking && checkIcon > 0 )
                {
                    checkIcon--;
                    updateIcon ( radioButton );
                }
                else
                {
                    checkTimer.stop ();
                }
            }
        } );
        itemListener = new ItemListener ()
        {
            public void itemStateChanged ( ItemEvent e )
            {
                if ( animated )
                {
                    if ( radioButton.isSelected () )
                    {
                        checking = true;
                        checkTimer.start ();
                    }
                    else
                    {
                        checking = false;
                        checkTimer.start ();
                    }
                }
                else
                {
                    checkIcon = radioButton.isSelected () ? CHECK_STATES.size () - 1 : 0;
                    updateIcon ( radioButton );
                }
            }
        };
        radioButton.addItemListener ( itemListener );
    }

    public void uninstallUI ( JComponent c )
    {
        radioButton.removeMouseListener ( mouseAdapter );
        radioButton.removeItemListener ( itemListener );

        super.uninstallUI ( c );
    }

    private Map<String, ImageIcon> iconsCache = new HashMap<String, ImageIcon> ();

    private synchronized void updateIcon ( JRadioButton radioButton )
    {
        final String key = bgIcon + "," + checkIcon;
        if ( iconsCache.containsKey ( key ) )
        {
            radioButton.setIcon ( iconsCache.get ( key ) );
        }
        else
        {
            BufferedImage b = new BufferedImage ( BG_STATES.get ( 0 ).getIconWidth (),
                    BG_STATES.get ( 0 ).getIconHeight (), BufferedImage.TYPE_INT_ARGB );
            Graphics2D g2d = b.createGraphics ();
            g2d.drawImage ( BG_STATES.get ( bgIcon ).getImage (), 0, 0,
                    BG_STATES.get ( bgIcon ).getImageObserver () );
            g2d.drawImage ( CHECK_STATES.get ( checkIcon ).getImage (), 0, 0,
                    CHECK_STATES.get ( checkIcon ).getImageObserver () );
            g2d.dispose ();

            ImageIcon icon = new ImageIcon ( b );
            iconsCache.put ( key, icon );
            radioButton.setIcon ( icon );
        }
    }

    public boolean isAnimated ()
    {
        return animated && ( radioButton == null || radioButton.getParent () == null ||
                !( radioButton.getParent () instanceof WebListElement ||
                        radioButton.getParent () instanceof WebTreeCellRenderer.WebTreeElement ) );
    }

    public void setAnimated ( boolean animated )
    {
        this.animated = animated;
    }
}
