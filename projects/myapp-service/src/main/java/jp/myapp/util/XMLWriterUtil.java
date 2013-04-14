package jp.myapp.util;

import java.io.OutputStream;
import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class XMLWriterUtil {

    private String indentString = StringUtils.EMPTY;
    private String lineSeparator = SystemUtils.LINE_SEPARATOR;

    private XMLOutputFactory factory = XMLOutputFactory.newInstance();

    public XMLWriterUtil(String indentString) {
        this.indentString = indentString;
    }

    public void write(OutputStream stream) throws XMLStreamException {
        try (AutoCloseXMLStreamWriter writer = new AutoCloseXMLStreamWriter(this.factory.createXMLStreamWriter(stream))) {
            this.write(writer.getInstance());
        }
    }

    public void write(OutputStream stream, String encoding) throws XMLStreamException {
        try (AutoCloseXMLStreamWriter writer = new AutoCloseXMLStreamWriter(this.factory.createXMLStreamWriter(stream, encoding))) {
            this.write(writer.getInstance());
        }
    }

    public void write(Result result) throws XMLStreamException {
        try (AutoCloseXMLStreamWriter writer = new AutoCloseXMLStreamWriter(this.factory.createXMLStreamWriter(result))) {
            this.write(writer.getInstance());
        }
    }

    public void write(Writer stream) throws XMLStreamException {
        try (AutoCloseXMLStreamWriter writer = new AutoCloseXMLStreamWriter(this.factory.createXMLStreamWriter(stream))) {
            this.write(writer.getInstance());
        }
    }

    public void write(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartDocument("UTF-8", "1.0");
        this.writeBeansElement(writer, 0);
        writer.writeEndDocument();
    }

    private void writeBeansElement(XMLStreamWriter writer, int indentCount) throws XMLStreamException {

        writeIndent(writer, indentCount);
        writer.writeStartElement("beans");
        writer.writeNamespace("", "http://www.springframework.org/schema/beans");
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        writer.writeNamespace("aop", "http://www.springframework.org/schema/aop");
        writer.writeNamespace("tx", "http://www.springframework.org/schema/tx");
        writer.writeAttribute(
                "xsi",
                "http://www.w3.org/2001/XMLSchema-instance",
                "schemaLocation",
                "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd");

        writeLoggingBeanElement(writer, indentCount + 1);
        writeConfigElement(writer, indentCount + 1);

        writeIndent(writer, indentCount);
        writer.writeEndElement();
    }

    private void writeLoggingBeanElement(XMLStreamWriter writer, int indentCount) throws XMLStreamException {

        writeIndent(writer, indentCount);
        writer.writeComment("ログ出力インターセプター");
        writeIndent(writer, indentCount);
        writer.writeEmptyElement("bean");
        writer.writeAttribute("id", "logging");
        writer.writeAttribute("class", "jp.myapp.interceptor.LoggingInterceptor");
    }

    private void writeConfigElement(XMLStreamWriter writer, int indentCount) throws XMLStreamException {

        writeIndent(writer, indentCount);
        writer.writeComment("AOP定義");
        writeIndent(writer, indentCount);
        writer.writeStartElement("aop", "config", "");

        writeAdvisorElement(writer, indentCount + 1);

        writeIndent(writer, indentCount);
        writer.writeEndElement();
    }

    private void writeAdvisorElement(XMLStreamWriter writer, int indentCount) throws XMLStreamException {

        writeIndent(writer, indentCount);
        writer.writeEmptyElement("aop", "advisor", "");
        writer.writeAttribute("advice-ref", "logging");
        writer.writeAttribute("pointcut", "execution(public * jp.myapp..*(..))");
    }

    private void writeIndent(XMLStreamWriter writer, int indentCount) throws XMLStreamException {

        writer.writeCharacters(this.lineSeparator);

        for (int i = 0; i < indentCount; i++) {
            writer.writeCharacters(this.indentString);
        }
    }
}
