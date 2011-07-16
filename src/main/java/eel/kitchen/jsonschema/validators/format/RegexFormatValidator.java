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
import eel.kitchen.util.RhinoHelper;
import org.codehaus.jackson.JsonNode;

public final class RegexFormatValidator
    extends AbstractValidator
{
    @Override
    protected boolean doValidate(final JsonNode node)
    {
        if (RhinoHelper.regexIsValid(node.getTextValue()))
            return true;

        messages.add("input is not a valid regular expression");
        return false;
    }
}
