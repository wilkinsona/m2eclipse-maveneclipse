/*
 * Copyright 2000-2011 the original author or authors.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.m2e.maveneclipse;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.maveneclipse.configuration.MavenEclipseConfiguration;

/**
 * Default implementation of {@link MavenEclipseContext}.
 * 
 * @author Alex Clarke
 * @author Phillip Webb
 */
public class DefaultMavenEclipseContext implements MavenEclipseContext {

	private MavenEclipseConfiguration configuration;

	/**
	 * Create a new {@link DefaultMavenEclipseContext} instance.
	 * @param configuration
	 */
	public DefaultMavenEclipseContext(MavenEclipseConfiguration configuration) {
		if (configuration == null) {
			throw new IllegalArgumentException("Configuration must not be null");
		}
		this.configuration = configuration;
	}

	public MavenEclipseConfiguration getConfiguration() {
		return configuration;
	}

	public IProject getProject() {
		//FIXME
		return null;
	}

	public IProgressMonitor getProgressMonitor() {
		//FIXME
		return null;
	}

	public MavenProject getMavenProject() {
		//FIXME
		return null;
	}
}