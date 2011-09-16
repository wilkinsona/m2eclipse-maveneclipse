/*
 * Copyright 2000-2011 the original author or authors.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.m2e.maveneclipse.handler.additionalprojectfacets;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2e.maveneclipse.MavenEclipseContext;
import org.eclipse.m2e.maveneclipse.configuration.ConfigurationParameter;
import org.eclipse.m2e.maveneclipse.handler.ConfigurationHandler;
import org.eclipse.m2e.maveneclipse.handler.SingleParameterConfigurationHandler;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IFacetedProject.Action;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;

/**
 * A {@link ConfigurationHandler} that deals with <tt>additionalProjectFacets</tt> from the
 * <tt>maven-eclipse-plugin</tt> configuration.
 * 
 * @author Alex Clarke
 * @author Phillip Webb
 */
public class AdditionalProjectFacetsConfigurationHandler extends SingleParameterConfigurationHandler {

	@Override
	protected String getParamterName() {
		return "additionalProjectFacets";
	}

	@Override
	protected void handle(MavenEclipseContext context, ConfigurationParameter parameter) throws Exception {
		Set<Action> actions = new LinkedHashSet<IFacetedProject.Action>();
		for (ConfigurationParameter child : parameter.getChildren()) {
			IProjectFacet facet;
			try {
				facet = ProjectFacetsManager.getProjectFacet(child.getName());
			} catch (IllegalAccessError e) {
				facet = null;
			}
			if (facet != null) {
				IProjectFacetVersion projectFacetVersion = facet.getVersion(child.getValue());
				actions.add(new IFacetedProject.Action(IFacetedProject.Action.Type.INSTALL, projectFacetVersion, null));
			}
		}
		if (actions.size() > 0) {
			IFacetedProject facetedProject = createFacetedProject(context.getProject());
			facetedProject.modify(actions, context.getMonitor());
		}
	}

	protected IFacetedProject createFacetedProject(IProject project) throws CoreException {
		return ProjectFacetsManager.create(project);
	}
}