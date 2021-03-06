package org.apache.gora.examples.generated;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.gora.persistency.StateManager;
import org.apache.gora.persistency.impl.PersistentBase;
import org.apache.gora.persistency.impl.StateManagerImpl;

@SuppressWarnings("all")
public class TokenDatum extends PersistentBase {
  public static final Schema _SCHEMA = Schema.parse("{\"type\":\"record\",\"name\":\"TokenDatum\",\"namespace\":\"org.apache.gora.examples.generated\",\"fields\":[{\"name\":\"count\",\"type\":\"int\"}]}");
  public static enum Field {
    COUNT(0,"count"),
    ;
    private int index;
    private String name;
    Field(int index, String name) {this.index=index;this.name=name;}
    public int getIndex() {return index;}
    public String getName() {return name;}
    public String toString() {return name;}
  };
  public static final String[] _ALL_FIELDS = {"count",};
  static {
    PersistentBase.registerFields(TokenDatum.class, _ALL_FIELDS);
  }
  private int count;
  public TokenDatum() {
    this(new StateManagerImpl());
  }
  public TokenDatum(StateManager stateManager) {
    super(stateManager);
  }
  public TokenDatum newInstance(StateManager stateManager) {
    return new TokenDatum(stateManager);
  }
  public Schema getSchema() { return _SCHEMA; }
  public Object get(int _field) {
    switch (_field) {
    case 0: return count;
    default: throw new AvroRuntimeException("Bad index");
    }
  }
  @SuppressWarnings(value="unchecked")
  public void put(int _field, Object _value) {
    if(isFieldEqual(_field, _value)) return;
    getStateManager().setDirty(this, _field);
    switch (_field) {
    case 0:count = (Integer)_value; break;
    default: throw new AvroRuntimeException("Bad index");
    }
  }
  public int getCount() {
    return (Integer) get(0);
  }
  public void setCount(int value) {
    put(0, value);
  }
}
