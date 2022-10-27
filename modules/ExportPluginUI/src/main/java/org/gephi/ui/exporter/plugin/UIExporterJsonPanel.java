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

package org.gephi.ui.exporter.plugin;

import javax.swing.DefaultComboBoxModel;
import org.gephi.io.exporter.plugin.ExporterGEXF;
import org.gephi.io.exporter.plugin.ExporterJson;

/**
 * @author Mathieu Bastian
 */
public class UIExporterJsonPanel extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox attributesExportCheckbox;
    private javax.swing.JCheckBox colorsExportCheckbox;
    private javax.swing.JCheckBox dynamicExportCheckbox;
    private javax.swing.JComboBox<String> formatCombo;
    private javax.swing.JLabel labelExport;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelNormalize;
    private javax.swing.JCheckBox normalizeCheckbox;
    private javax.swing.JCheckBox positionExportCheckbox;
    private javax.swing.JCheckBox prettyPrintCheckbox;
    private javax.swing.JCheckBox sizeExportCheckbox;
    // End of variables declaration//GEN-END:variables

    public UIExporterJsonPanel() {
        initComponents();
        
        DefaultComboBoxModel comboBoxModel =
                new DefaultComboBoxModel(ExporterJson.Format.values());
        formatCombo.setModel(comboBoxModel);
    }

    public void setup(ExporterJson exporterJson) {
        formatCombo.setSelectedItem(exporterJson.getFormat());
        colorsExportCheckbox.setSelected(exporterJson.isExportColors());
        positionExportCheckbox.setSelected(exporterJson.isExportPosition());
        sizeExportCheckbox.setSelected(exporterJson.isExportSize());
        attributesExportCheckbox.setSelected(exporterJson.isExportAttributes());
        normalizeCheckbox.setSelected(exporterJson.isNormalize());
        dynamicExportCheckbox.setSelected(exporterJson.isExportDynamic());
        prettyPrintCheckbox.setSelected(exporterJson.isPrettyPrint());
    }

    public void unsetup(ExporterJson exporterJson) {
        exporterJson.setFormat((ExporterJson.Format)formatCombo.getSelectedItem());
        exporterJson.setExportAttributes(attributesExportCheckbox.isSelected());
        exporterJson.setExportColors(colorsExportCheckbox.isSelected());
        exporterJson.setExportSize(sizeExportCheckbox.isSelected());
        exporterJson.setExportPosition(positionExportCheckbox.isSelected());
        exporterJson.setNormalize(normalizeCheckbox.isSelected());
        exporterJson.setExportDynamic(dynamicExportCheckbox.isSelected());
        exporterJson.setPrettyPrint(prettyPrintCheckbox.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelExport = new javax.swing.JLabel();
        positionExportCheckbox = new javax.swing.JCheckBox();
        colorsExportCheckbox = new javax.swing.JCheckBox();
        attributesExportCheckbox = new javax.swing.JCheckBox();
        sizeExportCheckbox = new javax.swing.JCheckBox();
        labelNormalize = new javax.swing.JLabel();
        normalizeCheckbox = new javax.swing.JCheckBox();
        dynamicExportCheckbox = new javax.swing.JCheckBox();
        prettyPrintCheckbox = new javax.swing.JCheckBox();
        labelFormat = new javax.swing.JLabel();
        formatCombo = new javax.swing.JComboBox<>();

        labelExport.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.labelExport.text")); // NOI18N

        positionExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.positionExportCheckbox.text")); // NOI18N

        colorsExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.colorsExportCheckbox.text")); // NOI18N

        attributesExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.attributesExportCheckbox.text")); // NOI18N

        sizeExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.sizeExportCheckbox.text")); // NOI18N

        labelNormalize.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelNormalize.setForeground(new java.awt.Color(102, 102, 102));
        labelNormalize.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.labelNormalize.text")); // NOI18N

        normalizeCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.normalizeCheckbox.text")); // NOI18N

        dynamicExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.dynamicExportCheckbox.text")); // NOI18N

        prettyPrintCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.prettyPrintCheckbox.text")); // NOI18N

        labelFormat.setText(org.openide.util.NbBundle.getMessage(UIExporterJsonPanel.class, "UIExporterJsonPanel.labelFormat.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(normalizeCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNormalize, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelExport)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(attributesExportCheckbox)
                                    .addComponent(sizeExportCheckbox)
                                    .addComponent(colorsExportCheckbox)
                                    .addComponent(positionExportCheckbox)
                                    .addComponent(dynamicExportCheckbox)))
                            .addComponent(prettyPrintCheckbox)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelFormat)
                                .addGap(18, 18, 18)
                                .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFormat)
                    .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExport)
                    .addComponent(positionExportCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorsExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sizeExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attributesExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dynamicExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalizeCheckbox)
                    .addComponent(labelNormalize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prettyPrintCheckbox)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents
}
