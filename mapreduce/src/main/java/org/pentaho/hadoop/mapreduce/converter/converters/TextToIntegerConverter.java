/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2019 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.hadoop.mapreduce.converter.converters;

import org.apache.hadoop.io.Text;
import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.hadoop.mapreduce.converter.TypeConversionException;
import org.pentaho.hadoop.mapreduce.converter.TypeConverterFactory;
import org.pentaho.hadoop.mapreduce.converter.spi.ITypeConverter;

/**
 * Converts {@link Text} objects to {@link Integer} objects
 */
public class TextToIntegerConverter implements ITypeConverter<Text, Integer> {
  @Override
  public boolean canConvert( Class from, Class to ) {
    return Text.class.equals( from ) && Integer.class.equals( to );
  }

  @Override
  public Integer convert( ValueMetaInterface meta, Text obj ) throws TypeConversionException {
    try {
      return Integer.parseInt( obj.toString() );
    } catch ( NumberFormatException ex ) {
      throw new TypeConversionException(
        BaseMessages.getString( TypeConverterFactory.class, "ErrorConverting", Integer.class.getSimpleName(), obj ),
        ex );
    }
  }
}
