package Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class KeyValueComboboxModel extends AbstractListModel implements ComboBoxModel, Map<String, String> {

    private TreeMap<String,String> values = new TreeMap<String,String>();

    private Map.Entry<String, String> selectedItem = null;

    public Object getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Object anItem) {
        this.selectedItem = (java.util.Map.Entry<String, String>) anItem;
        fireContentsChanged(this, -1, -1);
    }

    public Object getElementAt(int index) {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(values.entrySet());
        return list.get(index);
    }



    public int getSize() {
        return values.size();
    }

    public void clear() {
        values.clear();
    }

    public boolean containsKey(Object key) {
        return values.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

    public Set<java.util.Map.Entry<String, String>> entrySet() {
        return values.entrySet();
    }

    public String get(Object key) {
        return values.get(key);
    }

    public Set<String> keySet() {
        return values.keySet();
    }

    public String put(String key, String value) {
        return values.put(key, value);
    }

    public String remove(Object key) {
        return values.remove(key);
    }

    public int size() {
        return values.size();
    }

    public Collection<String> values() {
        return values.values();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public void putAll(Map<? extends String, ? extends String> m) {
        values.putAll(m);
    }



	
}