package at.htl.movietheater.boundary;

import at.htl.movietheater.control.MovieRepository;
import at.htl.movietheater.control.ShowRepository;
import at.htl.movietheater.control.TheaterRepository;
import at.htl.movietheater.entity.Show;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("show")
public class ShowEndpoint {

    @Inject
    MovieRepository movieRepository;

    @Inject
    TheaterRepository theaterRepository;

    @Inject
    ShowRepository showRepository;


    @POST
    public Response create(JsonValue json, @Context UriInfo uri) {

        if (json.getValueType().equals(JsonValue.ValueType.ARRAY)) {
            for (JsonValue element : json.asJsonArray()) {
                Show show = new Show(
                        movieRepository
                                .findByTitle(
                                        element
                                            .asJsonObject()
                                            .getString("movie")),
                        theaterRepository
                                .findByName(
                                        element
                                                .asJsonObject()
                                                .getString("theater")
                                ),
                        null,
                        null
                );
                showRepository.save(show);
            }
        } else if (json.getValueType().equals(JsonValue.ValueType.OBJECT)){

            Show show = new Show(
                    movieRepository
                            .findByTitle(
                                    json
                                            .asJsonObject()
                                            .getString("movie")),
                    theaterRepository
                            .findByName(
                                    json
                                            .asJsonObject()
                                            .getString("theater")
                            ),
                    null,
                    null
            );
        }
        return null;
    }

    @Path("/{id}")
    public Response get(long id) {
        return null;
    }
}
