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
import com.google.inject.Singleton;

/** @author Vladyslav Zhukovskii */
@Singleton
public class DefaultTemplateGenerator {

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

    public static void generateTemplate(FolderEntry baseFolder) throws ConflictException, ServerException, ForbiddenException {
        baseFolder.createFile("index.php", CONTENT.getBytes(), "text/php");
    }

    private DefaultTemplateGenerator() {}
}
