package PersonaManager.Service.Interface;

import PersonaManager.Model.MediaFile;

public interface IMediaFileService {

    /**
     * Allows to create a MediaFile Entry
     *
     * @param mediaFile MediaFile : the entry to save
     * @return MediaFile : the saved entry
     */
    public MediaFile create(MediaFile mediaFile);

    /**
     * Allows to get a MediaFile Entry by its ID
     *
     * @param id long : the entry's ID
     * @return MediaFile : the entry itself
     */
    public MediaFile getById(long id);


    /**
     * Allows to delete a MediaFile entry
     *
     * @param mediaFile MediaFile : the entry to delete
     */
    public void delete(MediaFile mediaFile);
}
