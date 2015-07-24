/*
 * Copyright (C) 2011 Everit Kft. (http://everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.querydsl.support;

/**
 * Constants that make it possible to configure the Support component programmatically.
 */
public final class QuerydslSupportConstants {

  /**
   * OSGi service filter for the Querydsl configuration service.
   */
  public static final String PROP_CONFIGURATION_TARGET = "configuration.target";

  /**
   * OGSi service filter for the DataSource.
   */
  public static final String PROP_DATASOURCE_TARGET = "dataSource.target";

  /**
   * The name of the component.
   */
  public static final String SERVICE_FACTORYPID_QUERYDSL_SUPPORT = "org.everit.osgi.querydsl.support.QuerydslSupport";

  private QuerydslSupportConstants() {
  }
}
