package com.jjnordin.mudslinger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Handles loading, saving and updating world objects.
 */
public class WorldStorage {
    private List<World> allWorlds = new ArrayList<World>();

    public void load() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("worldstorage.xml");

        Element root = document.getRootElement();
        Element worlds = root.element("worlds");
        if(worlds == null) {
            return;
        }

        Iterator<Element> itr = worlds.elementIterator("world");
        while(itr.hasNext()) {
            Element e = itr.next();
        }
    }
}
