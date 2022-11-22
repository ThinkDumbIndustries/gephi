/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */

package org.gephi.desktop.banner;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import org.gephi.perspective.api.PerspectiveController;
import org.gephi.perspective.spi.Perspective;
import org.gephi.ui.utils.UIUtils;
import org.openide.util.Lookup;

/**
 * @author Mathieu Bastian
 */
public class BannerComponent extends javax.swing.JPanel {

    private final transient PerspectiveController perspectiveController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.ButtonGroup perspectivesButtonGroup;
    private javax.swing.JPanel workspacePanel;
    // End of variables declaration//GEN-END:variables

    public BannerComponent() {
        initComponents();

        // Make the workspace tab stand out well
        if (UIUtils.isFlatLafLightLookAndFeel()) {
            mainPanel.setBackground(Color.WHITE);
            workspacePanel.setBackground(Color.WHITE);
        } else if (UIUtils.isFlatLafDarkLookAndFeel()) {
            Color cl = UIManager.getColor("EditorTab.background");
            mainPanel.setBackground(cl);
            workspacePanel.setBackground(cl);
        }

        // Button panel border so it matches with the workspace panel
        buttonsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, UIManager.getColor("Component.borderColor")),
            BorderFactory.createEmptyBorder(6, 0, 6, 5)));
        workspacePanel.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));

        //Init perspective controller
        perspectiveController = Lookup.getDefault().lookup(PerspectiveController.class);

        addGroupTabs();
    }

    private void addGroupTabs() {
        JToggleButton[] buttons = new JToggleButton[perspectiveController.getPerspectives().length];
        int i = 0;

        //Add tabs
        for (final Perspective perspective : perspectiveController.getPerspectives()) {
            JToggleButton toggleButton =
                new JToggleButton(perspective.getDisplayName(), perspective.getIcon());
            toggleButton.setFocusPainted(false);
            toggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            toggleButton.addActionListener(e -> perspectiveController.selectPerspective(perspective));
            perspectivesButtonGroup.add(toggleButton);
            buttonsPanel.add(toggleButton);
            buttons[i++] = toggleButton;
        }

        //Set currently selected button
        perspectivesButtonGroup.setSelected(buttons[getSelectedPerspectiveIndex()].getModel(), true);
    }

    public int getSelectedPerspectiveIndex() {
        int i = 0;
        for (Perspective p : perspectiveController.getPerspectives()) {
            if (p.equals(perspectiveController.getSelectedPerspective())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        perspectivesButtonGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        workspacePanel = new org.gephi.desktop.banner.workspace.WorkspacePanel();
        buttonsPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setLayout(new java.awt.BorderLayout());

        workspacePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 0, 0, 0));
        mainPanel.add(workspacePanel, java.awt.BorderLayout.CENTER);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 6, 0));
        mainPanel.add(buttonsPanel, java.awt.BorderLayout.WEST);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
}
