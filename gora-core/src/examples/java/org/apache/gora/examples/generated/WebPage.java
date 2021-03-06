package org.apache.gora.examples.generated;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericArray;
import org.apache.avro.util.Utf8;
import org.apache.gora.persistency.ListGenericArray;
import org.apache.gora.persistency.StateManager;
import org.apache.gora.persistency.StatefulHashMap;
import org.apache.gora.persistency.impl.PersistentBase;
import org.apache.gora.persistency.impl.StateManagerImpl;

import java.nio.ByteBuffer;
import java.util.Map;

@SuppressWarnings("all")
public class WebPage extends PersistentBase {
  public static final Schema _SCHEMA = new Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WebPage\",\"namespace\":\"org.apache.gora.examples.generated\",\"fields\":[{\"name\":\"url\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"bytes\"},{\"name\":\"parsedContent\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"outlinks\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"Metadata\",\"fields\":[{\"name\":\"version\",\"type\":\"int\"},{\"name\":\"data\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}}]}");
  public static enum Field {
    URL(0,"url"),
    CONTENT(1,"content"),
    PARSED_CONTENT(2,"parsedContent"),
    OUTLINKS(3,"outlinks"),
    METADATA(4,"metadata"),
    ;
    private int index;
    private String name;
    Field(int index, String name) {this.index=index;this.name=name;}
    public int getIndex() {return index;}
    public String getName() {return name;}
    public String toString() {return name;}
  };
  public static final String[] _ALL_FIELDS = {"url","content","parsedContent","outlinks","metadata",};
  static {
    PersistentBase.registerFields(WebPage.class, _ALL_FIELDS);
  }
  private Utf8 url;
  private ByteBuffer content;
  private GenericArray<Utf8> parsedContent;
  private Map<Utf8,Utf8> outlinks;
  private Metadata metadata;
  public WebPage() {
    this(new StateManagerImpl());
  }
  public WebPage(StateManager stateManager) {
    super(stateManager);
    parsedContent = new ListGenericArray<Utf8>(getSchema().getField("parsedContent").schema());
    outlinks = new StatefulHashMap<Utf8,Utf8>();
  }
  public WebPage newInstance(StateManager stateManager) {
    return new WebPage(stateManager);
  }
  public Schema getSchema() { return _SCHEMA; }
  public Object get(int _field) {
    switch (_field) {
    case 0: return url;
    case 1: return content;
    case 2: return parsedContent;
    case 3: return outlinks;
    case 4: return metadata;
    default: throw new AvroRuntimeException("Bad index");
    }
  }
  @SuppressWarnings(value="unchecked")
  public void put(int _field, Object _value) {
    if(isFieldEqual(_field, _value)) return;
    getStateManager().setDirty(this, _field);
    switch (_field) {
    case 0:url = (Utf8)_value; break;
    case 1:content = (ByteBuffer)_value; break;
    case 2:parsedContent = (GenericArray<Utf8>)_value; break;
    case 3:outlinks = (Map<Utf8,Utf8>)_value; break;
    case 4:metadata = (Metadata)_value; break;
    default: throw new AvroRuntimeException("Bad index");
    }
  }
  public Utf8 getUrl() {
    return (Utf8) get(0);
  }
  public void setUrl(Utf8 value) {
    put(0, value);
  }
  public ByteBuffer getContent() {
    return (ByteBuffer) get(1);
  }
  public void setContent(ByteBuffer value) {
    put(1, value);
  }
  public GenericArray<Utf8> getParsedContent() {
    return (GenericArray<Utf8>) get(2);
  }
  public void addToParsedContent(Utf8 element) {
    getStateManager().setDirty(this, 2);
    parsedContent.add(element);
  }
  public Map<Utf8, Utf8> getOutlinks() {
    return (Map<Utf8, Utf8>) get(3);
  }
  public Utf8 getFromOutlinks(Utf8 key) {
    if (outlinks == null) { return null; }
    return outlinks.get(key);
  }
  public void putToOutlinks(Utf8 key, Utf8 value) {
    getStateManager().setDirty(this, 3);
    outlinks.put(key, value);
  }
  public Utf8 removeFromOutlinks(Utf8 key) {
    if (outlinks == null) { return null; }
    getStateManager().setDirty(this, 3);
    return outlinks.remove(key);
  }
  public Metadata getMetadata() {
    return (Metadata) get(4);
  }
  public void setMetadata(Metadata value) {
    put(4, value);
  }
}
