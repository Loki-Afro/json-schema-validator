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

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class AbstractDateFormatValidator
    extends AbstractValidator
{
    private final SimpleDateFormat format;
    private final String errmsg;

    protected AbstractDateFormatValidator(final String fmt, final String desc)
    {
        format = new SimpleDateFormat(fmt);
        errmsg = String.format("value is not a valid %s", desc);
    }

    @Override
    protected final boolean doValidate(final JsonNode node)
    {
        try {
            format.parse(node.getTextValue());
            return true;
        } catch (ParseException e) {
            messages.add(errmsg);
            return false;
        }
    }
}
