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
package com.codenvy.ide.ext.php.server.project.generator;

import com.codenvy.api.core.ConflictException;
import com.codenvy.api.core.ForbiddenException;
import com.codenvy.api.core.ServerException;
import com.codenvy.api.project.server.FolderEntry;
import com.codenvy.api.project.server.ProjectGenerator;
import com.google.inject.Singleton;

import java.util.Map;

/** @author Vladyslav Zhukovskii */
@Singleton
public class SimpleProjectGenerator implements ProjectGenerator {

    private static final String CONTENT = "<!DOCTYPE html>\n" +
                                          "<html lang=\"en\">\n" +
                                          "\t<head>\n" +
                                          "\t\t<meta charset=\"utf-8\">\n" +
                                          "\t\t<title>Hello World!</title>\n" +
                                          "\t</head>\n" +
                                          "\t<body>\n" +
                                          "\t\t<h3>Variables dump:</h3>\n" +
                                          "\t\t<pre><?=var_dump(get_defined_vars());?></pre>\n" +
                                          "\t</body>\n" +
                                          "</html>";

    @Override
    public String getId() {
        return "php-simple";
    }

    @Override
    public void generateProject(FolderEntry baseFolder, Map<String, String> options)
            throws ForbiddenException, ConflictException, ServerException {
        baseFolder.createFile("index.php", CONTENT.getBytes(), "text/php");
    }
}
