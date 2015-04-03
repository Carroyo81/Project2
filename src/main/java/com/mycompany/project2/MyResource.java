package com.mycompany.project2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("AllSites")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String viewWebsite() {
        Manager m = new Manager();
        List<Favorites> favor = m.getFavWeb();
        return favor.toString();

    }

    @Path("cat")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getWebsites(@QueryParam("category") String category) {
        Manager m = new Manager();
        List<Favorites> favor = m.getFavWeb();
        List<Favorites> newFav = new ArrayList();

        for (int x = 0; x < favor.size(); x++) {
            for (Favorites f : favor) {
                if (f.getCategory().equals(category)) {
                    newFav.add(f);
                }
                 
            }
           return newFav.toString();
           
        }

        return "Category not found";
    }

    @Path("urlInput")
    @POST
    public String createWebsite(@BeanParam urlInput newUrl) throws IOException {

        FileWriter fw = new FileWriter("Favorites.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter pr = new PrintWriter(bw)) {
            pr.println(newUrl.getUrl() + "," + newUrl.getCategory());
        }

        return "Name " + newUrl.getUrl() + "   Category " + newUrl.getCategory() + "New url was entered";
    }
}
