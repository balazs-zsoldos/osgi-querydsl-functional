/**
 * This file is part of Everit - QueryDSL Support.
 *
 * Everit - QueryDSL Support is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - QueryDSL Support is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - QueryDSL Support.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.querydsl.support.internal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.everit.osgi.querydsl.support.QuerydslCallable;
import org.everit.osgi.querydsl.support.QuerydslSupport;
import org.everit.osgi.querydsl.support.QuerydslSupportConstants;

import com.mysema.query.sql.Configuration;

/**
 * Simple component that registers {@link QuerydslSupport} as an OSGi service.
 */
@Component(name = QuerydslSupportConstants.SERVICE_FACTORYPID_QUERYDSL_SUPPORT, metatype = true,
        configurationFactory = true, policy = ConfigurationPolicy.REQUIRE)
@Properties({ @Property(name = QuerydslSupportConstants.PROP_DATASOURCE_TARGET),
        @Property(name = QuerydslSupportConstants.PROP_CONFIGURATION_TARGET) })
@Service
public class QuerydslSupportComponent implements QuerydslSupport {

    /**
     * Querydsl configuration.
     */
    @Reference
    private Configuration configuration;

    /**
     * DataSource for database connections.
     */
    @Reference
    private DataSource dataSource;

    public void bindConfiguration(final Configuration configuration) {
        this.configuration = configuration;
    }

    public void bindDataSource(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <R> R execute(final QuerydslCallable<R> callable) {
        try (Connection connection = dataSource.getConnection()) {
            callable.call(connection, configuration);
        } catch (SQLException e) {
            throw configuration.translate(e);
        }
        return null;
    }
}
