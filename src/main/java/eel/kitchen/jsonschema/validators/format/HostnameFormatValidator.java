/*
 * Copyright (c) 2011, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package eel.kitchen.jsonschema.validators.format;

import eel.kitchen.jsonschema.validators.AbstractValidator;
import org.codehaus.jackson.JsonNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HostnameFormatValidator
    extends AbstractValidator
{
    private static final Pattern hostnamePart
        = Pattern.compile("^[a-z0-9]+(-[a-z0-9]+)*$", Pattern.CASE_INSENSITIVE);

    @Override
    protected boolean doValidate(final JsonNode node)
    {
        final String value = node.getTextValue();
        final String[] parts = value.split("\\.");
        Matcher matcher;

        for (final String part: parts) {
            matcher = hostnamePart.matcher(part);
            if (!matcher.matches()) {
                messages.add("string is not a valid hostname");
                return false;
            }
        }

        return true;
    }
}
