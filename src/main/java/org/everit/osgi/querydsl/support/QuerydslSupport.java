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

/**
 * An OSGi service that implements this interface can be used to write less codes and have less references in the
 * components that do database operations based on Querydsl.
 *
 * Programmers who use this service should implement {@link QuerydslCallable} interface. That is a functional interface
 * so it can be used with lambda expressions.
 *
 */
public interface QuerydslSupport {

    /**
     * Executing the callback implementation in the way that SQLExceptions are translated by Querydsl.
     *
     * @param callable
     *            The functional interface that should be implemented by the programmer.
     * @param <R>
     *            The type of an optional return value.
     * @return An optional return value.
     */
    <R> R execute(QuerydslCallable<R> callable);
}
