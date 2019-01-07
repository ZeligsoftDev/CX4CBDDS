/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.rhapsody.di;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ConnectorUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata;

/**
 * @author prismtech
 * 
 */
public class RhapsodyImportModule extends AbstractModule {

	public static final String UPDATE_LIST_BINDING = "Update List";

	public static final String TYPE_CACHE_BINDING = "Type Cache";

	public static final String RELATION_UPDATE_LIST_BINDING = "Relation Update List";

	public static final String CONNECTOR_UPDATE_LIST_BINDING = "Connector Update List";

	public static final String DEPLOYMENT_UPDATE_LIST_BINDING = "Deployment Update List";
	
	private final RhapsodyTraceabilityCache typeCache;
	private final List<ReferenceUpdateMetadata> updateRequired;
	private final List<RelationUpdateMetadata> relationUpdateRequired;
	private final List<ConnectorUpdateMetadata> connectorUpdateRequired;
	private final List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
	

	public RhapsodyImportModule() {
		typeCache = new RhapsodyTraceabilityCache();
		updateRequired = Lists.newArrayList();
		relationUpdateRequired = Lists.newArrayList();
		connectorUpdateRequired = Lists.newArrayList();
		deploymentUpdateRequired = Lists.newArrayList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(RhapsodyTraceabilityCache.class).annotatedWith(
				Names.named(TYPE_CACHE_BINDING)).toInstance(typeCache);
		bind(new TypeLiteral<List<ReferenceUpdateMetadata>>() {
		}).annotatedWith(Names.named(UPDATE_LIST_BINDING)).toInstance(
				updateRequired);
		bind(new TypeLiteral<List<RelationUpdateMetadata>>() {
		}).annotatedWith(Names.named(RELATION_UPDATE_LIST_BINDING)).toInstance(
				relationUpdateRequired);
		bind(new TypeLiteral<List<ConnectorUpdateMetadata>>() {
		}).annotatedWith(Names.named(CONNECTOR_UPDATE_LIST_BINDING))
				.toInstance(connectorUpdateRequired);
		bind(new TypeLiteral<List<DeploymentValueUpdateMetadata>>() {
		}).annotatedWith(Names.named(DEPLOYMENT_UPDATE_LIST_BINDING))
				.toInstance(deploymentUpdateRequired);		
	}

}
