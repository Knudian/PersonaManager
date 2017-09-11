package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IMediaFileDAO;
import PersonaManager.Model.MediaFile;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class MediaFileDAO extends AbstractDAO implements IMediaFileDAO {

    public MediaFileDAO() {
        super();
    }

    @Override
    public MediaFile create(MediaFile mediaFile) {
        objectId = sessionFactory.getCurrentSession().save(mediaFile);
        sessionFactory.getCurrentSession().refresh(mediaFile);
        return mediaFile;
    }

    @Override
    public MediaFile getById(long id) {
        return sessionFactory.getCurrentSession().get(MediaFile.class, id);
    }

    @Override
    public MediaFile getByFileName(String filename) {
        String queryString = "SELECT m FROM MediaFile m WHERE filename='"+filename +"'";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        return this.getById(query.getFirstResult());
    }

    @Override
    public void delete(MediaFile mediaFile) {
        sessionFactory.getCurrentSession().remove(mediaFile);
    }
}
