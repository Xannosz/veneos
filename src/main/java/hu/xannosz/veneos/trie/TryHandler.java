package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.html.structure.Page;

public interface TryHandler {
    Douplet<Integer, Page> handleRequest(String id, RequestBody body);
}
