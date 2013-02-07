/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.gora.persistency;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericArray;
import org.apache.avro.generic.GenericData;

import java.util.ArrayList;
import java.util.Collections;

/**
 * An {@link ArrayList} based implementation of Avro {@link GenericArray}.
 */
public class ListGenericArray<T> extends ArrayList<T> implements GenericArray<T>
  , Comparable<ListGenericArray<T>> {

  private static final int LIST_DEFAULT_SIZE = 10;

  private Schema schema;

  public ListGenericArray(Schema schema) {
    this(LIST_DEFAULT_SIZE, schema);
  }

  public ListGenericArray(int size, Schema schema) {
    this.schema = schema;
    this.ensureCapacity(size);
  }

  @Override
  public T peek() {
    return null;
  }

  @Override
  public void reverse() {
      Collections.reverse(this);
  }

  @Override
  public Schema getSchema() {
    return schema;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ListGenericArray)) return false;
    ListGenericArray that = (ListGenericArray)obj;
    if (!schema.equals(that.schema))
      return false;
    return this.compareTo(that) == 0;
  }

  @Override
  public int compareTo(ListGenericArray<T> o) {
    return GenericData.get().compare(this, o, schema);
  }
}
