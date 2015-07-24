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
package org.everit.osgi.querydsl.support.ri;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.everit.osgi.querydsl.support.QuerydslCallable;
import org.everit.osgi.querydsl.support.QuerydslSupport;

import com.querydsl.sql.Configuration;

/**
 * Simple component that registers {@link QuerydslSupport} as an OSGi service.
 */
public class QuerydslSupportComponent implements QuerydslSupport {

  /**
   * Querydsl configuration.
   */
  private final Configuration configuration;

  /**
   * DataSource for database connections.
   */
  private final DataSource dataSource;

  public QuerydslSupportComponent(Configuration configuration, DataSource dataSource) {
    super();
    this.configuration = configuration;
    this.dataSource = dataSource;
  }

  @Override
  public <R> R execute(final QuerydslCallable<R> callable) {
    try (Connection connection = dataSource.getConnection()) {
      return callable.call(connection, configuration);
    } catch (SQLException e) {
      throw configuration.translate(e);
    }
  }
}
