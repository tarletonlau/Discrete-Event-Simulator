import java.util.Map;
import java.util.Optional;

class KeyableMap<V extends Keyable> implements Keyable {
    private final String key;
    private final ImmutableMap<String, V> map;

    KeyableMap(String key) {
        this.key = key;
        this.map = new ImmutableMap<>();
    }

    KeyableMap(String key, ImmutableMap<String, V> map) {
        this.key = key;
        this.map = map;
    }

    public KeyableMap<V> put(V item) {
        ImmutableMap<String, V> updatedMap = this.map.put(item.getKey(), item);
        return new KeyableMap<>(this.key, updatedMap);
    }

    public Optional<V> get(String key) {
        return this.map.get(key);
    }

    public ImmutableMap<String, V> getMap() {
        return this.map;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    public String toString() {
        String out = "";
        for (Map.Entry<String, V> entry : this.map) {
            if (out.length() > 0) {
                out += ", ";
            }
            out += entry.getValue().toString();
        }
        return String.format("%s: {%s}", this.key, out);
    }

}

