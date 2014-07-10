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
package org.everit.osgi.querydsl.support;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysema.query.sql.Configuration;

/**
 * Functional interface to be able to do database operations with the help of Querydsl in the way that
 * {@link SQLException}s are handled by the exception translator of Querydsl.
 *
 * @param <R>
 *            Type of the return value
 */
@FunctionalInterface
public interface QuerydslCallable<R> {

    /**
     * Function of the functional interface.
     *
     * @param connection
     *            An opened database connection.
     * @param configuration
     *            The Querydsl configuration that should be used for Querydsl queries.
     * @return An optional return value.
     * @throws SQLException
     *             The exceptions that are thrown from the function calls of connection will be translated by Querydsl.
     */
    R call(Connection connection, Configuration configuration) throws SQLException;
}
