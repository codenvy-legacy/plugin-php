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
package com.codenvy.ide.ext.php.server.project;

import com.codenvy.api.core.ConflictException;
import com.codenvy.api.core.ForbiddenException;
import com.codenvy.api.core.ServerException;
import com.codenvy.api.project.server.Project;
import com.codenvy.api.project.server.ValueProviderFactory;
import com.codenvy.api.project.shared.InvalidValueException;
import com.codenvy.api.project.shared.ValueProvider;
import com.codenvy.api.project.shared.ValueStorageException;
import com.codenvy.ide.ext.php.server.project.generator.DefaultTemplateGenerator;
import com.codenvy.ide.ext.php.shared.ProjectAttributes;
import com.google.inject.Singleton;

import java.util.Collections;
import java.util.List;

/** @author Vladyslav Zhukovskii */
@Singleton
public class TemplateContentValueProviderFactory implements ValueProviderFactory {

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return ProjectAttributes.PHP_PROJECT_TEMPLATE;
    }

    /** {@inheritDoc} */
    @Override
    public ValueProvider newInstance(final Project project) {
        return new ValueProvider() {
            @Override
            public List<String> getValues() throws ValueStorageException {
                return Collections.emptyList();
            }

            @Override
            public void setValues(List<String> value) throws ValueStorageException, InvalidValueException {
                if (!value.isEmpty() && ProjectAttributes.PHP_DEFAULT_TEMPLATE.equals(value.get(0))) {
                    try {
                        DefaultTemplateGenerator.generateTemplate(project.getBaseFolder());
                    } catch (ConflictException | ServerException | ForbiddenException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        };
    }
}
