/*
Copyright 2008-2011 Gephi
Authors : Taras Klaskovsky <megaterik@gmail.com>
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

package org.gephi.ui.exporter.preview;

import org.gephi.io.exporter.preview.PNGExporter;
import org.gephi.lib.validation.ValidationClient;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

public class UIExporterPNGPanel extends javax.swing.JPanel implements ValidationClient {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JLabel labelHpx;
    private javax.swing.JLabel labelMargin;
    private javax.swing.JLabel labelMperc;
    private javax.swing.JLabel labelWpx;
    private javax.swing.JTextField marginTextField;
    private javax.swing.JCheckBox transparentBackgroundCheckbox;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

    public UIExporterPNGPanel() {
        initComponents();
    }

    public static ValidationPanel createValidationPanel(UIExporterPNGPanel innerPanel) {
        ValidationPanel validationPanel = new ValidationPanel();
        validationPanel.setInnerComponent(innerPanel);

        ValidationGroup group = validationPanel.getValidationGroup();
        innerPanel.validate(group);

        return validationPanel;
    }

    void setup(PNGExporter exporter) {
        heightTextField.setText(Integer.toString(exporter.getHeight()));
        widthTextField.setText(Integer.toString(exporter.getWidth()));
        marginTextField.setText(Integer.toString(exporter.getMargin()));
        transparentBackgroundCheckbox.setSelected(exporter.isTransparentBackground());
    }

    void unsetup(PNGExporter exporter) {
        try {
            exporter.setWidth(Integer.parseInt(widthTextField.getText()));
            exporter.setHeight(Integer.parseInt(heightTextField.getText()));
            exporter.setMargin(Integer.parseInt(marginTextField.getText()));
            exporter.setTransparentBackground(transparentBackgroundCheckbox.isSelected());
        } catch (Exception ex) {
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        widthTextField = new javax.swing.JTextField();
        heightTextField = new javax.swing.JTextField();
        widthLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        labelWpx = new javax.swing.JLabel();
        labelHpx = new javax.swing.JLabel();
        labelMargin = new javax.swing.JLabel();
        marginTextField = new javax.swing.JTextField();
        labelMperc = new javax.swing.JLabel();
        transparentBackgroundCheckbox = new javax.swing.JCheckBox();

        widthTextField.setName("width"); // NOI18N

        heightTextField.setName("height"); // NOI18N

        widthLabel.setText(org.openide.util.NbBundle
            .getMessage(UIExporterPNGPanel.class, "UIExporterPNGPanel.widthLabel.text")); // NOI18N

        heightLabel.setText(org.openide.util.NbBundle
            .getMessage(UIExporterPNGPanel.class, "UIExporterPNGPanel.heightLabel.text")); // NOI18N

        labelWpx.setText("px");

        labelHpx.setText("px");

        labelMargin.setText("Margin:");

        marginTextField.setName("margin"); // NOI18N

        labelMperc.setText("% of width");

        transparentBackgroundCheckbox.setText("Transparent background");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(widthLabel)
                                .addGap(16, 16, 16)
                                .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelWpx)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(labelMargin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(marginTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(heightLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMperc)
                                    .addComponent(labelHpx))))
                        .addComponent(transparentBackgroundCheckbox))
                    .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(widthLabel)
                        .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelWpx))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(heightLabel)
                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelHpx))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMargin)
                        .addComponent(marginTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMperc))
                    .addGap(18, 18, 18)
                    .addComponent(transparentBackgroundCheckbox)
                    .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void validate(ValidationGroup group) {
        group.add(widthTextField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER,
            StringValidators.numberRange(1, Integer.MAX_VALUE));
        group.add(heightTextField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER,
            StringValidators.numberRange(1, Integer.MAX_VALUE));
        group.add(marginTextField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER,
            StringValidators.numberRange(0, 100));
    }
}
