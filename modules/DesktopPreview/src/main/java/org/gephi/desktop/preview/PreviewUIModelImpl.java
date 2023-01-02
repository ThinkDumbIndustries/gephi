/*
Copyright 2008-2011 Gephi
Authors : Mathieu Bastian
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

package org.gephi.desktop.preview;

import java.util.Arrays;
import java.util.Optional;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.gephi.desktop.preview.api.PreviewUIController;
import org.gephi.desktop.preview.api.PreviewUIModel;
import org.gephi.preview.api.PreviewModel;
import org.gephi.preview.api.PreviewPreset;
import org.gephi.preview.presets.BlackBackground;
import org.gephi.preview.presets.DefaultPreset;
import org.gephi.project.api.Workspace;
import org.gephi.ui.utils.UIUtils;
import org.openide.util.Lookup;

/**
 * @author Mathieu Bastian
 */
public class PreviewUIModelImpl implements PreviewUIModel {

    private final PreviewModel previewModel;
    //Data
    private float visibilityRatio = 1f;
    private PreviewPreset currentPreset;
    private boolean refreshing;

    public PreviewUIModelImpl(PreviewModel model) {
        previewModel = model;

        if (UIUtils.isDarkLookAndFeel()) {
            currentPreset = new BlackBackground();
        } else {
            currentPreset = new DefaultPreset();
        }
        model.getProperties().applyPreset(currentPreset);
    }

    @Override
    public PreviewModel getPreviewModel() {
        return previewModel;
    }

    @Override
    public Workspace getWorkspace() {
        return previewModel.getWorkspace();
    }

    @Override
    public PreviewPreset getCurrentPreset() {
        return currentPreset;
    }

    public void setCurrentPreset(PreviewPreset preset) {
        currentPreset = preset;
    }

    @Override
    public float getVisibilityRatio() {
        return visibilityRatio;
    }

    public void setVisibilityRatio(float visibilityRatio) {
        this.visibilityRatio = visibilityRatio;
    }

    @Override
    public boolean isRefreshing() {
        return refreshing;
    }

    public void setRefreshing(boolean refreshing) {
        this.refreshing = refreshing;
    }

    private void setCurrentPresetBasedOnString(String className, String displayName) {
        // Retrieve preset, either default (by class) or user (by name)
        PreviewUIController controller = Lookup.getDefault().lookup(PreviewUIController.class);
        PreviewPreset[] defaultPresets = controller.getDefaultPresets();
        Optional<PreviewPreset> preset =
            Arrays.stream(defaultPresets).filter(p -> p.getClass().getName().equals(className)).findFirst();
        if (preset.isPresent()) {
            setCurrentPreset(preset.get());
        } else {
            PreviewPreset[] userPresets = controller.getUserPresets();
            preset = Arrays.stream(userPresets).filter(p -> p.getName().equals(displayName)).findFirst();
            preset.ifPresent(this::setCurrentPreset);
        }
    }

    protected void writeXML(XMLStreamWriter writer) throws XMLStreamException {
        if (currentPreset != null) {
            writer.writeStartElement("currentpreset");
            writer.writeAttribute("class", currentPreset.getClass().getName());
            writer.writeAttribute("name", currentPreset.getName());
            writer.writeEndElement();
        }
        writer.writeStartElement("visibilityratio");
        writer.writeAttribute("value", visibilityRatio + "");
        writer.writeEndElement();
    }

    protected void readXML(XMLStreamReader reader) throws XMLStreamException {
        boolean end = false;
        while (reader.hasNext() && !end) {
            int type = reader.next();

            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    String name = reader.getLocalName();
                    if ("currentpreset".equalsIgnoreCase(name)) {
                        String presetClass = reader.getAttributeValue(null, "class");
                        String presetName = reader.getAttributeValue(null, "name");

                        setCurrentPresetBasedOnString(presetClass, presetName);
                    } else if ("visibilityratio".equalsIgnoreCase(name)) {
                        String value = reader.getAttributeValue(null, "value");
                        visibilityRatio = Float.parseFloat(value);
                    }
                    break;
                case XMLStreamReader.CHARACTERS:
                    break;
                case XMLStreamReader.END_ELEMENT:
                    if ("previewuimodel".equalsIgnoreCase(reader.getLocalName())) {
                        end = true;
                    }
                    break;
            }
        }
    }
}
