/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.php.server.project.type;

import com.codenvy.api.project.server.ProjectTypeDescriptionRegistry;
import com.codenvy.api.project.server.ProjectTypeExtension;
import com.codenvy.api.project.shared.Attribute;
import com.codenvy.api.project.shared.ProjectTemplateDescription;
import com.codenvy.api.project.shared.ProjectType;
import com.codenvy.ide.Constants;
import com.codenvy.ide.ext.php.shared.ProjectAttributes;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/** @author Vladyslav Zhukovskii */
@Singleton
public class PHPProjectTypeExtension implements ProjectTypeExtension {
    private final ProjectType projectType;

    @Inject
    public PHPProjectTypeExtension(ProjectTypeDescriptionRegistry registry) {
        this.projectType = new ProjectType(ProjectAttributes.PHP_ID, ProjectAttributes.PHP_NAME, ProjectAttributes.PHP_CATEGORY, null,
                                           ProjectAttributes.PHP_DEFAULT_RUNNER);
        registry.registerProjectType(projectType);
    }

    /** {@inheritDoc} */
    @Override
    public ProjectType getProjectType() {
        return projectType;
    }

    /** {@inheritDoc} */
    @Override
    public List<Attribute> getPredefinedAttributes() {
        final List<Attribute> list = new ArrayList<>(1);
        list.add(new Attribute(Constants.LANGUAGE, ProjectAttributes.PHP_ID));
        return list;
    }

    /** {@inheritDoc} */
    @Override
    public List<ProjectTemplateDescription> getTemplates() {
        return Collections.emptyList();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, String> getIconRegistry() {
        return null;
    }
}
