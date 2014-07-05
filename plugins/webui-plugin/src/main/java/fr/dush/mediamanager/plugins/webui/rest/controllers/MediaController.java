package fr.dush.mediamanager.plugins.webui.rest.controllers;

import fr.dush.mediamanager.dao.media.IMediaDAO;
import fr.dush.mediamanager.dao.mediatech.IRecoveryDAO;
import fr.dush.mediamanager.domain.media.Recovery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

/**
 * Generic controls on medias...
 *
 * @author Thomas Duchatelle
 */
@Controller

@RequestMapping("/medias")
public class MediaController {

    @Inject
    private IMediaDAO mediaDAO;

    @Inject
    private IRecoveryDAO recoveryDAO;

    /** Get dynamically list of know genres */

    @RequestMapping("/genres.json")
    @ResponseBody
    public Set<String> findAllGenres() {
        return mediaDAO.findAllGenres();
    }

    /** Get list of interrupted media */
    @GET
    @Path("/inProgress.json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recovery> findRecoverableMedia() {
        return recoveryDAO.findAll();
    }
}
