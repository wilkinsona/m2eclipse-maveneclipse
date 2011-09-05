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
package org.eclipse.m2e.maveneclipse.configuration;

/**
 * Provides access to <tt>pom.xml</tt> configuration defined for the <tt>maven-eclipse-plugin</tt>.
 * 
 * @author Alex Clarke
 * @author Phillip Webb
 */
public interface MavenEclipseConfiguration {

	/**
	 * Return a single configuration parameter from the configuration.
	 * 
	 * @param name the name of the parameter
	 * @return the configuration paramter or <tt>null</tt> if no paramter is defined.
	 */
	ConfigurationParameter getParamter(String name);

	/**
	 * Determines if the configuration contains the specifed paramter.
	 * 
	 * @param name the name of the paramter
	 * @return <tt>true</tt> if {@link #getParamter(String)} returns a <tt>non-null</tt> result.
	 */
	boolean containsParamter(String name);
}