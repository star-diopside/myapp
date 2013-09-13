package jp.myapp.service.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class AutoCloseXMLStreamWriter implements AutoCloseable {

    private XMLStreamWriter writer;

    public AutoCloseXMLStreamWriter(XMLStreamWriter writer) {
        this.writer = writer;
    }

    @Override
    public void close() throws XMLStreamException {
        this.writer.close();
    }

    public XMLStreamWriter getInstance() {
        return this.writer;
    }
}
