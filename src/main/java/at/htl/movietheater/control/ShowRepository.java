package at.htl.movietheater.control;

import at.htl.movietheater.entity.Show;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShowRepository {

     @Inject
     EntityManager em;

    public Show save(Show show) {
        return em.merge(show);
    }

    /**
     * use a NamedQuery "Show.findLastShow" to retrieve the last show stored in the db
     * when the NoResultException is thrown, return null
     *
     * @return the last show stored in the db
     */
    public Show findLastShow() {
        return null;
    }

    /**
     * use a built-in method provided by the entity manger to find a show by its id
     *
     * @param id
     * @return the retrieved show
     */
    public Show findById(long id) {
        return null;
    }
}
