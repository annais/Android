package com.example.anais.todoturismo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Anais on 29/02/2016.
 */
public class RssParserDom {
    private URL rssUrl;

    public RssParserDom(String url)
    {
        try
        {
            this.rssUrl = new URL(url);
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Sitio> parse()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        ArrayList<Sitio> Sitios = new ArrayList<Sitio>();

        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(this.getInputStream());
            Element root = dom.getDocumentElement();
            NodeList items = root.getElementsByTagName("monumento");

            for (int i=0; i<items.getLength(); i++)
            {
                Sitio Sitio = new Sitio();

                Node item = items.item(i);
                NodeList datosSitio = item.getChildNodes();

                for (int j=0; j<datosSitio.getLength(); j++)
                {
                    Node dato = datosSitio.item(j);
                    String etiqueta = dato.getNodeName();

                    if (etiqueta.equals("title"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setNombre(texto);
                    }
                    else if (etiqueta.equals("image"))
                    {
                        Sitio.setImagen(dato.getFirstChild().getNodeValue());
                    }
                    else if (etiqueta.equals("description"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setDescripcion(texto);
                    }else if (etiqueta.equals("horario"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setHorario(texto);
                    }else if (etiqueta.equals("price"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setPrecio(texto);
                    }else if (etiqueta.equals("address"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setDirecion(texto);
                    }else if (etiqueta.equals("phone"))
                    {
                        String texto = obtenerTexto(dato);

                        Sitio.setTlf(texto);
                    }
                }

                Sitios.add(Sitio);
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }

        return Sitios;
    }

    private String obtenerTexto(Node dato)
    {
        StringBuilder texto = new StringBuilder();
        NodeList fragmentos = dato.getChildNodes();

        for (int k=0;k<fragmentos.getLength();k++)
        {
            texto.append(fragmentos.item(k).getNodeValue());
        }

        return texto.toString();
    }

    private InputStream getInputStream()
    {
        try
        {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
