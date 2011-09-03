/*
 * Copyright 2011 ZerothAngel <zerothangel@tyrannyofheaven.org>
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
package org.tyrannyofheaven.bukkit.util.command;

import java.util.Arrays;

/**
 * Metadata for mapped parameters.
 * 
 * @author zerothangel
 */
final class OptionMetaData implements MethodParameter {

    private static final String DEFAULT_VALUE_NAME = "value";

    private final String[] names;

    private final String valueName;

    private final Class<?> type;
    
    private final boolean optional;
    
    /**
     * Create an OptionMetaData.
     * 
     * @param names the name of the mapping along with any aliases
     * @param type the parameter type
     * @param optional true if optional
     */
    public OptionMetaData(String[] names, String valueName, Class<?> type, boolean optional) {
        if (names == null || names.length == 0)
            throw new IllegalArgumentException("names must be given");
        if (valueName == null || valueName.trim().length() == 0)
            valueName = DEFAULT_VALUE_NAME;
        if (type == null)
            throw new IllegalArgumentException("type cannot be null");

        this.names = Arrays.copyOf(names, names.length);
        this.valueName = valueName;
        this.type = type;
        this.optional = optional;
    }

    /**
     * Returns the primary name of the option.
     * 
     * @return the primary name
     */
    public String getName() {
        return names[0];
    }

    /**
     * Returns all names of the option.
     * 
     * @return all names of the option
     */
    public String[] getNames() {
        return names;
    }

    /**
     * Returns the name of the value (for the usage string).
     * 
     * @return the value name
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * Returns the type of the option.
     * 
     * @return the type of the option
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * Returns whether or not the option is optional.
     * 
     * @return true if optional
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * Returns whether or not the option is a flag or a positional parameter.
     * 
     * @return true if a positional parameter, false if a flag
     */
    public boolean isArgument() {
        return isArgument(getName());
    }

    /**
     * Returns whether or not an option with the given name is a flag or a
     * positional parameter.
     * 
     * @return true if a positional parameter, false if a flag
     */
    public static boolean isArgument(String name) {
        return !name.startsWith("-");
    }

}
