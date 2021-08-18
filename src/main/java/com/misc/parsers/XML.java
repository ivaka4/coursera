package com.misc.parsers;


import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;


@NoArgsConstructor
//@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class XML {

   private JAXBContext jaxbContext;
   @Autowired
    private Environment env;

    @SneakyThrows
    public <T> void toFile(Object obj, Class<T> clazz, String fileName, String filePath) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        m.marshal(obj,new File(env.getProperty(filePath)+ fileName + ".xml"));
    }

    @SneakyThrows
    public <T> T fromFile(String fileName,Class<T> clazz) throws JAXBException {

        jaxbContext = JAXBContext.newInstance(clazz);
        return clazz.cast(jaxbContext
                .createUnmarshaller()
                .unmarshal(new FileReader(fileName)));

    }
}
