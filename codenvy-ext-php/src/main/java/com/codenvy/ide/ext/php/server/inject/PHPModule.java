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
package com.codenvy.ide.ext.php.server.inject;

import com.codenvy.api.project.server.ProjectGenerator;
import com.codenvy.ide.ext.php.server.project.generator.SimpleProjectGenerator;
import com.codenvy.ide.ext.php.server.project.type.PHPProjectTypeDescriptionExtension;
import com.codenvy.ide.ext.php.server.project.type.PHPProjectTypeExtension;
import com.codenvy.inject.DynaModule;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/** @author Vladyslav Zhukovskii */
@DynaModule
public class PHPModule extends AbstractModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
        bind(PHPProjectTypeExtension.class);
        bind(PHPProjectTypeDescriptionExtension.class);

        Multibinder<ProjectGenerator> multiBinder = Multibinder.newSetBinder(binder(), ProjectGenerator.class);
        multiBinder.addBinding().to(SimpleProjectGenerator.class);
    }
}
